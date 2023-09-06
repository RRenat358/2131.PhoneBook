package ru.rrenat358.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rrenat358.core.entities.Phone;
import ru.rrenat358.core.repositories.PhoneRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService {

    private final PhoneRepository phoneRepository;


    public List<Phone> findAllPhoneByClientId(Long id) {
        return phoneRepository.findAllPhoneByClientId(id);
    }

    @Transactional
    public void savePhoneByClientId(Long id, String number) {
        phoneRepository.savePhoneByClientId(id, number);
    }


    @Transactional
    public void deleteAllPhoneByClientId(Long id) {
        phoneRepository.deleteAllPhoneByClientId(id);
    }


}
