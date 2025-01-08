package br.com.acbueno.novaodessa.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.acbueno.novaodessa.controller.dto.SensorDataDTO;
import lombok.Data;

@Document(collection = "sensor_data")
@Data
public class SensorData {

  @Autowired
  ModelMapper modelMapper;

  @Id
  private String id;

  @TextIndexed
  private String sensorId;

  private double temperature;

  private double soilHumidity;

  private double lightLevel;

  private LocalDateTime timestamp;

  public List<SensorData> convert(List<SensorDataDTO> listDTOs) {
    ModelMapper mapper = new ModelMapper();
    List<SensorData> listEntity = new ArrayList<>();
    listDTOs.forEach(it -> {
      listEntity.add(mapper.map(it, SensorData.class));
    });

    return listEntity;
  }

}
