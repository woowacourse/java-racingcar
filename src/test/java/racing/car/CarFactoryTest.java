package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @DisplayName("입력받은 이름을 가지고 차를 생성한다.")
    @Test
    void makeCars() {
        //given
        List<String> names = Arrays.asList("pobi", "bebop");

        //when
        Cars cars = CarFactory.makeCars(names);

        //then
        Car pobi = new Car(new Name("pobi"));
        Car bebop = new Car(new Name("bebop"));

        Cars expectCars = new Cars(Arrays.asList(pobi, bebop));
        assertThat(cars).isEqualTo(expectCars);
    }
}