package br.com.acbueno.hortolandia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SensorDataIotSimulatorApplication {

  public static void main(String[] args) {
    SpringApplication.run(SensorDataIotSimulatorApplication.class, args);
  }

}
