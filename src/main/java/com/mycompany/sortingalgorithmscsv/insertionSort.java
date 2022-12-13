/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sortingalgorithmscsv;

import java.util.List;

/**
 *
 * @author Ritik 
 * @param <T>
 */
public class insertionSort<T extends Comparable<? super T>> implements Runnable {

    private final List<T> list;

    public insertionSort(List<T> list) {
        this.list = list;
    }

    // INSERTION SORT
    @Override
    public void run() {
        try {
            // sort the list using insertion sort
            for (int i = 1; i < list.size(); i++) {
                T key = list.get(i);
                int j = i - 1;
                // move elements of list that are greater than key, to one position ahead of their current position
                while (j >= 0 && list.get(j).compareTo(key) > 0) {
                    list.set(j + 1, list.get(j));
                    j = j - 1;
                }
                // place element at its correct position
                list.set(j + 1, key);
            }
        } catch (Exception e) {
        } finally{
            System.out.println("Sort Complete");
        }

    }
}
