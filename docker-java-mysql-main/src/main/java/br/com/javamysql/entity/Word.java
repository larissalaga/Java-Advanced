package br.com.javamysql.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 128)
    private String ptWord;
    @Column(nullable = false, length = 128)
    private String enWord;
    @Column(nullable = false, length = 512)
    private String ptMeaning;
}
