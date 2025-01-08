package br.com.acbueno.novaodessa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.acbueno.novaodessa.controller.dto.SensorDataDTO;
import br.com.acbueno.novaodessa.service.SensorDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/iot/sensors")
@Tag(name = "Sensors", description = "Enpoint iots sensors")
public class SensorDataController {

  @Autowired
  private SensorDataService service;

  //@formatter:off
  @Operation(summary="Retrieve all sensor data",description="Fetches all data collected from sensors.")
      @ApiResponses(value={@ApiResponse(responseCode="200",description="Successfully retrieved the list of sensor data",
      content=@Content(mediaType="application/json",schema=@Schema(implementation=SensorDataDTO.class))),
      @ApiResponse(responseCode="500",description="Internal Server Error")
  })
  //@formatter:on
  @GetMapping
  public ResponseEntity<List<SensorDataDTO>> getAllData() {
    try {
      return ResponseEntity.ok().body(service.getAllData());
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }

  //@formatter:off
  @Operation(summary = "Retrieve data fora specific sensor",
      description = "Fetches data collected from a specific sensor by its ID.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully retrieved the sensor data",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = SensorDataDTO.class))),
      @ApiResponse(responseCode = "500", description = "Internal server error")})
  //@formatter:on
  @GetMapping("/{sensorId}")
  public ResponseEntity<List<SensorDataDTO>> getDataSensorId(
      @PathVariable("sensorId") String sensorId) {
    try {
      return ResponseEntity.ok().body(service.getDataBySensor(sensorId));
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }

}
