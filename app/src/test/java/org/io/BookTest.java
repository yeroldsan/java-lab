package org.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Target;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.io.TempDir;

public class BookTest {

  private static Book book;
  private static File validFile;
  private static File invalidFile;

  @BeforeAll
  public static void setup(@TempDir Path tempDir) throws IOException {
    book = new Book();

    // Create a valid temporary CSV file
    validFile = tempDir.resolve("books.csv").toFile();
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(validFile))) {
      writer.write("The Pragmatic Programmer,David Thomas,Addison-Wesley,1999");
    }

    // Create an invalid temporary CSV file
    invalidFile = tempDir.resolve("incorrect_format.csv").toFile();
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(invalidFile))) {
      writer.write("Harry Potter;J.K. Rowling;Bloomsbury Publishing;1997");
    }
  }

  @AfterAll
  static void tearDown() {
    book = null;
    validFile = null;
    invalidFile = null;
  }

  @Test
  @DisplayName("Should correctly populate fields from a valid CSV file")
  public void testReadBook() throws IOException {
    book.readBook(validFile.getAbsolutePath());

    assertAll(
      () -> assertEquals("The Pragmatic Programmer", book.getTitle(), "Title should be 'The Pragmatic Programmer'"),
      () -> assertEquals("David Thomas", book.getAuthor(), "Author should be 'David Thomas'"),
      () -> assertEquals("Addison-Wesley", book.getPublisher(), "Publisher should be 'Addison-Wesley'"),
      () -> assertEquals("1999", book.getYear(), "Year should be '1999'")
    );
  }

  @Test
  @DisplayName("String representation")
  public void testToString() throws IOException {
    book.readBook(validFile.getAbsolutePath());
    assertEquals("The Pragmatic Programmer by David Thomas, published by Addison-Wesley in 1999", book.toString(),
      "Should return correct string representation");
  }

  @Test
  @DisplayName("FileNotFoundException for non-existent file")
  public void testReadBookFileNotFoundException() {
    assertThrows(FileNotFoundException.class, () -> book.readBook("non_existent_file.csv"),
      "Should throw FileNotFoundException for non-existent file");
  }

  @Test
  @DisplayName("IOException for incorrectly formatted CSV")
  public void testReadBookIOException() throws IOException {
    assertThrows(IOException.class, () -> book.readBook(invalidFile.getAbsolutePath()),
      "Should throw IOException for incorrectly formatted CSV");
  }
}
