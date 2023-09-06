package ru.rrenat358.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rrenat358.core.entities.Email;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {


    @Query(nativeQuery = true, value =
            """
            SELECT *
            FROM Email e
            WHERE e.client_id = ?1
            """)
    List<Email> findAllEmailByClientId(Long id);


    @Modifying
    @Query(nativeQuery = true, value =
            """
            INSERT INTO Email (client_id, address)
            VALUES (?1, ?2)
            """)
    void saveEmailByClientId(Long id, String email);


    @Modifying
    @Query(nativeQuery = true, value =
            """
            DELETE FROM Email WHERE client_id = ?1
            """)
    void deleteAllEmailByClientId(Long id);


}


