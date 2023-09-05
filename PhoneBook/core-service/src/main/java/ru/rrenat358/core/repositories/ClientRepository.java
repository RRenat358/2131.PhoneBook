package ru.rrenat358.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rrenat358.core.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {


    @Query(nativeQuery = true, value =
            """
            SELECT c.*
            FROM Clients c
            JOIN Email e ON c.id = e.client_id
            WHERE e.address = ?1
            """)
    Client findClientByEmail(String email);




}
