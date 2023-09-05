package ru.rrenat358.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rrenat358.api.core.EmailDto;
import ru.rrenat358.core.entities.Email;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

/*
    @Query(nativeQuery = true, value =
            """
            SELECT *
            FROM Email e
            WHERE e.id = ?1
            """)
    List<Email> findAllEmailByClientId(Long id);
*/

/*
    @Query(nativeQuery = true, value =
            """
            SELECT *
            FROM Email e
            WHERE e.client_id = ?1
            """)
    List<Email> findAllEmailByClientId(Long id);
*/

 // работает ↑
    //===========================

/*
    @Query(nativeQuery = true, value =
            """
            SELECT *
            FROM Email e
            WHERE e.id = ?1
            """)
    List<EmailDto> findAllEmailByClientId(Long id);

*/

    @Query(nativeQuery = true, value =
            """
            SELECT *
            FROM Email e
            WHERE e.client_id = ?1
            """)
    List<Email> findAllEmailByClientId(Long id);

/*
    @Query(nativeQuery = true, value =
            """
            SELECT e.id, e.address, e.client_id
            FROM Email e
            WHERE e.id = ?1
            """)
    List<EmailDto> findAllEmailByClientId(Long id);
*/

/*
    @Query(nativeQuery = true, value =
            """
            SELECT e.id, e.address, e.client_id
            FROM Email e
            WHERE e.id = ?1
            """)
    List<Email> findAllEmailByClientId(Long id);
*/




}
