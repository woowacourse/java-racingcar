package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarsNameTest {

    CarsName carsName;

    @BeforeEach
    void setUp() {
        carsName = new CarsName("pobi,  , , crong, honux");
    }

    @Test
    void 자동차_이름_생성_확인() {
        String[] result = {"pobi", "crong", "honux"};
        assertThat(carsName.getCarsName()).isEqualTo(result);
    }
}
