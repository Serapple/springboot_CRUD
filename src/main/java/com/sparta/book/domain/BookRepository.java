package com.sparta.book.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByOrderByCreatedAtDesc();
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods,
    // 다 찾고 수정날짜기준 내림차순으로 정렬해줘
}