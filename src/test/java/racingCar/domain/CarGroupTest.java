package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.util.NumberGenerator;
import racingCar.util.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CarGroupTest {

    @Test
    @DisplayName("자동차 이름들에 중복이 있는 경우")
    void carGroupTest_fail() {
        List<String> carNames = List.of("abc", "abc");

        Assertions.assertThatThrownBy(()->{
            new CarGroup(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차들이 0-3의 숫자를 받으면 이동하지 않음 ")
    void carGroupMoveTest_notMove() {
        CarGroup carGroup = new CarGroup(List.of("a", "b", "c"));
        carGroup.moveCars(0, 3);
        List<Car> afterCarGroup = carGroup.getCarGroup();

        long count = afterCarGroup.stream()
                .map(Car::getPosition)
                .filter(position -> position > 0)
                .count();
        Assertions.assertThat(count).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차들이 4-9의 숫자를 받으면 이동")
    void carGroupMoveTest_Move() {
        CarGroup carGroup = new CarGroup(List.of("a", "b", "c"));
        carGroup.moveCars(4, 9);
        List<Car> afterCarGroup = carGroup.getCarGroup();

        long count = afterCarGroup.stream()
                .map(Car::getPosition)
                .filter(position -> position == 0)
                .count();
        Assertions.assertThat(count).isEqualTo(0);
    }
}