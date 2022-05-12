package ru.avalon.jdev_110;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*
           Excpected output:
            true
            mustBeDeleted
            mustBeDeleted
            ===============
            true
            false
            0
            1
            2
            3
            qwe
            asd
            zxc
            ===============
            zxc
            asd
            qwe
            3
            2
            1
            0
            ===============
            7
         */

        CustomDoubleLinkedList<String> test = new CustomDoubleLinkedList<>();
        List<String> strings = Arrays.asList("qwe", "asd" , "zxc");

        System.out.println(test.isEmpty());

        test.addToTail("1");
        test.addToTail("2");
        test.addToTail("3");
        test.addToHead("0");
        test.addToHead("mustBeDeleted");
        test.addToTail("mustBeDeleted");

        System.out.println(test.peekElementFromHead());
        System.out.println(test.peekElementFromTail());

        System.out.println("===============");

        System.out.println(test.contains("0"));
        System.out.println(test.contains("mustBeDeleted"));

        test.addElementsFromCollectionToTail(strings);

        test.printAll();
        System.out.println("===============");
        test.printFromEnd();
        System.out.println("===============");
        System.out.println(test.getSize());

    }

}
