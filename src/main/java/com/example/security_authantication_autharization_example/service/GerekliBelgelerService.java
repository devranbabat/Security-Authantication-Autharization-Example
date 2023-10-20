package com.example.security_authantication_autharization_example.service;

import com.example.security_authantication_autharization_example.entity.GerekliBelgeler;
import com.example.security_authantication_autharization_example.repository.GerekliBelgelerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GerekliBelgelerService {

    private final GerekliBelgelerRepository gerekliBelgelerRepository;

    public String save(GerekliBelgeler gerekliBelgeler) {

        gerekliBelgelerRepository.save(gerekliBelgeler);
        return "Kaydedildi";
    }

    public String update(int id, GerekliBelgeler gerekliBelgeler) throws Exception {

        var object = gerekliBelgelerRepository.findById(id).orElseThrow(() -> new Exception("Belge bulunamadı"));
        object.setUlke(gerekliBelgeler.getUlke());
        object.setBelge(gerekliBelgeler.getBelge());
        gerekliBelgelerRepository.save(object);
        return "güncellendi";
    }


}
