package com.hizon.serviceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.hizon.entity.GenreData;
import com.hizon.model.Genre;
import com.hizon.service.GenreService;

@Service
public class GenreServiceImpl extends GenericServiceImpl<GenreData, Genre> implements GenreService{
    public GenreServiceImpl(JpaRepository<GenreData,Integer> repo, ModelMapper mapper){
        super(repo,mapper,GenreData.class,Genre.class);
    }
}
