/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.sortingalgorithmscsv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ritik
 */
public class SortingAlgorithmsCSV {

    //read file 
    public static void readFile(String filename, List<Book> list) {
        try ( BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            //read first line
            br.readLine();
            //read other lines
            while ((line = br.readLine()) != null) {
                //split the line by commas
                String[] values = line.split(",");
                //create book object
                Book book = new Book(Integer.parseInt(values[0]), values[1], values[2], Double.parseDouble(values[3]), values[4], Double.parseDouble(values[5]));
                //add the book to list
                list.add(book);
            }
        } catch (IOException e) {
            System.out.println("File cannot be read");
            System.exit(1);
        }
    }

    static void userInterface() {
        //User Interface
        System.out.println("""
                           \n\n
                           -----------------------------------------------------
                                             SORTING PROGRAM
                           -----------------------------------------------------
                           Press 1 to show the file before Sorting.
                           Press 2 to do INSERTION SORT on Arraylist 
                           Press 3 to do BUBBLE SORT on Arraylist 
                           Press 4 to do BUILT-IN COLLECTIONS SORT on Arraylist
                           Press 5 to do Empirical testing.
                           
                           Enter 0 to exit the program.
                           """);
    }

    public static void main(String[] args) throws FileNotFoundException {

        // filename
        String filename = "C:\\Users\\Ritik\\Desktop\\assignment1\\books.csv";

        //lists for storing the books 
        List<Book> arrList1 = new ArrayList<>();
        List<Book> arrList2 = new ArrayList<>();
        List<Book> arrList3 = new ArrayList<>();
        List<Book> arrList4 = new ArrayList<>();

        //reads file to the lists
        readFile(filename, arrList1);
        readFile(filename, arrList2);
        readFile(filename, arrList3);
        readFile(filename, arrList4);

        // creating objects of the sorting algorithms and passing the arraylist to the contructors
        insertionSort insertion_al = new insertionSort(arrList1);
        bubbleSort bubble_al = new bubbleSort(arrList2);

        int option = 1;
        while (option > 0) {
            userInterface();
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            option = myObj.nextInt();  // Read user input
            switch (option) {

                case 1 -> {
                    System.out.println("\nArray list before sorting:\n ");
                    for (int i = 0; i < arrList1.size(); i++) {
                        System.out.println(arrList1.get(i));
                    }
                }
                case 2 -> {
                    insertion_al.run();
                    System.out.println("Array list after sorting with INSERTION SORT:\n ");
                    for (int i = 0; i < arrList1.size(); i++) {
                        System.out.println(arrList1.get(i));
                    }
                }
                case 3 -> {
                    bubble_al.run();
                    System.out.println("Array list after sorting with BUBBLE SORT:\n ");
                    for (int i = 0; i < arrList2.size(); i++) {
                        System.out.println(arrList2.get(i));
                    }
                }

                case 4 -> {
                    Collections.sort(arrList4);

                    System.out.println("Arraylist after sorting with COLLECTIONS SORT:\n ");
                    for (int i = 0; i < arrList4.size(); i++) {
                        System.out.println(arrList4.get(i));
                    }
                }

                case 5 -> {
                    // TEST FOR INSERTION SORT WITH ARRAYLIST
                    long start1 = System.currentTimeMillis();
                    for (int i = 0; i < 3; i++) {
                        Collections.shuffle(arrList1);
                        insertion_al.run();
                    }
                    long finish1 = System.currentTimeMillis();
                    long res1 = finish1 - start1;
                    System.out.println("\nARRAYLIST INSERTION SORT TEST DONE IN: " + res1 + " milliseconds\n");

                    // TEST FOR BUBBLE SORT WITH ARRAYLIST
                    long start2 = System.currentTimeMillis();
                    for (int i = 0; i < 3; i++) {
                        Collections.shuffle(arrList2);
                        bubble_al.run();
                    }
                    long finish2 = System.currentTimeMillis();
                    long res2 = finish2 - start2;
                    System.out.println("\nARRAYLIST BUBBLE SORT TEST DONE IN: " + res2 + " milliseconds\n");

                    // TEST FOR COLLECTIONS SORT WITH ARRAYLIST
                    long start5 = System.currentTimeMillis();
                    for (int i = 0; i < 3; i++) {
                        Collections.shuffle(arrList4);
                        Collections.sort(arrList4);
                        System.out.println("Sort Complete");
                    }
                    long finish5 = System.currentTimeMillis();
                    long res4 = finish5 - start5;
                    System.out.println("\nARRAYLIST COLLECTIONS TEST DONE IN: " + res4 + " milliseconds\n");

                    //display all results
                    System.out.println("Time taken for Insertion Sort = " + res1);
                    System.out.println("Time taken for Bubble Sort = " + res2);
                    System.out.println("Time taken for Collections Sort = " + res4);

                    if (res1 < res2 && res1 < res4) {
                        System.out.println("According to the above results, Insertion Sort is the fastest sorting algorithm.");
                    } else if (res2 < res1 && res2 < res4) {
                        System.out.println("According to the above results, Bubble Sort is the fastest sorting algorithm.");
                    } else if (res4 < res1 && res4 < res1) {
                        System.out.println("\nAccording to the above results, Collections Sort is the fastest sorting algorithm.");
                    }

                }

                default -> {
                }
            }

        }
    }
}
