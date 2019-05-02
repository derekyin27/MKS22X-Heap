import java.util.*;
public class MyHeap{
  private static void swap(int[] data, int s, int f){
    int start = data[s];
    data[s] = data[f];
    data[f] = start;
  }
  private static void pushDown(int[]data,int size,int  > ndex){
    if (size > 2 * index + 2 && (data[2 * index + 1] > data[index] || data[2 * index + 2] > data[index])) {
      if (data[2 * index + 1] <= data[2 * index + 2]) {
        swap(data, index, 2 * index + 2);
        pushDown(data, size, 2 * index + 2);
      }
      else {
        swap(data, index, 2 * index + 1);
        pushDown(data, size, 2 * index + 1);
      }
    }
    else if (2 * index + 1 == size - 1 && size % 2 == 0) {
      if (data[index] < data[2 * index + 1]) {
        swap(data, index, 2 * index + 1);
      }
    }
  }
  private static void pushUp(int[]data,int index){
    if (data[(index - 1) / 2] >= data[index]){
        return;
      }
      else if (index == 0) {
        return;
      }
      swap(data, index, (index - 1) / 2);
      pushUp(data, (index - 1) / 2);

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
