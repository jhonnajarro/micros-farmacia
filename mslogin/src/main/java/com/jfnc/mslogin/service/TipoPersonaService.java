package com.jfnc.mslogin.service;

import com.jfnc.mslogin.entity.TipoPersona;

import java.util.List;

public interface TipoPersonaService {

    TipoPersona crearTipoPersona(TipoPersona tipoPersona);

    List<TipoPersona> listarTipoPersona();

    TipoPersona tipoPersonaPorId(Long id);

    TipoPersona modifcarTipoPersona(Long id, TipoPersona tipoPersona);

    void eliminarTipoPersona(Long id);

}
