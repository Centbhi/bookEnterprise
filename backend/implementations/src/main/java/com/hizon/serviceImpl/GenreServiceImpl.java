package com.hizon.serviceImpl;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.hizon.entity.GenreData;
import com.hizon.model.Genre;
import com.hizon.service.GenreService;
import com.hizon.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService{
    
    private final GenreRepository genreRepo;
    private final ModelMapper mapper;

    public GenreServiceImpl(GenreRepository genreRepo, ModelMapper mapper) {
        this.genreRepo = genreRepo;
        this.mapper = mapper;
    }

    public Genre create(Genre genre){
        GenreData genreResult = mapper.map(genre, GenreData.class);
        GenreData saved = genreRepo.save(genreResult);
        return mapper.map(saved,Genre.class);
    }

    public Genre read(Integer id){
        return mapper.map(genreRepo.findById(id)
            .orElseThrow(()-> new RuntimeException("Genre not found with id: " + id)),Genre.class);
    }

    public List<Genre> readAll(){
        List<Genre> allGenre = new ArrayList<Genre>();
        for(GenreData data:genreRepo.findAll()){
            allGenre.add(mapper.map(data,Genre.class));
        }
        return allGenre;
    }

    public Genre update(int id,Genre genre){
        GenreData genreData = genreRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Genre not found with id: " + id));
        genre.setId(id);
        mapper.map(genre,genreData);
        GenreData saved = genreRepo.save(genreData);
        return mapper.map(saved,Genre.class);
    }

    public void delete(Integer id){
        if(!genreRepo.existsById(id)){
            throw new RuntimeException("Genre not found with id: " + id);
        }
        genreRepo.deleteById(id);
    }
}
