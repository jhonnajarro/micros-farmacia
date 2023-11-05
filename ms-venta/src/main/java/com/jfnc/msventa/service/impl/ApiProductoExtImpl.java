package com.jfnc.msventa.service.impl;

import com.jfnc.msventa.model.ResponseProducto;
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
public class ApiProductoExtImpl {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseProducto obtenerProducto(Long id) {
        String apiUrl = "http://localhost:8080/api/productos/listarPorId?id="+ id;
        HttpHeaders httpHeaders = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

    ResponseEntity<ResponseProducto> response=restTemplate.exchange(apiUrl, HttpMethod.GET, entity,ResponseProducto.class);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        }else {

            throw new RuntimeException();
        }

    }
}
