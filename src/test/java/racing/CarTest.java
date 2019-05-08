package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car1;
    Car car2;
    ArrayList<Car> carList = new ArrayList<>();
    @BeforeEach
    void setUp() {
        car1 = new Car("Lamborghini",100);
        car2 = new Car("kia", 1);
        carList.add(car1);
        carList.add(car2);
        carList.add(new Car("k5",100));
    }

    @Test
    void 전진잘하나요() {
        assertThat(car1.goOrStop(5)).isEqualTo(true);
    }

    @Test
    void 후진잘하나요() {
        assertThat(car1.goOrStop(3)).isEqualTo(false);
    }

    @Test
    void 이동비교잘되나요(){
        assertThat(Collections.max(carList)).isEqualTo(car1);
    }
}