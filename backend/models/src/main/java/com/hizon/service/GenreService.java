package com.hizon.service;
import java.util.List;
import com.hizon.model.Genre;

public interface GenreService {
    List<Genre> readAll() throws Exception;
    void create(Genre genre) throws Exception;
    Genre read(Integer id) throws Exception;
    void update(Genre genre) throws Exception;
    void delete(Integer id) throws Exception;
}
