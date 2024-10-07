package com.outercode.UpLocacoes.repositories;

import com.outercode.UpLocacoes.models.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Integer> {
}
