//Ben Chin
//CS241
//Project3: Sorting
//Dr Mandayam Srinivas

import java.util.Random;

public class Sorts{

  public static void main(String[] args){
    new Sorts();
  }

  public Sorts(){
    String[] sorts = {"Insertion","Heap","Merge","Quick"};
    for(String sort: sorts){
      int highestPowerOfTen = 6;
      SortAlgorithm algorithm = new Insertion();
      switch(sort){
        case"Insertion":
          highestPowerOfTen = 5;
          break;
        case"Heap":
          algorithm = new Heap();
          break;
        case"Merge":
          algorithm = new Merge();
          break;
        case"Quick":
          algorithm = new Quick();
          break;
      }
      for(int i = 1; i <= highestPowerOfTen; i++){
        this.sort(algorithm, sort, i);
        System.out.println();
      }
      System.out.println("----------------------------------");
    }
  }//end constructor

  public void sort(SortAlgorithm algorithm, String name, int powerOfTen){
    long totalTime = 0, totalMoves = 0, totalComparisons = 0;
    Random random = new Random();
    for(int i = 0; i < 5; i++){
      double[] array = new double[(int)Math.pow(10,powerOfTen)];
      for(int j = 0; j < array.length; j++){
         array[j] = random.nextDouble();
//         System.out.println(array[j]);        //debug
      }
      SortTimer timer = new SortTimer();
      algorithm.sort(array, timer);
      totalTime += timer.getElapsedTime();
      totalMoves += timer.getMoves();
      totalComparisons += timer.getComparisons();
/*debug stuff
      System.out.println("--------------------------");
      for(double e: array){
         System.out.println(e);
      }
      System.out.println("\n\n");
//end debug stuff */
    }
    long avgTime = totalTime/5,
         avgMoves = totalMoves/5,
         avgComparisons = totalComparisons/5;
    System.out.printf(name + (int)Math.pow(10,powerOfTen) + "\n" +
                      "Time(micro)\tMoves\t\tComparisons\n" +
                     "%-16d%-16d%-16d\n",avgTime,avgMoves,avgComparisons);
  }

}
