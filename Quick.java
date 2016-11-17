public class Quick implements SortAlgorithm{

  private double[] array;
  private SortTimer timer;

  public void sort(double[] a, SortTimer t){
    array = a;
    timer = t;
    quicksort(0, array.length-1);
  }

  private void quicksort(int start, int end){
    if(start < end){
      int pivot = partition(start, end);
      quicksort(start, pivot-1);
      quicksort(pivot+1, end);
    }
  }

  private int partition(int start, int end){
    int finalPivotIndex = start;
    for(int i = start; i < end; i++){
      timer.comparisons++;
      if(array[i] < array[end]){
        swap(finalPivotIndex, i);
        timer.moves += 3;
        finalPivotIndex++;
      }
    }
    swap(finalPivotIndex, end);
    timer.moves += 3;
    return finalPivotIndex;
  }

  private void swap(int x, int y){
    double temp = array[x];
    array[x] = array[y];
    array[y] = temp;
  }

}
