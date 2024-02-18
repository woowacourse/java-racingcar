import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("객체가 정상적으로 생성된다.")
    void createObjectTest() {
        assertThatCode(() -> new Cars(List.of("pobi"), new RandomNumberGenerator()))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력된 이름이 없으면 예외가 발생한다.")
    void emptyListExceptionTest() {
        assertThatThrownBy(() -> new Cars(Collections.EMPTY_LIST, new RandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 이름을 사용하면 예외가 발생한다.")
    void duplicatedNameExceptionTest() {
        assertThatThrownBy(() -> new Cars(List.of("takan", "takan"), new RandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("우승자 선정이 정상적으로 동작한다.")
    void chooseWinnerTest() {
        Cars cars = new Cars(List.of(
                new Car("atto", new ConstantNumberGenerator(9)),
                new Car("takan", new ConstantNumberGenerator(0)),
                new Car("siso", new ConstantNumberGenerator(5))
        ));
        for (int round = 1; round <= 3; round++) {
            cars.tryMove();
        }

        assertThat(cars.getWinnersName())
                .containsAll(List.of("atto", "siso"));
    }
}
