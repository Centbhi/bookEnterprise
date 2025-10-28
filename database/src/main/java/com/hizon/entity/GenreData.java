package com.hizon.entity;
import lombok.Data;
import java.util.Date;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Genre_data")
public class GenreData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String genre;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdated;

}