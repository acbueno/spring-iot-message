package br.com.acbueno.hortolandia.producer;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import br.com.acbueno.hortolandia.model.SensorData;

@Component
public class RamdomDataGenerator {

  private final RabbitMQProducer producer;
  private final Random random = new Random();

  public RamdomDataGenerator(RabbitMQProducer rabbitMQProducer) {
    this.producer = rabbitMQProducer;
  }

  @Scheduled(fixedRate = 5000)
  public void generateDataAndSendData() {
    SensorData data = new SensorData();
    data.setSensorId(UUID.randomUUID().toString());
    data.setTemperature(20 + random.nextDouble() * 15);
    data.setSoilHumidity(30 + random.nextDouble() * 40);
    data.setTimestamp(LocalDateTime.now());
    producer.sendMenssage(data);
  }



}
