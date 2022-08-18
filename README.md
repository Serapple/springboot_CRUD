
# Spring 입문 과제

## Goal

스프링 부트를 사용해 기본적인 CRUD 기능이 포함된 RESTapi 만들고 배포하기

## Stack

- Intellij
- Spring Boot
- Java 11
- Lombok
- JPA
- Spring web
- MySQL
- H2

## Requirement

1. Usecase
    
    ![Usecase](https://user-images.githubusercontent.com/110282569/185336068-404dc552-639b-4ce8-89be-f52bd13e1d81.png)

2. 전체 게시글 목록 조회 API
3. 게시글 작성 API
4. 게시글 조회 API
5. 게시글 비밀번호 확인 API
6. 게시글 수정 API
7. 게시글 삭제 API

## API 명세서

| 기능 | Method | URL | Request | Return |
| --- | --- | --- | --- | --- |
| 게시글 작성 | POST | /api/books | {”title” : “title”, “content”: content”, “author”: “author”, “password” : “password”} | {”createdAt” :”만든시간”, “modifiedAt”:”수정된 시간”, “id”:”id”, ”title” : “title”, “content”: content”, “author”: “author”} |
| 게시글 전체 조회 | GET | /api/books |  | {”createdAt” :”만든시간”, “modifiedAt”:”수정된 시간”, “id”:”id”, ”title” : “title”, “content”: content”, “author”: “author”},{”createdAt” :”만든시간”, “modifiedAt”:”수정된 시간”, “id”:”id”, ”title” : “title”, “content”: content”, “author”: “author”} … |
| 게시글 조회 | GET | /api/books/{id} |  | {”createdAt” :”만든시간”, “modifiedAt”:”수정된 시간”, “id”:”id”, ”title” : “title”, “content”: content”, “author”: “author”} |
| 게시글 비밀번호 확인 | POST | /api/books/{id} | {”password”:”password”} | true / false |
| 게시글 수정 | PUT | /api/books/{id} | {”title” : “title2”, “content”: content2”, “author”: “author2”, “password” : “password2”} | {”createdAt” :”만든시간”, “modifiedAt”:”수정된 시간”, “id”:”id”, ”title” : “title2”, “content”: content2”, “author”: “author2”} |
| 게시글 삭제 | DELETE | /api/books/{id} |  | {”id”:”id”} |
