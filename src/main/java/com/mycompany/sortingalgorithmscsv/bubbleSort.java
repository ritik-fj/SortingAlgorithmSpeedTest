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
public class bubbleSort <T extends Comparable<? super T>> implements Runnable {

    private final List<T> list;
    
    public bubbleSort(List<T> list) {
        this.list = list;
    }
    

    // BUBBLE SORT
    @Override
    public void run() {
        try{
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T key = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, key);
                }
            }
        }
        }
        catch(Exception e){}
        finally{
            System.out.println("Sort Complete");
        }
    }

}
