package br.com.javamysql.controller;

import br.com.javamysql.entity.Consultorio;
import br.com.javamysql.repository.ConsultorioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class ConsltorioController implements WebMvcConfigurer {

    @Autowired
    ConsultorioRepository consultorioRespository;

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController( "/results").setViewName("results");
    }
    @GetMapping("/")
    public String (Consultorio consultorioForm){return"Form";}

    @PostMapping("/")
    public String checkConsultorioInfo(@Valid Consultorio consultorioForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "form";
        }
        return "redirect:/results";
    }
}
