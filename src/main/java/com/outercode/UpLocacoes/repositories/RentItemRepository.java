package com.outercode.UpLocacoes.repositories;

import com.outercode.UpLocacoes.models.RentItem;
import com.outercode.UpLocacoes.models.RentItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentItemRepository extends JpaRepository<RentItem, RentItemPK> {
}
