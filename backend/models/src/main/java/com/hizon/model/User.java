package com.hizon.model;
import java.util.List;

import lombok.Data;

@Data
public class User {
    private String name;
    private String password;
    private boolean isAdmin;
    private List<Book> books;
}
