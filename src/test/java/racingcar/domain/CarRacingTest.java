package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("경주 객체 테스트")
public class CarRacingTest {
    private static final char ANY_CHAR_BUT_COMMA = '!';

    @ParameterizedTest
    @CsvFileSource(resources = "/racingtestcase/illegalCarNamesTestcase.csv", delimiter = ANY_CHAR_BUT_COMMA)
    @DisplayName("잘못된 이름이 하나라도 있을 때 테스트")
    void illegalNamesTest (String names){
        List<String> nameList = Arrays.asList(names.split(","));

        assertThatThrownBy(() -> new CarRacing(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("모든 차들의 위치가 적절한 범위안에 있는지 테스트")
    void moveTest() {
        String[] names = {"a","b","c","d","e","f","g"};
        CarRacing carRacing = new CarRacing(Arrays.asList(names));

        int range = 5;
        moveMultipleTimes(carRacing, range);

        carRacing.getCars().stream()
                .forEach(car -> assertThat(car.getDistance()).isBetween(0,range));
    }

    @Test
    @DisplayName("우승자들보다 멀리 간 자동차가 없는지 테스트")
    void winnerTest() {
        String[] names = {"a","b","c","d","e","f","g"};
        CarRacing carRacing = new CarRacing(Arrays.asList(names));

        int range = 5;
        moveMultipleTimes(carRacing, range);

        carRacing.getWinners().stream()
                .forEach(winner -> checkIfWinnerhasLargestDistance(carRacing.getCars(), winner));
    }

    void checkIfWinnerhasLargestDistance(List<Car> cars, Car winner) {
        assertThat(cars.stream()
                .filter(car -> car.getDistance() > winner.getDistance())
                .count()).isEqualTo(0);
    }

    void moveMultipleTimes(CarRacing carRacing, int number) {
        for (int i = 0; i < number; i++) {
            carRacing.move();
        }
    }
}
