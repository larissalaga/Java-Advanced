package br.com.javamysql.repository;

import br.com.javamysql.entity.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultorioRepository extends JpaRepository<Consultorio, Long> {
}
