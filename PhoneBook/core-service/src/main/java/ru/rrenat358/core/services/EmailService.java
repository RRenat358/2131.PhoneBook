package ru.rrenat358.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rrenat358.api.core.ClientDto;
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

    @Transactional
    public void saveEmailByClientId(Long id, String email) {
        emailRepository.saveEmailByClientId(id, email);
    }




}
