package main.interview.pgms;

import java.util.HashSet;

public class FindCommonElementsInTwoArr {

  public static void main(String[] args) {
    int[] numArr1 = { 21, 34, 41, 22, 35 };
    int[] numArr2 = { 61, 34, 45, 21, 11 };
    HashSet<Integer> hs = new HashSet<>();

    for (int lp1 = 0; lp1 < numArr1.length; lp1++) {
      for (int lp2 = 0; lp2 < numArr2.length; lp2++) {
        if (numArr1[lp1] == numArr2[lp2]) {
          hs.add(numArr1[lp1]);
          break;
        }
      }
    }

    System.out.println("Common elements are :" + hs);
  }
}
