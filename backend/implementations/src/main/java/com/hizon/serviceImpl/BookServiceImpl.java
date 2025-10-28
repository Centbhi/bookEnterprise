package com.hizon.serviceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.hizon.entity.BookData;
import com.hizon.model.Book;
import com.hizon.service.BookService;

@Service
public class BookServiceImpl extends GenericServiceImpl<BookData, Book> implements BookService{
    public BookServiceImpl(JpaRepository<BookData,Integer> repo, ModelMapper mapper){
        super(repo,mapper,BookData.class,Book.class);
    }
}
