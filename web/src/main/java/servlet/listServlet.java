package servlet;

import ru.fedorenko.Beans.AirBean;
import ru.fedorenko.Domain.AircraftEntity;

import javax.ejb.Stateless;
import javax.faces.context.ResponseWriter;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.List;

@Stateless
@Path("/")
public class listServlet{
        @Inject
        private AirBean airBean;

        @Path("aircrafts")
        @GET
        @Produces("application/json")
        public List<AircraftEntity> getAllAircraft() {
            return airBean.getAll();
        }

        @POST
        @Path("controller")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public JsonObject controller(String message) {
                JsonReader reader = Json.createReader(new StringReader(message));
                JsonObject obj = reader.readObject();

                String operation = obj.getString("oper");
                switch (operation) {
                        case "add":
                                addElement(obj);
                                break;
                        case "del":
                                deleteElement(obj);
                                break;
                        default:
                                editElement(obj);
                }
                return obj;
        }

        private void editElement(JsonObject obj) {
                String aircraft_code = obj.getString("aircraft_code");
                String model = obj.getString("model");
                Integer range = Integer.parseInt(obj.getString("range"));

                AircraftEntity air = new AircraftEntity();

                air.setAircraft_code(aircraft_code);
                air.setModel(model);
                air.setRange(range);
                airBean.updateAircraft(air);
                System.out.println(obj);

        }
        private void addElement(JsonObject obj) {

                String aircraft_code = obj.getString("aircraft_code");
                String model = obj.getString("model");
                Integer range = Integer.parseInt(obj.getString("range"));

                AircraftEntity air = new AircraftEntity();

                air.setAircraft_code(aircraft_code);
                air.setModel(model);
                air.setRange(range);
                airBean.newAir(air);
        }

        private void deleteElement(JsonObject obj) {

                String aircraft_code = obj.getString("id");
                airBean.removeAircraft(aircraft_code);
        }
}
