package com.arr.library;

public class Book {
    private String isbn;
    private String title;
    private String authorName;
    private String category;

    public Book(String isbn, String title, String authorName,String category) {
        this.isbn = isbn;
        this.title = title;
        this.authorName = authorName;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }
}
