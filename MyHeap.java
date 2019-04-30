public class MyHeap{
  private static void swap(int[] data, int s, int f){
    int start = data[s];
    data[s] = data[f];
    data[f] = start;
  }
  private static void pushDown(int[]data,int size,int index){
    if (size==0) return;
    else if (data[index] < data[index+2]){
      swap(data, index, index+2);
      pushDown(data, size-1, index++);
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

  }
  public static void heapsort(int[] data){

  }

}
