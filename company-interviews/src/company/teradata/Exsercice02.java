package company.teradata;

import java.util.ArrayList;
import java.util.List;

public class Exsercice02 {

   public int getNthElement(List<Integer> input, int nthPosition) {

      int offset = (input.size() - nthPosition);
      int result = -1;

      if (offset < 0) {
         return  result;
      }

      for (int i = 0; i <= offset; i++) {

         if (i < offset) {
            result = input.get(offset);
         }
      }

      return result;
   }

   public static void main(String args[]) {
      Exsercice02 exsercice02 = new Exsercice02();
      List<Integer> input = new ArrayList<>();
      int nthPosition = 2;

      input.add(5);
      input.add(4);
      input.add(3);
      input.add(2);
      input.add(1);

      System.out.println(exsercice02.getNthElement(input, nthPosition));
   }
}
