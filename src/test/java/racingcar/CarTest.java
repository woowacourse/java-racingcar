package racingcar;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car = new Car();
    @Test
    void 유저들_이름_나누기() {
        //given
        String inputNames = "123,324,456";
        List<String> expectedNameList = List.of("123", "324", "456");
        //the
        assertThat(car.splitNames(inputNames)).isEqualTo(expectedNameList);
    }
}