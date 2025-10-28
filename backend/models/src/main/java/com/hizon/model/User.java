package com.hizon.model;
import java.util.List;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String password;
    private List<Book> books;
}
