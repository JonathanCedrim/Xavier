package br.com.amora.xavier.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class MyKey implements Serializable {

    private static final long serialVersionUID = 1L;



}
