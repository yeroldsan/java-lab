package org.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.io.TempDir;

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
  @DisplayName("Should correctly populate fields from a valid CSV file")
  public void testReadBook(@TempDir Path tempDir) throws IOException {
    // Create a temporary CSV file
    File tempFile = tempDir.resolve("books.csv").toFile();
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
      writer.write("Harry Potter,J.K. Rowling,Bloomsbury Publishing,1997");
    }

    book.readBook(tempFile.getAbsolutePath());

    assertEquals("Harry Potter", book.getTitle());
    assertEquals("J.K. Rowling", book.getAuthor());
    assertEquals("Bloomsbury Publishing", book.getPublisher());
    assertEquals("1997", book.getYear());
  }

  @Test
  @DisplayName("Should return correct string representation")
  public void testToString(@TempDir Path tempDir) throws IOException {
    // Create a temporary CSV file
    File tempFile = tempDir.resolve("books.csv").toFile();
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
      writer.write("Harry Potter,J.K. Rowling,Bloomsbury Publishing,1997");
    }

    book.readBook(tempFile.getAbsolutePath());

    assertEquals("Harry Potter by J.K. Rowling, published by Bloomsbury Publishing in 1997", book.toString());
  }

  @Test
  @DisplayName("Should throw FileNotFoundException for non-existent file")
  public void testReadBookFileNotFoundException() {
    assertThrows(FileNotFoundException.class, () -> book.readBook("non_existent_file.csv"));
  }

  @Test
  @DisplayName("Should throw IOException for incorrectly formatted CSV")
  public void testReadBookIOException(@TempDir Path tempDir) throws IOException {
    // Create a temporary CSV file with incorrect format
    File tempFile = tempDir.resolve("incorrect_format.csv").toFile();
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
      writer.write("Harry Potter;J.K. Rowling;Bloomsbury Publishing;1997");
    }

    assertThrows(IOException.class, () -> book.readBook(tempFile.getAbsolutePath()));
  }
}
