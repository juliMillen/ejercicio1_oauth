package com.jm.logisCode.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idViaje;

    private int cantPasajeros;

    private String destino;

    @OneToOne
    private Chofer chofer;

    @OneToOne
    private Vehiculo vehiculo;
}
