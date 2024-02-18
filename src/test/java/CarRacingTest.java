import common.exception.message.ExceptionMessage;
import common.exception.model.ValidateException;
import domain.Car;
import domain.CarRacing;
import domain.Cars;
import domain.TryCount;
import domain.accelerator.Accelerator;
import domain.accelerator.strategy.RandomMoveAccelerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;
import view.OutputView;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarRacingTest {
    private CarRacing carRacing;

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
        List<Car> cars = carRacing.createCars(carNames, new RandomMoveAccelerator()).getCars();
        // then
        assertThat(cars).hasSize(3);
        assertAll(
                () -> assertThat(cars.get(0).getName()).isEqualTo("pobi"),
                () -> assertThat(cars.get(1).getName()).isEqualTo("crong"),
                () -> assertThat(cars.get(2).getName()).isEqualTo("honux")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abcde"})
    @DisplayName("자동차 이름의 길이가 1 이상, 5 이하로 주어지면 자동차가 정상적으로 생성된다")
    void createCarsSuccessWithCarNameLength(String carNames) {
        assertThatCode(
                () -> carRacing.createCars(carNames, new RandomMoveAccelerator()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaa,bbb", "abc,pobi,crong,honux,zix"})
    @DisplayName("자동차의 수가 2 이상, 5 이하로 주어지면 자동차가 정상적으로 생성된다")
    void createCarsSuccessWithSize(String carNames) {
        assertThatCode(
                () -> carRacing.createCars(carNames, new RandomMoveAccelerator()));
    }


    @ParameterizedTest
    @ValueSource(strings = {"abc", "abc,pobi,crong,honux,zix,hox"})
    @DisplayName("자동차의 수가 2 미만, 5 초과이면 생성에 실패한다")
    void createCarsFailBySize(String carNames) {
        assertThatThrownBy(() -> {
            carRacing.createCars(carNames, new RandomMoveAccelerator());
        }).isInstanceOf(ValidateException.class)
                .hasMessage(ExceptionMessage.CARS_SIZE_RANGE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcd,abcd"})
    @DisplayName("자동차의 이름이 중복되면 생성에 실패한다")
    void createCarsFailByDuplication(String carNames) {
        assertThatThrownBy(() -> {
            carRacing.createCars(carNames, new RandomMoveAccelerator());
        }).isInstanceOf(ValidateException.class)
                .hasMessage(ExceptionMessage.CAR_NAME_DUPLICATION_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    @DisplayName("자동차 이름의 길이가 1 미만 5 초과로 주어지면 자동차가 정상적으로 생성되지 않는다")
    void createCarsFailCarNameLength(String carNames) {
        assertThatThrownBy(() -> {
            carRacing.createCars(carNames, new RandomMoveAccelerator());
        }).isInstanceOf(ValidateException.class)
                .hasMessage(ExceptionMessage.CAR_NAME_PATTERN_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "5"})
    @DisplayName("시도 횟수가 1 이상, 5 이하이면 시도 횟수가 정상적으로 생성된다.")
    void createTryCountSuccess(String tryAmount) {
        //when
        TryCount tryCount = carRacing.createTryCount(tryAmount);

        //then
        assertThat(tryCount.getValue()).isEqualTo(Integer.parseInt(tryAmount));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "6"})
    @DisplayName("시도 횟수가 1 미만, 5 초과이면 시도 횟수가 정상적으로 생성되지 않는다")
    void createTryCountFailByRange(String tryAmount) {
        assertThatThrownBy(() -> carRacing.createTryCount(tryAmount))
                .isInstanceOf(ValidateException.class)
                .hasMessage(ExceptionMessage.TRY_COUNT_RANGE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"시도", "try", "", " "})
    @DisplayName("시도 횟수가 정수 타입이 아니면 정상적으로 생성되지 않는다")
    void createTryCountFailByInputFormat(String tryAmount) {
        assertThatThrownBy(() -> carRacing.createTryCount(tryAmount))
                .isInstanceOf(ValidateException.class)
                .hasMessage(ExceptionMessage.INT_FORMAT_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("우승자 판독 테스트")
    void decideWinners() {
        // given
        String carNames = "pobi,crong,honux";
        // when
        Cars cars = carRacing.createCars(carNames, new RandomMoveAccelerator());
        List<String> actualWinners = carRacing.getWinners(cars);
        List<String> expectedWinners = List.of("pobi", "crong", "honux");
        //then
        assertAll(
                () -> assertThat(actualWinners).hasSize(expectedWinners.size()),
                () -> assertThat(actualWinners).containsExactlyElementsOf(expectedWinners)
        );
    }
}