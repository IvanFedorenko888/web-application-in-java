import com.google.gson.Gson;
import org.junit.Before;
import ru.fedorenko.Beans.AirBean;
import ru.fedorenko.Domain.AircraftEntity;

import javax.inject.Inject;
import java.util.List;

public class Test {

   private AirBean bean = new AirBean();
   private AircraftEntity entity = new AircraftEntity();

    /*@Before
    public void beforeTest()
    {
        entity.setAircraft_code("TYE");
        entity.setModel("Boing");
        entity.setRange(1234);
    }
*/
    @org.junit.Test
    public void main() {
        List<AircraftEntity> aircraftEntities = bean.getAll();
        Gson gson = new Gson();
        String json = gson.toJson(aircraftEntities);
        System.out.println(json);
    }
}
