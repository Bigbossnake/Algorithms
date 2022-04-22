package com.microsoft.interviews;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise02 {

    public String solution(String dates) {
       String answer = "NO FILES";

       String[] filesDetails = dates.split("\n");
       int maxFileSize = (int) (14 * Math.pow(2,20));

       for (int i = 0; i < filesDetails.length; i++) {
           System.out.println(filesDetails[i]);
           String[] currentFileinfo = filesDetails[i].trim().split("\\s+");;

           String owner = currentFileinfo[0];
           String perm  = currentFileinfo[1];
           String date  = currentFileinfo[2] + " " + currentFileinfo[3] + " " + currentFileinfo[4] ;
           String size  = currentFileinfo[5];
           String name  = currentFileinfo[6];

           int filesize = Integer.parseInt(size);
           if (perm.contains("x") &&
                   owner.equalsIgnoreCase("admin") &&
                   filesize < maxFileSize) {

               if (answer.equalsIgnoreCase("NO FILES")) {
                   answer = date;
                   continue;
               }

               Date fileDate = null;
               Date answerDate = null;

               try {
                   fileDate = new SimpleDateFormat("dd MMM yyyy").parse(date);
                   answerDate = new SimpleDateFormat("dd MMM yyyy").parse(answer);

                   if (fileDate.before(answerDate)) {
                       answer = date;
                   }

               } catch (ParseException e) {
                   e.printStackTrace();
               }
           }
       }

       return answer;
    }

    public static void main(String args[]) {
        String testCase = "admin  -wx 29 Sep 1983        833 source.h\nadmin  r-x 23 Jun 2003     854016 blockbuster.mpeg\nnadmin  --x 02 Jul 1997        821 delete-this.py\nadmin  -w- 15 Feb 1971      23552 library.dll\nadmin  --x 15 May 1979  645922816 logs.zip\njane   --x 04 Dec 2010      93184 old-photos.rar\njane   -w- 08 Feb 1982  681574400 important.java\nadmin  rwx 26 Dec 1952   14680064 to-do-list.txt";
        Exercise02 exercise = new Exercise02();

        exercise.solution(testCase);
    }
}
