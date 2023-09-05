package ru.rrenat358.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rrenat358.core.entities.Email;
import ru.rrenat358.core.repositories.EmailRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {


    private final EmailRepository emailRepository;

    public List<Email> findAllEmailByClientId(Long id) {
        return emailRepository.findAllEmailByClientId(id);

    }



}
