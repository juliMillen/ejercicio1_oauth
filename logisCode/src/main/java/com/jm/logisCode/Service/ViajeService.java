package com.jm.logisCode.Service;

import com.jm.logisCode.Entity.Chofer;
import com.jm.logisCode.Entity.Vehiculo;
import com.jm.logisCode.Entity.Viaje;
import com.jm.logisCode.Repository.IChoferRepository;
import com.jm.logisCode.Repository.IVehiculoRepository;
import com.jm.logisCode.Repository.IViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViajeService {

    @Autowired
    private IViajeRepository viajeRepository;

    @Autowired
    private IVehiculoRepository vehiculoRepository;

    @Autowired
    private IChoferRepository choferRepository;

    public List<Viaje> findAllTravels(){
        return viajeRepository.findAll();
    }

    public Viaje findTravelById(Long id){
        if(id == null || id <= 0){
            throw new RuntimeException("id invalid");
        }
        return viajeRepository.findById(id).orElse(null);
    }

    public Viaje createViaje(Viaje viaje){
        if(viaje == null){
            throw new RuntimeException("the trip cannot be null");
        }
        return viajeRepository.save(viaje);
    }

    public Viaje assignChofer(Long id,Long idChofer){
        Viaje toAssign = findTravelById(id);
        if(toAssign == null){
            throw new RuntimeException("chofer not found");
        }
        Chofer chofer = choferRepository.findById(idChofer).orElseThrow(() -> new RuntimeException("chofer not found"));
        toAssign.setChofer(chofer);
        return viajeRepository.save(toAssign);
    }

    public Viaje assignVehiculo(Long id,Long idVehiculo){
        Viaje toAssign = findTravelById(id);
        if(toAssign == null){
            throw new RuntimeException("travel not found");
        }
        Vehiculo vehiculo = vehiculoRepository.findById(idVehiculo).orElseThrow(() -> new RuntimeException("vehicle not found"));
        toAssign.setVehiculo(vehiculo);
        return viajeRepository.save(toAssign);
    }

    public Viaje updateTravel(Long id, Viaje viaje){
      Viaje toUpdate = findTravelById(id);
      if (toUpdate == null){
          throw new RuntimeException("travel not found");
      }
        toUpdate.setDestino(viaje.getDestino());
        toUpdate.setChofer(viaje.getChofer());
        toUpdate.setVehiculo(viaje.getVehiculo());
        toUpdate.setCantPasajeros(viaje.getCantPasajeros());
        return viajeRepository.save(toUpdate);

    }

    public void deleteTravelById(Long id){
        if(id == null || id <= 0){
            throw new RuntimeException("id invalid");
        }
        viajeRepository.deleteById(id);
    }

}
