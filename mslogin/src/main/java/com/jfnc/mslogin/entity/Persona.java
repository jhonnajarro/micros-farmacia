package com.jfnc.mslogin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    private String nombres;
    private String apellidos;
    private String direccion;
    private String email;
    private String celular;
    private String sexo;
    private int estado;
    private Date fechaCrea;
    private Date fechaMod;

    @ManyToOne
    @JoinColumn(name = "id_tipo_persona", foreignKey = @ForeignKey(name = "fk_persona_tipopersona"),nullable = true)
    private TipoPersona tipoPersona;

    @OneToOne(mappedBy = "persona")
    @JsonIgnore
    private Usuario usuario;
}
