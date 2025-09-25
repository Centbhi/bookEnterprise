package com.hizon.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hizon.entity.BookData;
import com.hizon.model.Book;
import com.hizon.service.BookService;
import com.hizon.transformedModels.TransformBookService;
import com.hizon.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
    
    private TransformBookService transformedBook;
    private BookRepository bookRepo;
    @Autowired
    public BookServiceImpl(TransformBookService transformedBook,BookRepository bookRepo){
        this.transformedBook = transformedBook;
        this.bookRepo = bookRepo;
    }

    public void create(Book book){
        System.out.println("Book Created: " + bookRepo.save(transformedBook.transformBook(book)));
    }

    public Book read(Integer id){
        return transformedBook.getBook(id);
    }
    public List<Book> readAll(){
        return transformedBook.getAll();
    }

    public void update(Book book){
        System.out.println("Book Before Update: " + transformedBook.getBook(book));
        BookData saved = bookRepo.save(transformedBook.transformBook(book));
        System.out.println("Book After Update: " + saved);
    }

    public void delete(Integer id){
        bookRepo.deleteById(id);
    }
}
