package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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

        assertThatThrownBy(() -> nameList.stream().map(Name::new).collect(Collectors.toList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하의 비어있지 않은 이름이어야 합니다.");
    }

    @Test
    @DisplayName("우승자들보다 멀리 간 자동차가 없는지 테스트")
    void winnerTest() {
        int range = 5;
        List<Name> names = Arrays.asList("a","b","c","d","e","f","g").stream()
                .map(Name::new)
                .collect(Collectors.toList());
        List<CarData> carData = names.stream()
                .map((name) -> new CarData(name, 0))
                .collect(Collectors.toList());

        CarRacing carRacing = new CarRacing(carData);
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

    @Test
    @DisplayName("자동차들의 거리 지정해주고 우승자 테스트")
    void winnerTestWithFixedPosition() {
        List<Name> names = Arrays.asList("a","b","c","d","e","f","g").stream()
                .map(Name::new)
                .collect(Collectors.toList());
        List<CarData> carData = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            carData.add(new CarData(names.get(i), i));
        }
        CarRacing carRacing = new CarRacing(carData);

        assertThat(carRacing.getWinners().size()).isEqualTo(1);
        assertThat(carRacing.getWinners().get(0).getName()).isEqualTo("g");
    }
}
