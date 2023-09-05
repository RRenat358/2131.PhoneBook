package ru.rrenat358.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
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



}
