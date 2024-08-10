package org.io;

/*
 * Create a class Book that has the following:
 * 
 * Attribute title, type String, visibility private
 * Attribute author, type String, visibility private
 * Attribute publisher, type String, visibility private
 * Attribute year, type String, visibility private
 * Method public void readBook(String filename)
 * Reads a CSV file given as parameter and stores the information
 * into the attributes, where the order is title, author, publisher, and year
 * Throws a FileNotFoundException if the file does not exist
 * Throws an IOException if there is an error reading the file
 * Overridden method public String toString() that returns a String object
 * <title> by <author>, published by <publisher> in <year>
 * 
 * The CSV file format is the following:
 * 
 * title,author,publisher,year
 * Harry Potter,J.K. Rowling,Bloomsbury Publishing,1997
 * The Lord of the Rings,J.R.R. Tolkien,Allen & Unwin,1954
 */

