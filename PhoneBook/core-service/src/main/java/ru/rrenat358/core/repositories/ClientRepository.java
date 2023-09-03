package ru.rrenat358.core.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rrenat358.core.entities.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {



}
