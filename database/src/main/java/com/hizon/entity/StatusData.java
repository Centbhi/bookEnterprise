package com.hizon.entity;
import lombok.Data;
import java.util.Date;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Status_data")
public class StatusData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String status;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdated;

}