package company.nextiva.interfaces;

import java.util.Arrays;
import java.util.List;

public class Implementation implements InterfaceC {

    @Override
    public void methodFromInterfaceA() {

    }

    @Override
    public void methodFromInterfaceB() {

    }

    @Override
    public void methodFromInterfaceC() {

        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
