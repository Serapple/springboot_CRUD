package com.sparta.book.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor //자동으로 기본 생성자 생성
@Getter //getmethod 자동 생성
@Entity //table 생성
public class Book extends Timestamped { //처음 등록한 시간, 최종 수정한 시간을 데이터에 포함시키기 위해서 상속받음
    @GeneratedValue(strategy = GenerationType.AUTO) //id 값을 자동으로 1씩 증가시켜서 저장하기 위해서
    @Id //id(키밸류)로 지정
    private Long id;

    @Column(nullable = false) // null값일 수 없도록(값을 무조건 가지도록)
    //table의 column으로 저장되도록
    private String author; //클래스 외부에서 데이터를 마음대로 수정할 수 없어야 하므로 private
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    @JsonIgnore
    private String password;

    public Book(BookRequestDto requestDto){ //데이터에 직접 접근하는 것은 되도록 지양해야해서 DTO를 사용했다.
        this.author = requestDto.getAuthor();
        this.content = requestDto.getContent();
        this.id = requestDto.getId();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
    }

    public void update(BookRequestDto requestDto){ //데이터에 직접 접근하는 것은 되도록 지양해야해서 DTO를 사용했다.
        this.author = requestDto.getAuthor();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
        //id값은 업데이트될 필요가 없음
    }

    public boolean checkPW(PasswordRequestDto requestDto){ //비밀번호가 맞는지 구현. 비밀번호를 만들기 위해서 pwRequestDto를 만들었다.
        return this.password.equals(requestDto.getPassword()); //특정 아이디에서의 패스워드와 입력한 패스워드 값이 같다면 true 반기
    }
}