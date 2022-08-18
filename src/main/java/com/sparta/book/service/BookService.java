package com.sparta.book.service;


import com.sparta.book.domain.Book;
import com.sparta.book.domain.BookRepository;
import com.sparta.book.domain.BookRequestDto;
import com.sparta.book.domain.PasswordRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor ////final 요소들 기본생성
@Service //이 클래스가 Service임을 나타냄

public class BookService {
    private final BookRepository bookRepository;

    @Transactional //SQL쿼리가 일어나야 함
    public Long update(Long id, BookRequestDto requestDto) { //변경할 id, 변경할 값
        Book book = bookRepository.findById(id).orElseThrow( //변경할 id로 데이터 찾아서 book에 저장
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.") //id값의 데이터가 없을 경우를 생각한 예외처리
        );
        book.update(requestDto); //Book class에서 정의한 update method 사용
        return book.getId();
    }


    @Transactional //SQL 쿼리가 일어나야 함을 알려줌
    public boolean checkPW(Long id, PasswordRequestDto requestDto) { //체크할 id, pw값
        Book book = bookRepository.findById(id).orElseThrow( //확인할 id로 데이터 찾아서 book에 저장, id값의 데이터가 없을 경우 예외처리
                () -> new IllegalArgumentException("존재하지 않습니다") //예외처리
        );
        return book.checkPW(requestDto); //Book class에서 정의한 checkpw method 사용
    }

}
