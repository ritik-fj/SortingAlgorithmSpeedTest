/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sortingalgorithmscsv;

/**
 *
 * @author Ritik
 */

    class Book implements Comparable<Book> {
        //book details

        int id;
        String title;
        String author;
        double rating;
        String isbn;
        double isbn13;

        public Book(int id, String title, String author, double rating, String isbn, double isbn13) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.rating = rating;
            this.isbn = isbn;
            this.isbn13 = isbn13;
        }

        @Override
        public int compareTo(Book o) {
            //compare books by rating
            if (this.rating > o.rating) {
                return -1;
            } else if (this.rating < o.rating) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "AVERAGE RATING: " + rating + " ID: " + id + " TITLE: " + title + " AUTHOR: " + author + " ISBN: " + isbn + " ISBN13: " + isbn13;
            
        }
    }

