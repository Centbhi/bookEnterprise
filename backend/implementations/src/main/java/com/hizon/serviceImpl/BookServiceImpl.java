package com.hizon.serviceImpl;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.hizon.entity.BookData;
import com.hizon.model.Book;
import com.hizon.service.BookService;
import com.hizon.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
    
    private final BookRepository bookRepo;
    private final ModelMapper mapper;

    public BookServiceImpl(BookRepository bookRepo, ModelMapper mapper) {
        this.bookRepo = bookRepo;
        this.mapper = mapper;
    }

    public Book create(Book book){
        BookData bookResult = mapper.map(book, BookData.class);
        BookData saved = bookRepo.save(bookResult);
        return mapper.map(saved,Book.class);
    }

    public Book read(Integer id){
        return mapper.map(bookRepo.findById(id)
            .orElseThrow(()-> new RuntimeException("Book not found with id: " + id)),Book.class);
    }

    public List<Book> readAll(){
        List<Book> allBook = new ArrayList<Book>();
        for(BookData data:bookRepo.findAll()){
            allBook.add(mapper.map(data,Book.class));
        }
        return allBook;
    }

    public Book update(int id,Book book){
        BookData bookData = bookRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        book.setId(id);
        mapper.map(book,bookData);
        BookData saved = bookRepo.save(bookData);
        return mapper.map(saved,Book.class);
    }

    public void delete(Integer id){
        if(!bookRepo.existsById(id)){
            throw new RuntimeException("Book not found with id: " + id);
        }
        bookRepo.deleteById(id);
    }
}
