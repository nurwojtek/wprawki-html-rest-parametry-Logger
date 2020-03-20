package pl.com.nur.wprawkihtmlrestparametry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookApi {

    BookService bookService;
    Book book;

    public BookApi(BookService bookService) {
        this.bookService = bookService;
    }


    // zwracamy listę + status
    @GetMapping
    public ResponseEntity<BookService> getBooks(){
        return new ResponseEntity(bookService.showProduct(), HttpStatus.OK);
    }

    // zwracamy 1 element
    @GetMapping("/{id}")
    public ResponseEntity<BookService> getBookById(@PathVariable long id){
        Optional<Book> first = bookService.showProduct().stream().filter(bookService -> bookService.getId()==id).findFirst();
        if(first.isPresent()){
            return new ResponseEntity(first, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
    }


    @PostMapping
    public ResponseEntity addBook(@RequestBody Book book){
        boolean add = bookService.addBook(book);
        if(add)
        {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
    }

    @PutMapping
    public ResponseEntity modBook(@RequestBody Book newbook){
        Optional<Book> first = bookService.showProduct().stream().filter(bookService -> bookService.getId()==newbook.getId()).findFirst();
        if(first.isPresent()){
            bookService.bookList.remove(first.get());
            bookService.bookList.add(newbook);
            return new ResponseEntity(first, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeBook(@PathVariable long id){
        Optional<Book> first = bookService.showProduct().stream().filter(bookService -> bookService.getId()==id).findFirst();
        if(first.isPresent()){
            bookService.bookList.remove(first.get());
            return new ResponseEntity(first, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
    }



}
