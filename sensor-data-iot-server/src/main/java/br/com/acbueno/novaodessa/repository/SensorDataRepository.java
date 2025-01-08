package br.com.acbueno.novaodessa.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.acbueno.novaodessa.model.SensorData;

@Repository
public interface SensorDataRepository extends MongoRepository<SensorData, String> {

  List<SensorData> findBySensorId(String sensorId);


}
