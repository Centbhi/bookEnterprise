package com.hizon.services;
import java.util.List;
import com.hizon.model.Genre;

public interface GenreService {
    List<Genre> readAll() throws Exception;
    Genre create(Genre genre) throws Exception;
    Genre read(Integer id) throws Exception;
    Genre update(Genre genre) throws Exception;
    void delete(Integer id) throws Exception;
}
