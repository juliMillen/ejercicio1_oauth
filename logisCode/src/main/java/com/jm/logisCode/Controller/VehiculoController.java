package com.jm.logisCode.Controller;

import com.jm.logisCode.Entity.Vehiculo;
import com.jm.logisCode.Service.VehiculoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping("")
    public ResponseEntity<List<Vehiculo>> getAllVehicles(){
        List<Vehiculo> vehicleList = vehiculoService.findAllVehicles();
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getVehicleById(@PathVariable Long id){
        Vehiculo toSearch= vehiculoService.findById(id);
        return new ResponseEntity<>(toSearch,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Vehiculo> createVehicle(@RequestBody Vehiculo vehicle){
        Vehiculo toCreate = vehiculoService.createVehiculo(vehicle);
        return new ResponseEntity<>(toCreate, HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Vehiculo> updateVehiculo(@PathVariable Long id, @RequestBody Vehiculo vehicle){
        Vehiculo toUpdate = vehiculoService.updateVehiculo(id,vehicle);
        return new ResponseEntity<>(toUpdate,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteVehicleById(@PathVariable Long id){
        vehiculoService.deleteVehiculo(id);
        return new ResponseEntity<>("vehicle delete correctly",HttpStatus.NOT_FOUND);
    }
}
