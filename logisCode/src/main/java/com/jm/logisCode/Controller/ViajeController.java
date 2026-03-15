package com.jm.logisCode.Controller;

import com.jm.logisCode.Entity.Viaje;
import com.jm.logisCode.Service.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/travel")
@PreAuthorize("isAuthenticated()")
public class ViajeController {

    @Autowired
    private ViajeService viajeService;

    @GetMapping("")
    public ResponseEntity<List<Viaje>> getAllTravels(){
        List<Viaje> travelList = viajeService.findAllTravels();
        return new ResponseEntity<>(travelList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viaje> getTravelById( @PathVariable Long id){
        Viaje toSearch = viajeService.findTravelById(id);
        return new ResponseEntity<>(toSearch, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Viaje> createTravel(@RequestBody Viaje viaje){
        Viaje toCreate = viajeService.createViaje(viaje);
        return new ResponseEntity<>(toCreate, HttpStatus.CREATED);
    }

    @PostMapping("/{idTravel}/chofer/{idChofer}")
    public ResponseEntity<Viaje> assignChofer(@PathVariable Long idTravel, @PathVariable Long idChofer){
        Viaje toAssign = viajeService.assignChofer(idTravel,idChofer);
        return new ResponseEntity<>(toAssign,HttpStatus.OK);
    }

    @PostMapping("/{idTravel}/vehiculo/{idVehiculo}")
    public ResponseEntity<Viaje> assignVehiculo(@PathVariable Long idTravel, @PathVariable Long idVehiculo){
        Viaje toAssign = viajeService.assignVehiculo(idTravel,idVehiculo);
        return new ResponseEntity<>(toAssign,HttpStatus.OK);
    }

    @PatchMapping("/update/{idTravel}")
    public ResponseEntity<Viaje> updateViaje(@PathVariable Long idTravel, @RequestBody Viaje viaje){
        Viaje toUpdate = viajeService.updateTravel(idTravel,viaje);
        return new ResponseEntity<>(toUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idTravel}")
    public ResponseEntity<String> deleteTravelById(@PathVariable Long idTravel){
        viajeService.deleteTravelById(idTravel);
        return new ResponseEntity<>("travel delete correctly",HttpStatus.NOT_FOUND);
    }
}
