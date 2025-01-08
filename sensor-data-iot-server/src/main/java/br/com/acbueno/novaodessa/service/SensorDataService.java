package br.com.acbueno.novaodessa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.acbueno.novaodessa.controller.dto.SensorDataDTO;
import br.com.acbueno.novaodessa.repository.SensorDataRepository;

@Service
public class SensorDataService {

  @Autowired
  SensorDataRepository repository;

  public List<SensorDataDTO> getAllData() {
    return SensorDataDTO.convert(repository.findAll());
  }

  public List<SensorDataDTO> getDataBySensor(String sensorId) {
    return SensorDataDTO.convert(repository.findBySensorId(sensorId));
  }

}
