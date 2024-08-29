package br.com.javamysql.service;

import br.com.javamysql.entity.Address;
import br.com.javamysql.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Override
    public void createDummyAddresses(int quantity) {
        String generatedString = "ABCDEFGHIJKLMNOPQRSTUVXYWZ";
        Random r = new Random();

        for (int i=0; i< quantity; i++) {
            int result = r.nextInt(25);
            Address address = new Address();
            address.setStreetName("Street " + result);
            address.setNeighborhood("Neighborhood " + generatedString.charAt(result));
            address.setState(generatedString.charAt(result)+""+generatedString.charAt(result));
            addressRepository.save(address);
        }
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddressById(Long addressId) throws ChangeSetPersister.NotFoundException {
        if (addressRepository.existsById(addressId)) {
            Optional<Address> optionalAddress = addressRepository.findById(addressId);
            return optionalAddress.get();
        } else {
            throw  new ChangeSetPersister.NotFoundException();
        }
    }

    @Override
    public List<Address> getAddressByState(String state) {
        //TODO return addressPageRepository.findAddressByState(state);
        return null;
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address updateAddress(Address address) {
        Address existingAddress = addressRepository.findById(address.getId()).get();
        existingAddress.setStreetName(address.getStreetName());
        existingAddress.setNeighborhood(address.getNeighborhood());
        existingAddress.setState(address.getState());
        return addressRepository.save(existingAddress);
    }

    @Override
    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }

    public Page<Address> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        return addressRepository.findAll(pageable);
    }
}
