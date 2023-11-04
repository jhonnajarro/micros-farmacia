package com.jfnc.mslogin.service.impl;

import com.jfnc.mslogin.entity.TipoPersona;
import com.jfnc.mslogin.repository.TipoPersonaRepository;
import com.jfnc.mslogin.service.TipoPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPersonaServiceImpl  implements TipoPersonaService {

    @Autowired
    TipoPersonaRepository tipoPersonaRepository;

    @Override
    public TipoPersona crearTipoPersona(TipoPersona tipoPersona) {
        return tipoPersonaRepository.save(tipoPersona);
    }

    @Override
    public List<TipoPersona> listarTipoPersona() {
        return tipoPersonaRepository.findAll();
    }

    @Override
    public TipoPersona tipoPersonaPorId(Long id) {
        return tipoPersonaRepository.findById(id).orElse(null);
    }

    @Override
    public TipoPersona modifcarTipoPersona(Long id, TipoPersona tipoPersona) {
        if(tipoPersonaRepository.existsById(id)){
            return tipoPersonaRepository.save(tipoPersona);
        }
        return null;
    }

    @Override
    public void eliminarTipoPersona(Long id) {
        if(tipoPersonaRepository.existsById(id)) {
            tipoPersonaRepository.deleteById(id);
        }
    }
}
