package br.com.javamysql.entity;

public class JavaRecordSample {

    public record UserRecord(
            String id,
            String firstName,
            String lastName,
            String email,
            String gender
    ){}
    UserRecord user = new UserRecord(
            "0",
            "fulano",
            "ciclano",
            "teste@teste.com",
            "male"
    );

}
