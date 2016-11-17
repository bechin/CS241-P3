public class Merge implements SortAlgorithm{

  private double[] array;
  private SortTimer timer;

  public void sort(double[] a, SortTimer t){
    array = a;
    timer = t;
    a = mergesort(0, array.length-1);
  }

  private double[] mergesort(int start, int end){
    if(end-start == 0)
      return new double[] {array[start]};
    int mid = (start + end)/2;
    double[] sublist1 = mergesort(start, mid);
    double[] sublist2 = mergesort(mid + 1, end);
    return merge(sublist1, sublist2);
  }

  private double[] merge(double[] sublist1, double[] sublist2){
    double[] result = new double[sublist1.length + sublist2.length];
    int p = 0, q = 0;
    for(int i = 0; i < result.length; i++){
      if(p == sublist1.length)
        result[i] = sublist2[q++];
      else if(q == sublist2.length)
        result[i] = sublist1[p++];
      else{
        timer.comparisons++;
        if(sublist1[p] <= sublist2[q])
          result[i] = sublist1[p++];
        else
          result[i] = sublist2[q++];
      }
      timer.moves++;
    }
    return result;
  }

}
