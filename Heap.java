public class Heap implements SortAlgorithm{

  private double[] heap;
  private SortTimer timer;

  public void sort(double[] a, SortTimer t){
    heap = a;
    timer = t;
    heapify();
    for(int i = heap.length-1; i > 0;){
      timer.moves += 3;
      swap(0,i);
      i--;
      siftDown(0,i);
    }
  }

  private void heapify(){
    for(int index = heap.length/2-1; index >= 0; index--){
      siftDown(index, heap.length-1);
    }
  }

  private void siftDown(int start, int end){
    int left = start*2+1;
    int right = start*2+2;
    int bigger;
    timer.comparisons += 2;
    if(left <= end && heap[left] > heap[start])
      bigger = left;
    else
      bigger = start;
    if(right <= end && heap[right] > heap[bigger])
      bigger = right;
    if(bigger != start){
      timer.moves += 3;
      swap(start, bigger);
      siftDown(bigger, end);
    }
  }

  private void swap(int x, int y){
    double temp = x;
    heap[x] = heap[y];
    heap[y] = temp;
  }
}
