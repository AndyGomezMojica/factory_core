package com.zaeta.core.areas.application;

import com.zaeta.core.areas.model.AreaModel;
import com.zaeta.core.areas.model.repository.AreaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GetAllAreasUseCase {

    @Autowired
    AreaRepository repository;

    public List<AreaModel> getAllAreas(){
        log.info("Se han traido todas las areas con estatus activo");
        return repository.findByAreaIsActive(true);
    }
}
