package pl.com.nur.wprawkihtmlrestparametry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductApi {
    BookService bookService;
    Logger loggerFactory = LoggerFactory.getLogger(ProductApi.class);

    public ProductApi(BookService bookService) {
        this.bookService = bookService;
    }

    //@GetMapping
    //public String getProducts(){
    //    loggerFactory.warn("moja lista " + bookService.showProduct());
    //    return  bookService.showProduct() + " metoda GET";
    //}

    @GetMapping("/parametr")
    // http://localhost:8080/products/parametr?name=Wojtek&surname=Galach
    public String getProductsParametr(@RequestParam String name, String surname ){
        loggerFactory.warn("moja lista " + bookService.showProduct());
        return  bookService.showProduct() + " to jest lista " + name + " " + surname;
    }

    @GetMapping("/parametrdefault")
    // http://localhost:8080/products/parametr?name=Wojtek   // parametr nie jest obowiązkowy zamiast niego wstawi default
    public String getProductsParametrDefault(@RequestParam String name,
                              @RequestParam(required =false, defaultValue = "aaa") String surname ){
        return  bookService.showProduct() + " to jest lista " + name + " " + surname;
    }
    // UWAGA  REST zaleca przez ścieżkę :)
    // przez ścieszkę
    //@GetMapping("/{name}")
    //public String getPath(@PathVariable String name){
    //    return "Witaj " + name;
    //}

    // przez nagłówek
    @GetMapping
    public String getHeader(@RequestHeader String name){
        return "Witaj " + name;
    }

    //przez body
   // @GetMapping
   // public String getBody(@RequestBody String name){
   //     return "Witaj " + name;
   // }

    // łączenie
    //@GetMapping
    //public String getCombo(@RequestParam String name,
    //                       @RequestHeader(required = false, defaultValue = "aaa") String surname){
    //    return "Hello " + name + " " + surname;
    //}

    @PostMapping
    public String postProducts(){
        return "metoda POST";
    }

    @PutMapping
    public String modProducts(){
        return "metoda PUT";
    }


    @DeleteMapping
    public String removeProducts(){
        return "metoda DELETE";
    }
}
