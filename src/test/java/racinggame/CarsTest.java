package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    Cars cars;
    CarsName carsName;

    @BeforeEach
    void setUp() {
        carsName = new CarsName("pobi, crong, honux");
        cars = new Cars(carsName);
    }

    @Test
    void 객체_생성_확인() {
        String result = cars.toString();
        assertThat(result).isEqualTo("[pobi, crong, honux]");
    }
}
