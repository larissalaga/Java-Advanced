package br.com.javamysql.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 128)
    private String streetName;
    @Column(nullable = false, length = 128)
    private String neighborhood;
    @Column(nullable = false, length = 2)
    private String state;

}
