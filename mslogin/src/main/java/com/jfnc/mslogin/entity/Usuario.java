package com.jfnc.mslogin.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String usuario;
    private String password;
    private int estado;
    private String rol;

    private Date fechaCrea;
    private Date fechaMod;

    @OneToOne
    @JoinColumn(name ="id_persona")
    private  Persona persona;

}
