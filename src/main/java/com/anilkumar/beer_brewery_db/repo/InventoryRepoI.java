package com.anilkumar.beer_brewery_db.repo;

import com.anilkumar.beer_brewery_db.entities.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepoI extends JpaRepository<InventoryEntity, Long> {

}
