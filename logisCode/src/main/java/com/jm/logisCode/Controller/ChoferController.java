package com.jm.logisCode.Controller;

import com.jm.logisCode.Entity.Chofer;
import com.jm.logisCode.Service.ChoferService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chofer")
@PreAuthorize("isAuthenticated()")
public class ChoferController {

    @Autowired
    private ChoferService choferService;

    @GetMapping("")
    public ResponseEntity<List<Chofer>> getAllChofers(){
        List<Chofer> choferList = choferService.findAllChofers();
        return new ResponseEntity<>(choferList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chofer> getChoferById(@PathVariable Long id){
        Chofer toSearch = choferService.findById(id);
        return new ResponseEntity<>(toSearch,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Chofer> createChofer(@RequestBody Chofer chofer){
        Chofer toCreate = choferService.createChofer(chofer);
        return new ResponseEntity<>(toCreate,HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Chofer> updateChofer(@PathVariable Long id, @RequestBody Chofer chofer){
        Chofer toUpdate = choferService.updateChofer(id,chofer);
        return new ResponseEntity<>(toUpdate,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteChoferById(@PathVariable Long id){
        choferService.deleteChofer(id);
        return new ResponseEntity<>("chofer eliminated correctly", HttpStatus.NOT_FOUND);
    }
}
