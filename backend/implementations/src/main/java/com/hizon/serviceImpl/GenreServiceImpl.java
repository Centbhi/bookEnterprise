package com.hizon.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hizon.entity.GenreData;
import com.hizon.model.Genre;
import com.hizon.service.GenreService;
import com.hizon.transformedModels.TransformGenreService;
import com.hizon.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService{
    
    private TransformGenreService transformedGenre;
    private GenreRepository genreRepo;
    @Autowired
    public GenreServiceImpl(TransformGenreService transformedGenre,GenreRepository genreRepo){
        this.transformedGenre = transformedGenre;
        this.genreRepo = genreRepo;
    }

    public void create(Genre genre){
        System.out.println("Genre Created: " + genreRepo.save(transformedGenre.transformGenre(genre)));
    }

    public Genre read(Integer id){
        return transformedGenre.getGenre(id);
    }
    public List<Genre> readAll(){
        return transformedGenre.getAll();
    }

    public void update(Genre genre){
        System.out.println("Genre Before Update: " + transformedGenre.getGenre(genre));
        GenreData saved = genreRepo.save(transformedGenre.transformGenre(genre));
        System.out.println("Genre After Update: " + saved);
    }

    public void delete(Integer id){
        genreRepo.deleteById(id);
    }
}
