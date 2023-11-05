package com.jfnc.msventa.service.impl;

import com.jfnc.msventa.model.ResponseProducto;
import com.jfnc.msventa.model.ResponseUsuario;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ApiUsuarioExtImpl {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseUsuario obtenerUsuario(Long id) {
        String apiUrl = "http://localhost:8080/api/logins/usuarioPorId?id="+ id;
        org.springframework.http.HttpHeaders httpHeaders = new HttpHeaders();

        org.springframework.http.HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<ResponseUsuario> response=restTemplate.exchange(apiUrl, HttpMethod.GET, entity,ResponseUsuario.class);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        }else {

            throw new RuntimeException();
        }

    }
}
