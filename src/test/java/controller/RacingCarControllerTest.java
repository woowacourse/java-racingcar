package controller;

import domain.Cars;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.OutputView;

class RacingCarControllerTest {
    final RacingCarController controller =
            new RacingCarController(new OutputView(), new InputView());

    @DisplayName("자동차 객체 리스트가 올바르게 생성된다")
    @Test
    void setCarTest() {
        List<String> carName = List.of("ash", "lily", "ella");
        Cars cars = controller.setCars(carName);

        Assertions.assertThat(cars.getCars().get(0).getCarName()).isEqualTo("ash");
        Assertions.assertThat(cars.getCars().get(0).getLocation()).isEqualTo(0);
    }

    @DisplayName("입력된 자동차 이름이 한 개라면 예외가 발생한다")
    @Test
    void amountTest() {
        Assertions.assertThatThrownBy(() -> controller.setCars(List.of("Ash")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("두 대 이상");
    }

    @DisplayName("입력된 자동차 이름 중에 중복되는 이름이 존재하면 예외가 발생한다")
    @Test
    void duplicationTest() {
        Assertions.assertThatThrownBy(() -> controller.setCars(List.of("Ash", "Ash", "Lily")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("시도횟수가 1이상이 아닌 경우 예외가 발생한다")
    @Test
    void validateNumberTest() {
        Assertions.assertThatThrownBy(() -> controller.validateNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수");
    }

    @DisplayName("시도횟수가 정수가 아닌 경우 예외가 발생한다")
    @Test
    void validateInputAttemptLimitTest() {
        Assertions.assertThatThrownBy(() -> controller.validateInputAttemptLimit("1.2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수");
    }
}
