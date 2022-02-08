package com.sti.project.controller;

import com.sti.project.dto.ProspectoDto;
import com.sti.project.model.status.ModelStatus;
import com.sti.project.repository.ProspectoRepository;
import com.sti.project.service.ProspectoService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProspectoControllerTest {

    @Autowired
    ProspectoDto prospectoDto;

    @Autowired
    Optional<ProspectoDto> prospectoDtoOptional;

    ProspectoService prospectoServiceMock = Mockito.mock(ProspectoService.class);

    @Autowired
    ProspectoController prospectoController = new ProspectoController(prospectoServiceMock);

    @BeforeEach
    void setUp() {
        ProspectoDto mockProspectoDTO = new ProspectoDto();

        mockProspectoDTO.setProspectoId("1");
        mockProspectoDTO.setProspectoName("Laurent Caceres");
        mockProspectoDTO.setProspectoAge(25);
        mockProspectoDTO.setProspectoMail("cacereesbjm97@gmail.com");
        mockProspectoDTO.setProspectoStatus(1);

        Mockito.when(prospectoServiceMock.findProspectoById("1")).thenReturn(mockProspectoDTO);
        Mockito.when(prospectoServiceMock.findProspectoByName("Laurent Caceres")).thenReturn(mockProspectoDTO);
    }

    @Test
    void findByProspectoId() {
        ResponseEntity<? extends ProspectoDto> respuestaServicioId;
        respuestaServicioId  = prospectoController.findByProspectoId("1");
        Assertions.assertEquals("1",respuestaServicioId.getBody().getProspectoId());
    }

    @Test
    void findProspectoByName(){
        ResponseEntity<? extends ProspectoDto> respuestaServicioName;
        respuestaServicioName = prospectoController.findProspectoByName("Laurent Caceres");
        Assertions.assertEquals("Laurent Caceres", respuestaServicioName.getBody().getProspectoName());
    }
}