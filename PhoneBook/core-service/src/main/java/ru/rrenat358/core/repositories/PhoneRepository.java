package ru.rrenat358.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rrenat358.core.entities.Phone;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {


    @Query(nativeQuery = true, value =
            """
            SELECT *
            FROM Phone e
            WHERE e.client_id = ?1
            """)
    List<Phone> findAllPhoneByClientId(Long id);


    @Modifying
    @Query(nativeQuery = true, value =
            """
            INSERT INTO Phone (client_id, number)
            VALUES (?1, ?2)
            """)
    void savePhoneByClientId(Long id, String number);


    @Modifying
    @Query(nativeQuery = true, value =
            """
            DELETE FROM Phone WHERE client_id = ?1 AND id = ?2
            """)
    void deletePhoneByIdByClientId(Long clientId, Long phoneId);


    @Modifying
    @Query(nativeQuery = true, value =
            """
            DELETE FROM Phone WHERE client_id = ?1
            """)
    void deleteAllPhoneByClientId(Long id);




}
