package com.hizon.transformedModels;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.hizon.entity.GenreData;
import com.hizon.model.Genre;
import com.hizon.repository.GenreRepository;

@Service
public class TransformGenreService {

    private final GenreRepository genreRepo;
    private final ModelMapper mapper;

    public TransformGenreService(GenreRepository genreRepo, ModelMapper mapper) {
        this.genreRepo = genreRepo;
        this.mapper = mapper;
    }

    public Genre getGenre(Integer id){
        return mapper.map(genreRepo.findById(id).orElseThrow(
            ()-> new RuntimeException("Genre not found")),Genre.class);
    }

    public Genre getGenre(Genre genre){
        return mapper.map(genreRepo.findById(genre.getId()),Genre.class);
    }

    public List<Genre> getAll(){
        List<Genre> allGenres = new ArrayList<Genre>();
        for(GenreData data:genreRepo.findAll()){
            allGenres.add(mapper.map(data,Genre.class));
        }
        return allGenres;
    }

    public GenreData transformGenre(Genre genre){
        return mapper.map(genre,GenreData.class);
    }
    
}
