package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.provider.TestProvider;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"} )
    @DisplayName("정상적인 차량 이름이 들어오면 예외가 발생하지 않는다.")
    void givenNormalCarNames_thenSuccess(String carNames) {
        assertThatCode(() -> Cars.of(carNames))
                .doesNotThrowAnyException();

        assertThat(Cars.of(carNames))
                .isEqualTo(TestProvider.createTestCars());
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("차량 이름에 null값이 들어오면 split 시 에외가 발생한다.")
    void givenNullCarNames_thenFail(String carNames) {
        assertThatThrownBy(() -> Cars.of(carNames))
                .isInstanceOf(NullPointerException.class);
    }


    @ParameterizedTest
    @ValueSource (ints = {4, 9})
    @DisplayName("랜덤값이 4 이상이면 자동차가 전진한다.")
    void givenFourMoreNumber_thenCarMove(int randomNumber) throws Exception {
        // given
        Cars cars = TestProvider.createTestCars();
        Car car = TestProvider.createTestCar();

        // when
        Method method = cars.getClass().getDeclaredMethod("checkNumberAndMove", Car.class, int.class);
        method.setAccessible(true);
        method.invoke(cars, car, randomNumber);

        // then
        assertThat(car)
                .isEqualTo(TestProvider.createTestMoveCar());
    }

    @ParameterizedTest
    @ValueSource (ints = {0, 3})
    @DisplayName("랜덤값이 3 이하면 자동차가 정지한다.")
    void givenThreeLessNumber_thenCarStop(int randomNumber) throws Exception {
        // given
        Cars cars = TestProvider.createTestCars();
        Car car = TestProvider.createTestCar();

        // when
        Method method = cars.getClass().getDeclaredMethod("checkNumberAndMove", Car.class, int.class);
        method.setAccessible(true);
        method.invoke(cars, car, randomNumber);

        // then
        assertThat(car)
                .isEqualTo(TestProvider.createTestCar());
    }
}