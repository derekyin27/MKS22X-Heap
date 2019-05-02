public class MyHeap{
  private static void swap(int[] data, int s, int f){
    int start = data[s];
    data[s] = data[f];
    data[f] = start;
  }
  private static void pushDown(int[]data,int size,int index){
    while (true){
      int left = index * 2 + 1;
      int right = left + 1;
      if (right < size){
        if (data[left] > data[right] && data[left] > data[index]){
          swap(data, index, left);
          index = left;
        }
        else return;

        else if (data[right] > data[index]){
          swap(data, index, right);
          index = right;
        }
        else return;
      }
      else if (right == size){
        if (data[left]>data[index]){
          swap(data, index, left);
          index = left;
        }
      }
      return;
    }
  }
  private static void pushUp(int[]data,int index){
    while (index > 0){
      int parent = (index-1)/2;
      if (data[parent] < data[index]){
        swap(data, parent, index);
        index = parent;
      }
      else return;
    }

  }
  public static void heapify(int[] data){
    for (int i = data.length-1; i >= 0; i--){
      pushDown(data, data.length, i);
    }
  }
  public static void heapsort(int[] data){

  }

}
