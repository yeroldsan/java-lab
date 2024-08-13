package org.io;

/*
 * Create a class Book that has the following:
 * 
 * Attribute title, type String, visibility private
 * Attribute author, type String, visibility private
 * Attribute publisher, type String, visibility private
 * Attribute year, type String, visibility private
 * Getter methods for all attributes
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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Book {
  private String title;
  private String author;
  private String publisher;
  private String year;

  public void readBook(String filename) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line = reader.readLine();
      if (line == null) {
        throw new IOException("File is empty");
      }

      String[] data = line.split(",");
      if (data.length != 4) {
        throw new IOException("Invalid file format. Expected 4 fields, got " + data.length + " fields.");
      }
      title = data[0].trim();
      author = data[1].trim();
      publisher = data[2].trim();
      year = data[3].trim();
    } catch (FileNotFoundException e) {
      throw new FileNotFoundException("File not found: " + filename);
    } catch (IOException e) {
      throw new IOException("Error reading file" + e.getMessage());
    } 
  }

  @Override
  public String toString() {
    return title + " by " + author + ", published by " + publisher + " in " + year;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getPublisher() {
    return publisher;
  }

  public String getYear() {
    return year;
  }
}
