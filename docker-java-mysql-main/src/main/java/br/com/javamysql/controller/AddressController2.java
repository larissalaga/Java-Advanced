package br.com.javamysql.controller;

import br.com.javamysql.entity.Address;
import br.com.javamysql.service.AddressService2Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/addresses2")
public class AddressController2 {

    @Autowired
    AddressService2Impl service;

    @GetMapping("/search")
    public Page<Address> search(
            @RequestParam("searchTerm") String searchTerm,
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size) {
        return service.search(searchTerm, page, size);

    }

    @GetMapping
    public Page<Address> getAll() {
        return service.findAll();
    }

}
