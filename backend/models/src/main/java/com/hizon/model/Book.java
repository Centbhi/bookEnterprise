package com.hizon.model;
import lombok.Data;

@Data
public class Book {

    private String title;
    private String genre;
    private String status;
    private String datePublished;
    private String author;
    private String publisher;
    private String description;
    private String coverImgUrl;

    private int quantityStock;
    private Double price;
    private Double rating;
}
