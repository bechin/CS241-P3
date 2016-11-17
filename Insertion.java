public class Insertion implements SortAlgorithm{

  public void sort(double[] a, SortTimer t){
    for(int i = 1; i < a.length; i++){
      for(int j = i; j > 0; j--){
        t.comparisons++;
        if(a[j] < a[j-1]){
          t.moves += 3;
          swap(a, j-1, j);
        }
        else
          break;
      }
    }
  }

  private void swap(double[] a, int x, int y){
    double temp = a[x];
    a[x] = a[y];
    a[y] = temp;
  }

}
