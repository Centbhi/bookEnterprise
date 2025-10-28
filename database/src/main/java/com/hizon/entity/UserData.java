package com.hizon.entity;
import lombok.Data;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "User_data")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    String password;
    boolean isAdmin;
    
    // List<BookData> books;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdated;

}