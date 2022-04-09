package com.defi.tp_vente.service;

import com.defi.tp_vente.model.Approvisionnement;
import com.defi.tp_vente.repository.ApproRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApproService {
    @Autowired
    private ApproRepository approRepository;

    public void saveAppro(Approvisionnement approvisionnement){
        approRepository.save(approvisionnement);
    }

    public List<Approvisionnement> showAllAppro(){
        return approRepository.findAll();
    }

    public Approvisionnement showOneAppro(int id){
        return approRepository.findById(id).get();
    }

    public void deleteAppro(int id){
        approRepository.deleteById(id);
    }
}
