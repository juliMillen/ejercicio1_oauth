package com.jm.logisCode.Service;

import com.jm.logisCode.Entity.Chofer;
import com.jm.logisCode.Repository.IChoferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoferService {

    @Autowired
    private IChoferRepository choferRepository;

    public List<Chofer> findAllChofers(){
        return choferRepository.findAll();
    }

    public Chofer findById(Long id){
        if(id == null || id <= 0){
            throw new RuntimeException("id invalid");
        }
        return choferRepository.findById(id).orElseThrow(()-> new RuntimeException("chofer not found"));
    }

    public Chofer createChofer(Chofer chofer){
        if(chofer == null){
            throw new RuntimeException("chofer is null");
        }
        return choferRepository.save(chofer);
    }

    public Chofer updateChofer(Long id,Chofer chofer){
        Chofer toUpdate = findById(id);
        toUpdate.setName(chofer.getName());
        toUpdate.setSurname(chofer.getSurname());
        return choferRepository.save(toUpdate);
    }

    public void deleteChofer(Long id){
        if (id == null || id <= 0){
            throw new RuntimeException("id invalid");
        }
        choferRepository.deleteById(id);
    }
}
