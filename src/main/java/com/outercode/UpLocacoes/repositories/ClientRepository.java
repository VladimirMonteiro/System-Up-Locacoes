package com.outercode.UpLocacoes.repositories;

import com.outercode.UpLocacoes.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
