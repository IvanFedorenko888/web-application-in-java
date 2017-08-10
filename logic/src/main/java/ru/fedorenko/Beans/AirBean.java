package ru.fedorenko.Beans;

import org.apache.ibatis.session.SqlSession;
import ru.fedorenko.Domain.AircraftEntity;
import ru.fedorenko.Mybatis.Mybatis;

import java.util.List;

/**
 * Created by ivan on 28.05.17.
 */
public class AirBean {

    public void newAir (AircraftEntity aircraftEntity)
    {
        SqlSession session = Mybatis.getFactory().openSession();

            MapperAircraft mapper = session.getMapper(MapperAircraft.class);
            mapper.addAircraft(aircraftEntity);
            session.commit();
            session.close();

    }

    public List<AircraftEntity> getAll(){
        SqlSession session = Mybatis.getFactory().openSession();
        try{
            MapperAircraft mapperAircraft = session.getMapper(MapperAircraft.class);
            return mapperAircraft.listAll();
        }
        finally {
            session.close();
        }
    }


    public void updateAircraft(AircraftEntity aircraftEntity) {
        SqlSession session = Mybatis.getFactory().openSession();

        MapperAircraft mapper = session.getMapper(MapperAircraft.class);
        mapper.updateAir(aircraftEntity);
        session.commit();
        session.close();
    }

    public void removeAircraft(String aircraftEntity) {
        SqlSession session = Mybatis.getFactory().openSession();

        MapperAircraft mapper = session.getMapper(MapperAircraft.class);
        mapper.deleteAir(aircraftEntity);
        session.commit();
        session.close();
    }
}
