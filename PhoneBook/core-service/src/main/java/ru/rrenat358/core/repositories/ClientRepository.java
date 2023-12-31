package ru.rrenat358.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rrenat358.core.entities.Client;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {



    @Query(nativeQuery = true, value =
            """
            SELECT c.*
            FROM Client c
            JOIN Email e ON c.id = e.client_id
            WHERE e.address = ?1
            """)
    Optional<Client> findClientByEmail(String email);


    @Query(nativeQuery = true, value =
            """
            SELECT c.*
            FROM Client c
            JOIN Phone e ON c.id = e.client_id
            WHERE e.number = ?1
            """)
    Optional<Client> findClientByPhone(String phone);





}
