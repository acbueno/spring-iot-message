package br.com.acbueno.hortolandia.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import br.com.acbueno.hortolandia.config.RabbitMQConfig;
import br.com.acbueno.hortolandia.model.SensorData;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQProducer {

  private final RabbitTemplate rabbitTemplate;

  public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void sendMenssage(SensorData sensorData) {
    rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, sensorData);
    log.info("Sent Message: {}", sensorData);
  }

}
