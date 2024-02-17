package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class CarsTest {
    private static CarAccelerator accelerator;

    @BeforeAll
    static void init() {
        accelerator = new CarAccelerator();
    }


    @ParameterizedTest
    @MethodSource("createCarsSuccessWithSizeArguments")
    @DisplayName("입력받은 자동차의 개수가 2대 이상 5대 이하이면 객체 생성에 성공한다")
    void createCarsSuccessWithSize(final List<Car> cars) {
        Assertions.assertThatCode(() -> new Cars(cars));
    }

    static Stream<Arguments> createCarsSuccessWithSizeArguments() {
        return Stream.of(
                Arguments.arguments(List.of(new Car("pobi", accelerator), new Car("crong", accelerator))),
                Arguments.arguments(List.of(new Car("po", accelerator), new Car("bi", accelerator), new Car("cr", accelerator), new Car("ro", accelerator), new Car("ng", accelerator)))
        );
    }

    @Test
    @DisplayName("입력받은 자동차의 개수가 1대 이하이면 객체 생성에 실패한다")
    void createCarsFail() {
        //given
        Car car = new Car("pobi", accelerator);
        List<Car> carInfos = List.of(car);
        //when
        //then
        Assertions.assertThatThrownBy(() -> new Cars(carInfos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Cars.CARS_SIZE_RANGE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("입력받은 자동차의 이름에 중복이 있으면 객체 생성에 실패한다")
    void createCarsFailWhenNameDuplicated() {
        //given
        Car car1 = new Car("pobi", accelerator);
        Car car2 = new Car("pobi", accelerator);
        List<Car> carInfos = List.of(car1, car2);
        //when
        //then
        Assertions.assertThatThrownBy(() -> new Cars(carInfos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Cars.CAR_NAME_DUPLICATION_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("자동차들 중 가장 많이 이동한 차량의 Position을 반환한다")
    void getCarsMaxPosition() {
        //given
        CarAccelerator carAccelerator = new CarAccelerator();
        Car car1 = new Car("pobi", carAccelerator);
        Car car2 = new Car("crong", carAccelerator);
        Car car3 = new Car("honux", carAccelerator);

        List<Car> carInfos = List.of(car1, car2, car3);
        Cars cars = new Cars(carInfos);

        //when
        car1.moveForward(4);
        car1.moveForward(4);
        car1.moveForward(4);

        car2.moveForward(4);
        car2.moveForward(4);

        car3.moveForward(4);

        //then
        Assertions.assertThat(cars.getWinnerPosition()).isEqualTo(3);
    }

}