import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import racingcar.CarRacing;
import racingcar.domain.Car;
import racingcar.domain.CarAccelerator;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.io.InputView;
import racingcar.io.OutputView;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarRacingTest {
    private static CarAccelerator accelerator;
    private CarRacing carRacing;

    @BeforeAll
    static void initAll() {
        accelerator = new CarAccelerator();
    }

    @BeforeEach
    void init() {
        this.carRacing = new CarRacing(new InputView(), new OutputView());
    }

    @Test
    @DisplayName("Cars 생성 성공 테스트")
    void createCarsSuccess() {
        // given
        List<String> carNames = List.of("pobi", "crong", "honux");
        // when
        List<Car> cars = carRacing.createCars(carNames).getCars();
        // then
        assertThat(cars).hasSize(3);
        assertAll(
                () -> assertThat(cars.get(0).getName()).isEqualTo("pobi"),
                () -> assertThat(cars.get(1).getName()).isEqualTo("crong"),
                () -> assertThat(cars.get(2).getName()).isEqualTo("honux")
        );
    }

    @Test
    @DisplayName("Cars 생성 실패 테스트")
    void createCarsFail() {
        assertThatThrownBy(() -> {
            carRacing.createCars(List.of("", "pobi", "aabbcc,pobi"));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 5, 10, 30, 40})
    @DisplayName("시도 횟수 생성 성공 테스트")
    void createTryCountSuccess(int tryAmount) {
        //when
        TryCount tryCount = carRacing.createTryCount(tryAmount);

        //then
        assertThat(tryCount.getValue()).isEqualTo(tryAmount);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -30})
    @DisplayName("시도 횟수 생성 실패 테스트")
    void createTryCountFail(int tryAmount) {
        assertThatThrownBy(() -> carRacing.createTryCount(tryAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}