package com.consultaCep.consulta_cep.mock;

import com.github.tomakehurst.wiremock.WireMockServer;

import jakarta.annotation.PostConstruct;
import wiremock.net.minidev.json.JSONObject;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import org.springframework.stereotype.Component;

@Component
public class ViaCepMock {
    @PostConstruct
    public static WireMockServer startMock() {
        WireMockServer wireMockServer = new WireMockServer(8089);
        wireMockServer.start();

        JSONObject okJson = new JSONObject();
        okJson.put("cep", "12345-678");
        okJson.put("logradouro", "teste mock");
        okJson.put("complemento", "teste mock");
        okJson.put("unidade", "");
        okJson.put("bairro", "teste mock");
        okJson.put("localidade", "teste mock");
        okJson.put("uf", "TM");
        okJson.put("estado", "teste mock");
        okJson.put("regiao", "teste mock");
        okJson.put("ibge", "teste mock");
        okJson.put("gia", "teste mock");
        okJson.put("ddd", "00");
        okJson.put("siafi", "0000");
        
        wireMockServer.stubFor(get(urlMatching("/ws/.*?/json/"))
            .willReturn(okJson(okJson.toString())));

        return wireMockServer;
    }
}