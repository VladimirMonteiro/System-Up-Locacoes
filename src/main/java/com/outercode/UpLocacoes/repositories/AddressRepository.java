package com.outercode.UpLocacoes.repositories;

import com.outercode.UpLocacoes.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
