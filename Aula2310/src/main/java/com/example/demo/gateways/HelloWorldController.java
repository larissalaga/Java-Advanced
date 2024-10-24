package com.example.demo.gateways;

import com.example.demo.domains.Aluno;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
@RequiredArgsConstructor
public class HelloWorldController {

    private final AlunoRepository alunoRepository;

    @GetMapping
    public Aluno helloWorld(){
        Aluno aluno = new Aluno();
        aluno.setNome("Hello world");
        return alunoRepository.save(aluno);
    }
}
