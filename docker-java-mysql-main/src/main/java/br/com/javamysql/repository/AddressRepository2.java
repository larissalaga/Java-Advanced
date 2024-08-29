package br.com.javamysql.repository;

import br.com.javamysql.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository2 extends JpaRepository<Address, Long> {

    @Query("FROM Address c " +
            "WHERE LOWER(c.streetName) like %:searchTerm% " +
            "OR LOWER(c.neighborhood) like %:searchTerm%")
    Page<Address> search(
            @Param("searchTerm") String searchTerm,
            Pageable pageable);

}
