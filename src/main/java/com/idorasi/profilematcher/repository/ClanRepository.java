package com.idorasi.profilematcher.repository;

import com.idorasi.profilematcher.model.Clan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClanRepository extends JpaRepository<Clan, Long> {
}
