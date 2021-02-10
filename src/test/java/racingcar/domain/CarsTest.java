package racingcar.domain;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.utils.NameHandler;

import java.util.ArrayList;
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

    @DisplayName("입력한 이름이 하나 뿐인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    void expectOnlyCarExceptionTest(String onlyName) {
        assertThatThrownBy(() -> {
            List names = Arrays.asList(new Name[]{Name.create(onlyName)});
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

    @DisplayName("우승 자동차 기능 검증")
    @Test
    void checkGetWinner() {
        Car[] tmpCars = new Car[]{
                new Car(Name.create("t1"), 1),
                new Car(Name.create("t2"), 3),
                new Car(Name.create("t3"), 1),
                new Car(Name.create("t4"), 3),
                new Car(Name.create("t5"), 2)
        };

        Cars testCars = new Cars(Arrays.asList(tmpCars));
        Cars winnerCars = Cars.createByNames(testCars.getWinnerNames());

        assertThat(winnerCars.contains(tmpCars[0])).isFalse();
        assertThat(winnerCars.contains(tmpCars[1])).isTrue();
        assertThat(winnerCars.contains(tmpCars[2])).isFalse();
        assertThat(winnerCars.contains(tmpCars[3])).isTrue();
        assertThat(winnerCars.contains(tmpCars[4])).isFalse();
    }
}
