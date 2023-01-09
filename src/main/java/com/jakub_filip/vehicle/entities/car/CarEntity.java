package com.jakub_filip.vehicle.entities.car;

import com.jakub_filip.vehicle.entities.AbstractEntity;
import com.jakub_filip.vehicle.entities.enums.CarBrand;
import com.jakub_filip.vehicle.entities.enums.CarModel;
import com.jakub_filip.vehicle.entities.person.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "car")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity extends AbstractEntity {

    @Column(name = "brand")
    @Enumerated(EnumType.STRING)
    private CarBrand brand;

    @Column(name = "model")
    @Enumerated(EnumType.STRING)
    private CarModel model;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;

}
