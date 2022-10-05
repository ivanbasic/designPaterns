package ivanbasic;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class dp_3_04_Iterator implements dp_Demo {
    public void main(String[] args) {

        List<String> fruits = List.of("Apple", "Banana", "Orange");

        System.out.print("\nA) ");
        Iterator<String> itr = fruits.iterator();
        while (itr.hasNext()) { System.out.print(itr.next() + " ");  }

        System.out.print("\nB) ");
        fruits.iterator().forEachRemaining(str -> { System.out.print(str + " "); });

        System.out.print("\nC) ");
        fruits.stream().forEach(str -> { System.out.print(str + " "); });

        System.out.print("\nD) ");
        Consumer<String> printIt = str -> {  System.out.print(str + " "); };
        fruits.stream().forEach( printIt );

    }
}


