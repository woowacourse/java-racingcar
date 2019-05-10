package racing.game;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNameInputHandlerTest {
    @Test
    void 입력을이름들로분리() {
        String string = "pobi,jinwook";
        assertThat(CarNameInputHandler.splitNames(string)).contains("pobi", "jinwook");
    }


    @Test
    void 입력에서중복된이름이있는지확인() {
        String name = "pobi";
        try {
            List<Car> cars = new ArrayList<>();
            Car car = new Car(name);
            cars.add(car);
            assertThat(CarNameInputHandler.checkRepetition(name, cars)).isTrue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
