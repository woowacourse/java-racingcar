package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    public static final int FORWARD_CRITERIA = 5;
    public static final int ALLEN = 0;
    public static final int POBI = 2;

    @Test
    void 자동차들_이름_나누기() {
        //given
        String inputNames = "123,324,456";
        Cars cars = new Cars(inputNames);
        List<String> expectedNameList = List.of("123", "324", "456");
        //when
        List<String> carNames = cars.getCars()
                .stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
        //then
        assertThat(carNames).isEqualTo(expectedNameList);
    }

    @ParameterizedTest
    @MethodSource("createCarsAndWinners")
    void 우승자들(Cars cars, List<String> expectedWinners) {
        //given
        List<String> winners = cars.getWinners();
        //then
        assertThat(winners).isEqualTo(expectedWinners);
    }

    private static Stream<Arguments> createCarsAndWinners() {
        String allen = "앨런";
        String lowoon = "로운";
        String pobi = "pobi";

        Cars cars = new Cars(String.join(",", allen, lowoon, pobi));
        List<Car> carsList = cars.getCars();
        carsList.get(ALLEN).movePositionAccordingToCondition(FORWARD_CRITERIA);
        carsList.get(POBI).movePositionAccordingToCondition(FORWARD_CRITERIA);

        return Stream.of(
                Arguments.of(cars, List.of(allen, pobi))
        );
    }
}