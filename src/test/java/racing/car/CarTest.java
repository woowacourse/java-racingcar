package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.car.numbergenerator.FixedNumberGenerator;
import racing.car.numbergenerator.NumberGenerator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("같은 이름으로 생성한 두 객체가 같은지 테스트")
    @Test
    void name() {
        Name name1 = new Name("pobi");
        Car car1 = new Car(name1);
        Name name2 = new Name("pobi");
        Car car2 = new Car(name2);

        assertThat(car1).isEqualTo(car2);
    }

    @DisplayName("차를 전진하는 메서드 테스트")
    @Test
    void name2() {
        Name name = new Name("pobi");
        Car car = new Car(name);
        NumberGenerator fixed = new FixedNumberGenerator();
        car.go(fixed);

        assertThat(car.getDistance()).isEqualTo(2);
    }

    @DisplayName("가장 멀리간 차의 거리를 반환하는 메서드 테스트")
    @Test
    void name3() {
        //given
        Car car1 = new Car(new Name("a"));
        Car car2 = new Car(new Name("b"));
        Car car3 = new Car(new Name("c"));
        //when
        car1.go(new FixedNumberGenerator());
        car2.go(new FixedNumberGenerator());

        Cars cars = new Cars(Arrays.asList(car1, car2, car3));
        //then
        assertThat(cars.getWinner()).isEqualTo(new Winners(Arrays.asList(car1, car2)));
    }
}
