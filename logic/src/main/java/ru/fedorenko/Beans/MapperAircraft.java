package ru.fedorenko.Beans;

import ru.fedorenko.Domain.AircraftEntity;

import java.util.List;

/**
 * Created by ivan on 23.06.17.
 */
public interface MapperAircraft {

   void addAircraft(AircraftEntity aircraftEntity);
   List<AircraftEntity> listAll();
   void updateAir(AircraftEntity aircraftEntity);
   void deleteAir(String aircraftEntity);
}
