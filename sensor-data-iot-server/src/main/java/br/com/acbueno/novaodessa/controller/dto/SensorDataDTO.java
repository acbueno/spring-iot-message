package br.com.acbueno.novaodessa.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.acbueno.novaodessa.model.SensorData;
import lombok.Data;

@Data
public class SensorDataDTO {

  @JsonProperty("id")
  private String id;

  @JsonProperty("sendor-id")
  private String sensorId;

  @JsonProperty("temperature")
  private double temperature;

  @JsonProperty("soil-humidity")
  private double soilHumidity;

  @JsonProperty("light-level")
  private double lightLevel;

  @JsonProperty("time-stamp")
  private LocalDateTime timestamp;

  public static SensorDataDTO convert(SensorData entity) {
    ModelMapper mapper = new ModelMapper();
    return mapper.map(entity, SensorDataDTO.class);
  }

  public static List<SensorDataDTO> convert(List<SensorData> listEntity) {
    ModelMapper mapper = new ModelMapper();
    List<SensorDataDTO> listDTO = new ArrayList<>();
    listEntity.forEach(it -> {
      listDTO.add(mapper.map(it, SensorDataDTO.class));
    });

    return listDTO;
  }

}
