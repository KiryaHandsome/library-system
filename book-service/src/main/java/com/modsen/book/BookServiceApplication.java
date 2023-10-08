package com.modsen.book;

import com.modsen.book.dto.BookCreate;
import com.modsen.book.model.Book;
import com.modsen.book.repository.BookRepository;
import com.modsen.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@EnableFeignClients
@SpringBootApplication
@RequiredArgsConstructor
public class BookServiceApplication implements ApplicationRunner {

    @Value("${book.url}")
    private String bookServiceUrl;
    private final BookRepository bookRepository;
    private final RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        Page<Book> all = bookRepository.findAll(Pageable.ofSize(1));
        if (all.isEmpty()) { // if db is empty create books
            List<BookCreate> books = JsonUtil.getBooks();
            for (BookCreate book : books) {
                try {
                    HttpEntity<BookCreate> requestEntity = new HttpEntity<>(book);
                    restTemplate.postForEntity(bookServiceUrl, requestEntity, String.class);
                } catch (Exception ignored) {
                }
            }
        }
    }
}
