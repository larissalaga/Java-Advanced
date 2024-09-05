package br.com.javamysql.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Generated;
import lombok.NonNull;

@Data
@Entity
@Table
public class Consultorio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(nullable = false, length = 32)
    @Size(min=2, max=32)
    private String nome;

    @NonNull
    @Column(nullable = false, length = 64)
    @Size(min=2, max=64)
    private String nomeFantasia;

    @NonNull
    @Column(nullable = false, length = 100)
    @Size(min=2, max=100)
    private String endereco;

    @NonNull
    @Column(nullable = false, length = 10)
    @Size(min=2, max=10)
    private Integer numero;

    @NonNull
    @Column(nullable = false, length = 64)
    @Size(min=2, max=64)
    private String cidade;

    @NonNull
    @Column(nullable = false, length = 64)
    @Email
    private String email;

}
