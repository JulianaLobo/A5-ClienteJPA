package com.iftm.client.repositories;

import com.iftm.client.dto.ClientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iftm.client.entities.Client;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "select tb.* from tb_client tb where lower(name) = lower(:name)",
            nativeQuery = true)
    Client findByName(String name);

    @Query(value = "select tb.* from tb_client tb where lower(name) like lower(concat('%',:name,'%'))",
            nativeQuery = true)
    List<Client> findByListName(String name);

    List<Client> findByIncomeGreaterThan(Double income);

    List<Client> findByIncomeLessThan(Double income);

    List<Client> findByIncomeBetween(Double income1, Double income2);

    List<Client> findByBirthDateBetween(Instant birthDate1, Instant birthDate2);

}
