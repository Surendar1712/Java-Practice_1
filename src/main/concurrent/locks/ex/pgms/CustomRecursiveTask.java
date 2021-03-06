package main.concurrent.locks.ex.pgms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<Integer> {

  /**
   * 
  */
  private static final long serialVersionUID = 1L;

  private int[] arr;

  private static final int THRESHOLD = 5;

  public CustomRecursiveTask(int[] arr) {
    this.arr = arr;
  }

  @Override
  protected Integer compute() {
    if (arr.length > THRESHOLD) {
      return ForkJoinTask.invokeAll(createSubtasks()).stream().mapToInt(ForkJoinTask::join).sum();
    } else {
      return processing(arr);
    }
  }

  private Collection<CustomRecursiveTask> createSubtasks() {
    List<CustomRecursiveTask> dividedTasks = new ArrayList<>();
    dividedTasks.add(new CustomRecursiveTask(Arrays.copyOfRange(arr, 0, arr.length / 2)));
    dividedTasks.add(new CustomRecursiveTask(Arrays.copyOfRange(arr, arr.length / 2, arr.length)));
    return dividedTasks;
  }

  private Integer processing(int[] arr) {
    return Arrays.stream(arr).filter(a -> a > 10 && a < 27).map(a -> a * 10).sum();
  }

  public static void main(String[] args) {
    int[] numArr = { 5, 3, 10, 60, 5, 3, 15, 9, 54, 21, 10, 7, 62, 47, 25 };
    CustomRecursiveTask rt = new CustomRecursiveTask(numArr);
    ForkJoinPool fjp = new ForkJoinPool();
    Integer result = fjp.invoke(rt);
    System.out.println("Result :" + result);
  }
}
