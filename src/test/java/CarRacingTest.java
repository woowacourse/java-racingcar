import domain.*;
import io.InputView;
import io.OutputView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarRacingTest {
    private CarRacing carRacing;

    private static CarAccelerator accelerator;

    @BeforeAll
    static void initAll() {
        accelerator = new CarAccelerator();
    }

    @BeforeEach
    void init() {
        this.carRacing = new CarRacing(new InputView(), new OutputView());
    }

    @Test
    @DisplayName("자동차 생성 성공 테스트")
    void createCarsSuccess() {
        // given
        String carNames = "pobi,crong,honux";
        // when
        List<Car> cars = carRacing.createCars(carNames, accelerator).getCars();
        // then
        assertThat(cars).hasSize(3);
        assertAll(
                () -> assertThat(cars.get(0).getName()).isEqualTo("pobi"),
                () -> assertThat(cars.get(1).getName()).isEqualTo("crong"),
                () -> assertThat(cars.get(2).getName()).isEqualTo("honux")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "pobi", "aabbcc,pobi"})
    @DisplayName("자동차 생성 실패 테스트")
    void createCarsFail(String carNames) {
        assertThatThrownBy(() -> {
            carRacing.createCars(carNames, accelerator);
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

    @Test
    @DisplayName("우승자 판독 테스트")
    void decideWinners() {
        // given
        String carNames = "pobi,crong,honux";
        // when
        Cars cars = carRacing.createCars(carNames, accelerator);
        List<String> actualWinners = carRacing.getWinners(cars);
        List<String> expectedWinners = List.of("pobi", "crong", "honux");
        //then
        assertAll(
                () -> assertThat(actualWinners).hasSize(expectedWinners.size()),
                () -> assertThat(actualWinners).containsExactlyElementsOf(expectedWinners)
        );
    }
}