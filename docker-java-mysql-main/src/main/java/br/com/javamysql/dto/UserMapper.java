package br.com.javamysql.dto;

import br.com.javamysql.entity.User;

public class UserMapper {

    // convert department jpa entity into department dto
    public static UserDTO mapToDepartmentDto(User user){
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getGender()
        );
    }

    // convert department dto into department jpa entity
    public static User mapToDepartment(UserDTO userDto){
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getGender()
        );
    }

}
