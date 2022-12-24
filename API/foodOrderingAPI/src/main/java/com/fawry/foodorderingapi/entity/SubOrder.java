package com.fawry.foodorderingapi.entity;

import lombok.Getter;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SubOrder implements Serializable {

    private static final long serialVersionUID = -8476250229565837436L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity;

    @OneToOne
    private Food food;
}
