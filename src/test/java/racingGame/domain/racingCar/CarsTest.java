package racingGame.domain.racingCar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.domain.utils.NameHandler;

import java.util.Arrays;
import java.util.List;

class CarsTest {
    @DisplayName("입력한 이름이 중복되는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pobi, pobi , pobi "})
    void expectDuplicatedExceptionTest(String nameString) {
        assertThatThrownBy(() -> {
            List names = NameHandler.splitNames(nameString);
            Cars.createByNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("cars가 null인 경우 예외 발생")
    @ParameterizedTest
    @NullSource
    void createCarsWithNull(List<Car> cars) {
        assertThatThrownBy(() -> {
            new Cars(cars);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("cars가 null인 names로 생성되는 경우 예외 발생")
    @ParameterizedTest
    @NullSource
    void createCarsWithNullNames(List<Name> names) {
        assertThatThrownBy(() -> {
            Cars.createByNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 이름 문자열에 이상이 없는 경우의 Cars 생성")
    @ParameterizedTest
    @ValueSource(strings = {"pobi, jin, corgi"})
    void checkInstanceWithValidNames(String input) {
        List<Name> names = NameHandler.splitNames(input);
        Cars cars = Cars.createByNames(names);

        for (Name name : names) {
            assertThat(cars.contains(Car.createByName(name))).isEqualTo(true);
        }
    }

    Car[] tmpCars;
    Cars testCars;

    @BeforeEach
    void setTestCars() {
        tmpCars = new Car[]{
                new Car(Name.create("t1"), 1),
                new Car(Name.create("t2"), 3),
                new Car(Name.create("t3"), 1),
                new Car(Name.create("t4"), 3),
                new Car(Name.create("t5"), 2)
        };

        testCars = new Cars(Arrays.asList(tmpCars));
    }

    @DisplayName("우승 자동차 기능 검증")
    @Test
    void checkGetWinner() {
        Cars winnerCars = Cars.createByNames(testCars.getWinnerNames());

        assertThat(winnerCars.contains(tmpCars[0])).isFalse();
        assertThat(winnerCars.contains(tmpCars[1])).isTrue();
        assertThat(winnerCars.contains(tmpCars[2])).isFalse();
        assertThat(winnerCars.contains(tmpCars[3])).isTrue();
        assertThat(winnerCars.contains(tmpCars[4])).isFalse();
    }

    @DisplayName("우승 자동차 기능 검증")
    @Test
    void checkGetWinnerWithCars() {
        final int[] injectionNumber = {1};

        tmpCars = new Car[]{
                new Car(Name.create("t1")),
                new Car(Name.create("t2")),
                new Car(Name.create("t3")),
                new Car(Name.create("t4")),
                new Car(Name.create("t5"))
        };

        Cars testCars = new Cars(Arrays.asList(tmpCars)) {
            @Override
            public int injectRand() {
                return injectionNumber[0]++;
            }
        };

        testCars.tryMoveCars();
        Cars winnerCars = Cars.createByNames(testCars.getWinnerNames());

        assertThat(winnerCars.contains(tmpCars[0])).isFalse(); // injection = 1, position = 0
        assertThat(winnerCars.contains(tmpCars[1])).isFalse(); // injection = 2, position = 0
        assertThat(winnerCars.contains(tmpCars[2])).isFalse(); // injection = 3, position = 0
        assertThat(winnerCars.contains(tmpCars[3])).isTrue();  // injection = 4, position = 1
        assertThat(winnerCars.contains(tmpCars[4])).isTrue();  // injection = 5, position = 1
    }
}
