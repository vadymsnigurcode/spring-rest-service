package com.example.springrestservice;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SpringBootApplication
public class SpringRestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestServiceApplication.class, args);
    }

}

@RestController
class Controller {
    @GetMapping(path = "/hello/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello(@PathVariable String name) {
        return "Hello " + name + "!";
    }
}

@Entity
@Data
class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}

@RepositoryRestResource
interface BookRepository extends JpaRepository<Book, Long> {
}

//@RepositoryRestResource(collectionResourceRel = "books", path = "books")
//interface BookRepository extends PagingAndSortingRepository<Book, Long> {
//    //    Book findByName(String name);
//    List<Book> findByName(@Param("name") String name);
//}
