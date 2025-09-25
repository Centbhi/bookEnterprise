package com.hizon.transformedModels;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.hizon.entity.BookData;
import com.hizon.model.Book;
import com.hizon.repository.BookRepository;

@Service
public class TransformBookService {

    private final BookRepository bookRepo;
    private final ModelMapper mapper;

    public TransformBookService(BookRepository bookRepo, ModelMapper mapper) {
        this.bookRepo = bookRepo;
        this.mapper = mapper;
    }

    public Book getBook(Integer id){
        return mapper.map(bookRepo.findById(id).orElseThrow(
            ()-> new RuntimeException("Book not found")),Book.class);
    }

    public Book getBook(Book book){
        return mapper.map(bookRepo.findById(book.getId()),Book.class);
    }

    public List<Book> getAll(){
        List<Book> allBook = new ArrayList<Book>();
        for(BookData data:bookRepo.findAll()){
            allBook.add(mapper.map(data,Book.class));
        }
        return allBook;
    }

    public BookData transformBook(Book book){
        return mapper.map(book,BookData.class);
    }
    
}
