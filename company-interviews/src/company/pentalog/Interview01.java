package company.pentalog;

/*
From a given list of names
return a list of names
that are repeated an odd (like 1,3,5,etc) quantity of times
for example:
give a list composed by: "Tim", "John", "John", "Adam", "Adam", "Adam"
your method must return: "Tim", "Adam"
*/
/*
here's some convenience data to test this exercise:
"Derren", "Tyra", "Killian", "Ayomide", "Myrtle", "Derren", "Heena", "Aqeel",
"Killian", "Cassian", "Ameerah", "Cassian", "Myrtle", "Heena", "Pheobe", "Killian",
"Aqeel",  "Aqeel",  "Derren", "Pheobe", "Derren", "Ameerah", "Cassian", "Pheobe",
"Tyra",  "Heena", "Heena", "Karl", "Pheobe", "Derren"
 */

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

public class Interview01 {

    public static void main(String args[]) {

        final var names = List.of("Derren", "Tyra", "Killian", "Ayomide", "Myrtle", "Derren", "Heena", "Aqeel",
                "Killian", "Cassian", "Ameerah", "Cassian", "Myrtle", "Heena", "Pheobe", "Killian",
                "Aqeel", "Aqeel", "Derren", "Pheobe", "Derren", "Ameerah", "Cassian", "Pheobe",
                "Tyra", "Heena", "Heena", "Karl", "Pheobe", "Derren");

        List<String> nameList = new ArrayList();
        Hashtable<String,Integer> namesDictironay = new Hashtable<>();

        names.stream().forEach(element -> {

            if (!namesDictironay.contains(element)) {
                namesDictironay.put(element, 1);
            }

            else {
                int numberOfTimes = namesDictironay.get(element) + 1;
                namesDictironay.put(element, numberOfTimes);
            }
        } );

        List<String> result = new ArrayList();
        namesDictironay.forEach((k,v) -> {

        });

        //names.stream().collect(Collectors.groupingBy())

    }
}
