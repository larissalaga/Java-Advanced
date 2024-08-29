package br.com.javamysql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * DAO stands for data access object. Usually, the DAO class is
 * responsible for two concepts: encapsulating the details of the
 * persistence layer and providing a CRUD interface for a single
 * entity.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;

}
