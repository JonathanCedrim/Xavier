package br.com.amora.xavier.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transpotadora {

    @Id
    @Getter
    @Setter
    private long id;

}
