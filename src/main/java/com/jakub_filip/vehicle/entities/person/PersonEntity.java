package com.jakub_filip.vehicle.entities.person;


import com.jakub_filip.vehicle.entities.AbstractEntity;
import com.jakub_filip.vehicle.entities.car.CarEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String email;

    @OneToMany(
        cascade = CascadeType.PERSIST,
        fetch = FetchType.EAGER,
        mappedBy = "person"
    )
    private List<CarEntity> cars = new ArrayList<>();
}
