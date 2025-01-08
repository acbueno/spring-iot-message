package br.com.acbueno.novaodessa.consumer;

import java.time.LocalDateTime;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.acbueno.novaodessa.model.SensorData;
import br.com.acbueno.novaodessa.repository.SensorDataRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RabbiMQConsumer {

  @Autowired
  private SensorDataRepository repository;

  @RabbitListener(queues = "sensor_data_queue")
  public void consumerMessage(SensorData sensorData) {
    sensorData.setTimestamp(LocalDateTime.now());
    repository.save(sensorData);
    log.info("Message received: {}", sensorData.toString());
  }

}
