import domain.*;
import io.InputView;
import io.OutputView;
import io.validator.InputValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

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
        this.carRacing = new CarRacing(new InputView(new InputValidator()), new OutputView());
    }

    @Test
    @DisplayName("자동차 생성 성공 테스트")
    void createCarsSuccess() {
        // given
        List<String> carNames = List.of("pobi","crong","honux");
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
    @MethodSource("createCarsFailTestArguments")
    @DisplayName("자동차 생성 실패 테스트")
    void createCarsFail(List<String> carNames) {
        assertThatThrownBy(() -> {
            carRacing.createCars(carNames, accelerator);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> createCarsFailTestArguments() {
        return Stream.of(
                Arguments.arguments(List.of("")),
                Arguments.arguments(List.of("pobi")),
                Arguments.arguments(List.of("aabbcc", "pobi"))
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1,5})
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
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TryCount.TRY_COUNT_RANGE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("우승자 판독 테스트")
    void decideWinners() {
        // given
        List<String> carNames = List.of("pobi","crong","honux");
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