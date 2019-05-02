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
    heapify(data);
    for(int i = data.length - 1; i >= 0; i--){
            swap(data, 0, i);
            pushDown(data, i ,0);
    }
  }
public static void main(String[] args) {
  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        MyHeap.heapsort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}
}
}
