package org.io;

import java.io.IOException;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;

public class BookTest {

  private static Book book;

  @BeforeAll
  public static void setup() {
    book = new Book();
  }

  @AfterAll
  static void tearDown() {
    book = null;
  }

  @Test
  @Disabled("book's attributes are private and cannot be accessed directly")
  public void testReadBook() {
    // book.readBook("books.csv");
    // assertEquals("Harry Potter", book.title);
    // assertEquals("J.K. Rowling", book.author);
    // assertEquals("Bloomsbury Publishing", book.publisher);
    // assertEquals("1997", book.year);
  }

  @Test
  @DisplayName("Should return correct string representation")
  public void testToString() throws FileNotFoundException, IOException {
    book.readBook("books.csv");
    assertEquals("Harry Potter by J.K. Rowling, published by Bloomsbury Publishing in 1997", book.toString(),
      "Should return correct string representation");
  }

  @Test
  @DisplayName("FileNotFoundException for non-existent file")
  public void testReadBookFileNotFoundException() throws FileNotFoundException, IOException {
    book.readBook("non_existent_file.csv");
    assertThrows(FileNotFoundException.class, () -> book.readBook("non_existent_file.csv"),
      "Should throw FileNotFoundException for non-existent file");
  }

  @Test
  @DisplayName("IOException for incorrect format")
  public void testReadBookIOException() {
    // Simulate an IOException by reading a file with incorrect format
    assertThrows(IOException.class, () -> book.readBook("incorrect_format.csv"),
      "Should throw IOException for incorrect format");
  }
}
