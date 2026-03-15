package com.jm.logisCode.Service;

import com.jm.logisCode.Entity.Chofer;
import com.jm.logisCode.Entity.Vehiculo;
import com.jm.logisCode.Repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {

    @Autowired
    private IVehiculoRepository vehiculoRepository;

    public List<Vehiculo> findAllVehicles(){
        return vehiculoRepository.findAll();
    }

    public Vehiculo findById(Long id){
        if(id == null || id <= 0){
            throw new RuntimeException("id invalid");
        }
        return vehiculoRepository.findById(id).orElseThrow(()-> new RuntimeException("Vehiculo not found"));
    }

    public Vehiculo createVehiculo(Vehiculo vehiculo){
        if(vehiculo == null){
            throw new RuntimeException("vehiculo is null");
        }
        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo updateVehiculo(Long id,Vehiculo vehiculo){
        Vehiculo toUpdate = findById(id);
        toUpdate.setCapacidad(vehiculo.getCapacidad());
        return vehiculoRepository.save(toUpdate);
    }

    public void deleteVehiculo(Long id){
        if (id == null || id <= 0){
            throw new RuntimeException("id invalid");
        }
        vehiculoRepository.deleteById(id);
    }
}
