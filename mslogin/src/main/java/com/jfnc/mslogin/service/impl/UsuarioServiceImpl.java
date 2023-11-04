package com.jfnc.mslogin.service.impl;

import com.jfnc.mslogin.entity.Usuario;
import com.jfnc.mslogin.exception.ModeloNotFoundException;
import com.jfnc.mslogin.repository.UsuarioRepository;
import com.jfnc.mslogin.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario crearUsuario(Usuario usuario) throws Exception {
        if(usuario.getPersona().getTipoPersona().getIdTipoPersona()==2 && usuario.getPersona().getEstado()==1) {
            usuario.setEstado(1);
            usuario.setFechaCrea(new Date());

            return usuarioRepository.save(usuario);
        }else{
            throw new ModeloNotFoundException("La Persona es un Cliente y no Puede ser Usuario");
        }
        }

    @Override
    public List<Usuario> listarUsuario() {
        List<Usuario> usuarios= usuarioRepository.findAllByEstado(1);
        return usuarios;
    }

    @Override
    public Usuario usuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario modificarUsuario(Long id, Usuario usuario) {
        if(usuarioRepository.existsById(id)){
            usuario.setFechaMod(new Date());
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @Override
    public Usuario eliminarUsuario(Long id) {
        if(usuarioRepository.existsById(id)){
            Usuario usuario= usuarioRepository.findById(id).orElse(null);
            usuario.setFechaMod(new Date());
            usuario.setEstado(0);
            return usuarioRepository.save(usuario);
        }
        return null;
    }
}
