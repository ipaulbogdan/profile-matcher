package com.idorasi.profilematcher.repository;

import com.idorasi.profilematcher.model.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByNameIn(List<String> itemName);

}
