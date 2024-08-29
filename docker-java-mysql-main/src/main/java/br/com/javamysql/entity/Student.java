package br.com.javamysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long StudentID;

    @Column(length = 40)
    private String StudentFirstName;

    @Column(length = 40)
    private String StudentLastName;

    @Column
    private int Age;

    @Column(length = 60)
    private String Course;

}
