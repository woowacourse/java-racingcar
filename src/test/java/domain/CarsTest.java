package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidateException;
import domain.accelerator.Accelerator;
import domain.accelerator.strategy.MoveAccelerator;
import domain.accelerator.strategy.RandomMoveAccelerator;
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

    @ParameterizedTest
    @MethodSource("createCarsSuccessWithSizeArguments")
    @DisplayName("입력받은 자동차의 개수가 2대 이상 5대 이하이면 객체 생성에 성공한다")
    void createCarsSuccessWithSize(final List<Car> cars) {
        Assertions.assertThatCode(() -> new Cars(cars));
    }

    static Stream<Arguments> createCarsSuccessWithSizeArguments() {
        return Stream.of(
                Arguments.arguments(List.of(new Car("pobi", new RandomMoveAccelerator()), new Car("crong", new RandomMoveAccelerator()))),
                Arguments.arguments(List.of(new Car("po", new RandomMoveAccelerator()), new Car("bi", new RandomMoveAccelerator()), new Car("cr", new RandomMoveAccelerator()), new Car("ro", new RandomMoveAccelerator()), new Car("ng", new RandomMoveAccelerator())))
        );
    }

    @Test
    @DisplayName("입력받은 자동차의 개수가 1대 이하이면 객체 생성에 실패한다")
    void createCarsFail() {
        //given
        Car car = new Car("pobi", new RandomMoveAccelerator());
        List<Car> carInfos = List.of(car);
        //when
        //then
        Assertions.assertThatThrownBy(() -> new Cars(carInfos))
                .isInstanceOf(ValidateException.class)
                .hasMessage(ExceptionMessage.CARS_SIZE_RANGE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("입력받은 자동차의 이름에 중복이 있으면 객체 생성에 실패한다")
    void createCarsFailWhenNameDuplicated() {
        //given
        Car car1 = new Car("pobi", new RandomMoveAccelerator());
        Car car2 = new Car("pobi", new RandomMoveAccelerator());
        List<Car> carInfos = List.of(car1, car2);
        //when
        //then
        Assertions.assertThatThrownBy(() -> new Cars(carInfos))
                .isInstanceOf(ValidateException.class)
                .hasMessage(ExceptionMessage.CAR_NAME_DUPLICATION_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("자동차들 중 가장 많이 이동한 차량의 Position을 반환한다")
    void getCarsMaxPosition() {
        //given
        Accelerator accelerator = new MoveAccelerator();
        Car car1 = new Car("pobi", accelerator);
        Car car2 = new Car("crong", accelerator);
        Car car3 = new Car("honux", accelerator);

        List<Car> carInfos = List.of(car1, car2, car3);
        Cars cars = new Cars(carInfos);

        //when
        car1.pushAccelerator();
        car1.pushAccelerator();
        car1.pushAccelerator();

        car2.pushAccelerator();
        car2.pushAccelerator();

        car3.pushAccelerator();

        //then
        Assertions.assertThat(cars.getWinnerPosition()).isEqualTo(3);
    }

}