package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.util.FixedNumberGenerator;
import racingCar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class CarGroupTest {

    private CarGroup carGroup;
    @BeforeEach
    void beforeEach() {
        carGroup = new CarGroup(List.of("a", "b", "c"));
    }

    @Test
    @DisplayName("자동차 이름들에 중복이 있는 경우")
    void carGroupTest_fail() {
        List<String> carNames = List.of("abc", "abc");

        Assertions.assertThatThrownBy(()->{
            new CarGroup(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름들이 빈 리스트일 경우")
    void carGroupTest_failIfEmpty() {
        List<String> carNames = new ArrayList<>();

        Assertions.assertThatThrownBy(()->{
            new CarGroup(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차들이 0-3의 숫자를 받으면 이동하지 않음 ")
    void carGroupMoveTest_notMove() {
        carGroup.moveCars(new FixedNumberGenerator(3));
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
        carGroup.moveCars(new FixedNumberGenerator(4));
        List<Car> afterCarGroup = carGroup.getCarGroup();

        long count = afterCarGroup.stream()
                .map(Car::getPosition)
                .filter(position -> position == 0)
                .count();
        Assertions.assertThat(count).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차들의 position 중 가장 높은 position 값을 가져온다")
    void getHighestPositionTest() {
        for (int tryCount = 0; tryCount < 20; tryCount++) {
            carGroup.moveCars(new RandomNumberGenerator());
        }

        List<Car> cars = carGroup.getCarGroup();
        int firstPosition = cars.stream()
                .map(Car::getPosition)
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .get();

        int highestPosition = carGroup.getHighestPosition();

        Assertions.assertThat(highestPosition).isEqualTo(firstPosition);
    }

    @Test
    @DisplayName("자동차들이 움직이지 않았을 경우에 모두가 가장 높은 position이기에 이름들을 전부 가져온다.")
    void findWinnersTest() {
        List<String> names = carGroup.getCarGroup().stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        Assertions.assertThat(carGroup.findWinners()).isEqualTo(names);
    }
}
