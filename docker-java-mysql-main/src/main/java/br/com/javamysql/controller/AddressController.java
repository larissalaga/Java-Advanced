package br.com.javamysql.controller;

import br.com.javamysql.entity.Address;
import br.com.javamysql.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/addresses")
public class AddressController {

    private AddressService addressService;

    // build create dummy Addresses REST API
    @PostMapping("dummy/{qty}")
    public ResponseEntity<Address> createDummyAddresses(@PathVariable("qty") int quantity) {
        addressService.createDummyAddresses(quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // build create Address REST API
    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        try {
            Address savedAddress = addressService.createAddress(address);
            return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // build get Address by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") Long addressId) {
        try {
            Address address = addressService.getAddressById(addressId);
            if (address == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(address);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    // Build Get Address by state REST API
    @GetMapping("{state}")
    public ResponseEntity<List<Address>> getAddressByState(@PathVariable("state") String state) {
        List<Address> address = addressService.getAddressByState(state);
        return ResponseEntity.ok(address);
    }

    @GetMapping("/filter")
    public List<Address> findAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "state") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDirection) {
        Page<Address> result = addressService.findAll(pageNo, pageSize, sortBy, sortDirection);
        return result.getContent();

    }

    // Build Get All Address REST API
    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress() {
        List<Address> address = addressService.getAllAddress();
        return ResponseEntity.ok(address);
    }

    // Build Update Address REST API
    @PutMapping("{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable("id") Long addressId, @RequestBody Address address) {
        address.setId(addressId);
        Address updatedAddress = addressService.updateAddress(address);
        return ResponseEntity.ok(updatedAddress);
    }

    // Build Delete Address REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable("id") Long addressId) {
        addressService.deleteAddress(addressId);
        return new ResponseEntity<>("Address successfully deleted!", HttpStatus.OK);
    }

}
