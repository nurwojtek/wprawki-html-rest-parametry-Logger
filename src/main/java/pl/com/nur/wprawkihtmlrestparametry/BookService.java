package pl.com.nur.wprawkihtmlrestparametry;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    Book book;
    List<Book> bookList;

    public BookService() {
        bookList = new ArrayList<>();
        bookList.add(new Book(10L, "Pan Tadeusz"));
        bookList.add(new Book(20L, "Dziady III"));
    }


    public void addBook(Long id, String name){
        bookList.add(new Book(id, name));
    }

    public boolean addBook(Book book){
        boolean add = bookList.add(book);
        if(add){
            return true;
        }
        return false;
    }

    public List<Book> showProduct(){
        return bookList;
    }

}
