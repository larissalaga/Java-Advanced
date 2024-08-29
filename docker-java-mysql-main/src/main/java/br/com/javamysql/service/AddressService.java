package br.com.javamysql.service;

import br.com.javamysql.entity.Address;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AddressService {

    void createDummyAddresses(int quantity);

    Address createAddress(Address address);

    Address getAddressById(Long addressId) throws ChangeSetPersister.NotFoundException;

    List<Address> getAddressByState(String state);

    List<Address> getAllAddress();

    Page<Address> findAll(int pageNo, int pageSize, String sortBy, String sortDirection);

    Address updateAddress(Address address);

    void deleteAddress(Long addressId);

}
