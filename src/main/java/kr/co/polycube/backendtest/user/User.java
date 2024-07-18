package kr.co.polycube.backendtest.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 작성일: 2024.07.18
 * 작성자: getinthere
 * 요구사항에 password, createdAt, updateAt이 표시되지 않아서 작성하지 않음.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "user_tb")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Builder
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
