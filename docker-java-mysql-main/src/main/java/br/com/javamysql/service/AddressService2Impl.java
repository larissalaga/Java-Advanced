package br.com.javamysql.service;

import br.com.javamysql.entity.Address;
import br.com.javamysql.repository.AddressRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AddressService2Impl {

    @Autowired
    AddressRepository2 repository;

    public Page<Address> search(
            String searchTerm,
            int page,
            int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "streetName");

        return repository.search(
                searchTerm.toLowerCase(),
                pageRequest);
    }

    public Page<Address> findAll() {
        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "streetName");
        return new PageImpl<>(
                repository.findAll(),
                pageRequest, size);
    }

}
