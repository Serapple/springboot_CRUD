package com.sparta.book.controller;


import com.sparta.book.domain.Book;
import com.sparta.book.domain.BookRepository;
import com.sparta.book.domain.BookRequestDto;
import com.sparta.book.domain.PasswordRequestDto;
import com.sparta.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor //final 요소들 기본생성
@RestController //json으로 응답해야하므로

public class BookController {
    private final BookRepository bookRepository; //꼭 필요한 것 final 써주기
    private final BookService bookService;
    

    @PostMapping("/api/books") //이 주소로 post 요청이 오면 게시글 작성
    public Book createBook(@RequestBody BookRequestDto requestDto) { //RequestBody는 요청받은 값을 쓰기 위함
        Book book = new Book(requestDto); //변경하는 것이므로 Dto 사용
        return bookRepository.save(book);
    }
    @GetMapping("/api/books") //이 주소로 get 요청이 오면 게시글 전체 조회
    public List<Book> getBooks(){ //전체를 받아올 것이므로 List 사용(java.util.List import하기)
        return bookRepository.findAllByOrderByCreatedAtDesc(); //마지막 수정된 시간을 기준으로 내림차순 정렬
    }

    @GetMapping("/api/books/{id}") //이 주소로 get 요청이 오면 특정 key 값의 게시글 조회
    public Optional<Book> getBook(@PathVariable Long id){ // 위에 적힌 id값을 받아올 것이기 때문에 @PathVariable 사용, 예외처리 안했기 때문에 optional 사용
        return bookRepository.findById(id);//id로 데이터 찾기
    }

    @PostMapping("/api/books/{id}") //이 주소로 post 요청이 오면 특정 아이디값의 비밀번호가 맞는지 확인해줌
    public boolean checkPW(@PathVariable Long id, @RequestBody PasswordRequestDto requestDto){ //위에 적힌 id값을 받아올 것이기 때문에 @PathVariable 사용
        //요청받은 값을 사용하기 위해 @RequestBody 사용, 값을 받아오기 위해 passworddto 새로 정의함
        return bookService.checkPW(id,requestDto); //book class에 만들어준 method 사용해서 service에 로직 작성, 참 거짓 판별
        // 컨트롤러에서는 로직을 사용한 코드는 되도록 쓰지 않는 것이 좋다. Service에서 이용해야함
    }
//

    @PutMapping("/api/books/{id}") //이 주소로 put 요청이 오면 특정 key 값의 게시글 업데이트
    public Long updateBook(@PathVariable Long id, @RequestBody BookRequestDto requestDto){ //위에 적힌 id값을 받아올 것이기 때문에 @PathVariable 사용
        //요청받은 값을 사용하기 위해 @RequestBody 사용, 데이터를 바꾸는 것이므로 dto 사용
        return bookService.update(id, requestDto); //service에서 정의한 update 사용
    }

    @DeleteMapping("/api/books/{id}") //이 주소로 delete 요청이 오면 특정 key 값의 게시글 삭제
    public Long deleteBook(@PathVariable Long id){ //위에 적힌 id값을 받아올 것이기 때문에 @PathVariable 사용
        bookRepository.deleteById(id); //id로 데이터 삭제
        return id;
    }
}