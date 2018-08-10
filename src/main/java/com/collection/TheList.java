package com.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import java.util.List;
import java.util.function.ToIntFunction;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TheList {

    @Test
    public void addAll() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(10, 20, 30, 40));
        list.addAll(Arrays.asList(10, 20, 30, 40, 50));
        assertEquals(list.size(), 9);
    }

    @Test
    public void toArray() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] array = list.toArray(new Integer[]{});
        assertArrayEquals(list.toArray(), array);
    }

    @Test
    public void sort() {
        List<Integer> list = new ArrayList<>();
        list.sort(Comparator.comparingInt(i -> i));
        System.out.println(list);
    }

    @Test
    public void subList() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90));
        list = list.subList(5, list.size());
        assertEquals(list, Arrays.asList(60, 70, 80, 90));
    }

    @Test
    public void listEx1() {
        ArrayList<Integer> list = new ArrayList<Integer>(10);
        list.add(new Integer(5));
        list.add(new Integer(4));
        list.add(new Integer(3));
        list.add(new Integer(2));
        list.add(new Integer(1));
        list.add(new Integer(0));
        list.add(new Integer(3));

        List list2 = list.subList(1,4);
        System.out.println(list2);
        assertTrue(list.containsAll(list2));

        list.retainAll(list2);
        System.out.println(list);

        for(Integer value: list) {
            assertTrue(list.contains(value));
        }
    }

    @Test
    public void subString() {
        final int LIMIT = 10;
        String source = "0123456789abcdefghiABCDEFGHIJ!@#$%^&*()ZZZ";
        int length = source.length();
        List list = new ArrayList();

        for(int i=0; i<length; i+=LIMIT) {
            if(i + LIMIT < length) {
                list.add(source.substring(i, i + LIMIT));
            } else {
                list.add(source.substring(i));
            }
        }

        System.out.println(list);
        assertTrue(list.size()==5);
    }

}
