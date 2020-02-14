package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.view.OutputView;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @DisplayName("Cars 객체를 받아 통합하여 String으로 반환하는 메서드 테스트")
    @Test
    void name() {
        //given
        Car car1 = new Car(new Name("a"));
        Car car2 = new Car(new Name("b"));
        Car car3 = new Car(new Name("c"));
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        //when
        Winners winners = new Winners(cars);

        //then
        assertThat(OutputView.combine(winners)).isEqualTo("a, b, c");
    }
}
