package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRepositoryTest {

    @Test
    @DisplayName("중복된 자동차 이름을 입력한 경우 예외 발생")
    void carNameMustNotDuplicated() {
        String[] carNames = {"woo", "te", "co", "woo"};

        assertThatThrownBy(() -> new CarRepository(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("한명의 올바른 최종 우승자를 선택하는지 확인")
    void selectOneRightWinner() {
        CarRepository cars = new CarRepository(new String[]{"woo", "te", "co"});

        Car co = cars.getCar("co");
        co.move(9);
        co.move(9);

        assertThat(cars.selectWinners()).containsExactly("co");
    }

    @Test
    @DisplayName("여러명의 올바른 최종 우승자를 선택하는지 확인")
    void selectManyRightWinner() {
        CarRepository cars = new CarRepository(new String[]{"woo", "te", "co"});

        Car te = cars.getCar("te");
        te.move(9);
        te.move(9);

        Car co = cars.getCar("co");
        co.move(9);
        co.move(9);

        List<String> winners = cars.selectWinners();

        assertThat(winners).contains("te");
        assertThat(winners).contains("co");
    }
}
