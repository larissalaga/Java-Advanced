package br.com.javamysql.repository;

import br.com.javamysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 JpaRepository é uma extensão específica do Repositório JPA (Java Persistence API).
 Ele contém a API completa de CrudRepository e PagingAndSortingRepository . Portanto,
 contém API para operações básicas de CRUD e também API para paginação e classificação.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
