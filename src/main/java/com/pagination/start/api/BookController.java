package com.pagination.start.api;


import com.pagination.start.model.Book;
import com.pagination.start.repo.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/books")

public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public Page<Book> pagination(@RequestParam int pageSize, @RequestParam int page){
        Pageable pageAble=PageRequest.of(page, pageSize);
         return bookRepository.findAll(pageAble);

    }
    @GetMapping
    @RequestMapping("/p")
    public Page<Book> pagination(Pageable pageable){
        // totalElement count query çalıştırılıyo ve kuyruğun uzunluğu bulunuyo
        return bookRepository.findAll(pageable);

    }
    @GetMapping
    @RequestMapping("/s")
    public Slice<Book> slice(Pageable pageable){
        return bookRepository.findAll(pageable);

    }
}
