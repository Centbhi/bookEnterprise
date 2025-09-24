package com.hizon.entity;
import lombok.Data;
import java.util.Date;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Book_data")
public class BookData{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String title;
    String genre;
    String status;
    String datePublished;
    String author;
    Double price;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdated;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date inStockSince;
}