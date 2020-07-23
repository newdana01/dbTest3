package com.servlet.DTO;

public class BookDTO {
    private int bookId;
    private String bookName;
    private String bookLoc;

    public BookDTO(int bookId, String bookName, String bookLoc) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookLoc = bookLoc;
    }

    public BookDTO(int bookId) {
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookLoc() {
        return bookLoc;
    }
}
