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

@Entity
// As entidades no JPA nada mais são do que objetos Java que representam
// dados que podem ser persistidos no banco de dados. Uma entidade representa
// uma tabela armazenada em um banco de dados. Cada instância de uma entidade
// representa uma linha na tabela. O nome da entidade é padronizado como o
// nome da classe. Podemos alterar seu nome usando o elemento "name". Como
// por exemplo @Entity(name="student")

@Table(name = "users")
// Na maioria dos casos, o nome da tabela no banco de dados e o nome da entidade
// não serão iguais. Nestes casos, podemos especificar o nome da tabela usando a
// anotação @Table. Também podemos mencionar o esquema usando o elemento "schema".
// Se não utilizarmos a anotação @Table, o nome da tabela será o nome da entidade.

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Cada entidade JPA deve ter uma chave primária que a
    // identifique exclusivamente. A anotação @Id define a
    // chave primária. Podemos gerar os identificadores de
    // diferentes maneiras, que são especificadas pela
    // anotação @GeneratedValue. Podemos escolher entre
    // quatro estratégias de geração de id com o elemento
    // de estratégia. O valor pode ser AUTO, TABLE, SEQUENCE
    // ou IDENTITY.
    private Long id;

    @Column(nullable = false)
    // Assim como a anotação @Table, podemos usar a anotação @Column para
    // mencionar os detalhes de uma coluna na tabela. A anotação @Column
    // possui muitos elementos, como nome, comprimento, anulável e exclusivo.
    // @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
    // private String name;
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String gender;

    // @Transient
    // private Integer age;
    // Às vezes, podemos querer tornar um campo não persistente. Podemos
    // usar a anotação @Transient para fazer isso. Especifica que o campo
    // não será persistido.

    // @Temporal(TemporalType.DATE)
    // private Date birthDate;
    // Em alguns casos, poderemos ter que salvar valores temporais em nossa tabela.

    // @Enumerated(EnumType.STRING)
    // private Gender gender;
    // Às vezes, podemos querer persistir um tipo de enum Java.
}
