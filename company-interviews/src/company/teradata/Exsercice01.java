package company.teradata;

import java.util.Arrays;

public class Exsercice01 {

   public void findSummatory(int input1[], int input2[], int result) {

      Arrays.sort(input1);
      Arrays.sort(input2);

      for (int i = 0; i < input1.length; i++) {

         for (int j = 0; j < input2.length; j++) {

            if (input1[i] + input2[j] == result) {
               System.out.println("(" + input1[i] + " , " + input2[j] + ")");
            } else if (input1[i] + input2[j] > result) {
               break;
            }
         }
      }
   }

   public static void main (String args[]) {
      int[] input1 = {1, 2, 4, 5, 7};
      int[] input2 = {5, 6, 3, 4, 8};
      int result = 9;

      Exsercice01 exsercice01 = new Exsercice01();
      exsercice01.findSummatory(input1, input2, result);
   }

}
