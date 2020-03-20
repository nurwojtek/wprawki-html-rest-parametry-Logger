package pl.com.nur.wprawkihtmlrestparametry;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testcode")
public class TestHTTPcode {


    @GetMapping
    public ResponseEntity<String> get(){
        return new ResponseEntity("Zwracam kod http" , HttpStatus.BAD_REQUEST);
    }


}
