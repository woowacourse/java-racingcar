package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {
    public static final int ALLEN = 0;
    public static final int POBI = 2;

    @Test
    void splitCarNames() {
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
    void getWinners(Cars cars, List<String> expectedWinners) {
        //when
        List<String> winners = cars.getWinners();
        //then
        assertThat(winners).isEqualTo(expectedWinners);
    }

    private static Stream<Arguments> createCarsAndWinners() {
        String allen = "앨런";
        String lowoon = "로운";
        String pobi = "pobi";

        Cars cars = new Cars(String.join(Cars.DELIMITER, allen, lowoon, pobi));
        List<Car> carsList = cars.getCars();
        carsList.get(ALLEN).moveForward();
        carsList.get(POBI).moveForward();

        return Stream.of(
                Arguments.of(cars, List.of(allen, pobi))
        );
    }

    @ParameterizedTest
    @MethodSource("createNamesAndMessage")
    void validateCars(String inputNames, String message) {
        assertThatThrownBy(() -> {
            Cars cars = new Cars(inputNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    private static Stream<Arguments> createNamesAndMessage() {
        String oneTeam = "앨런";
        String oneTeamMessage = "참가자는 " + Cars.MINIMUM_TEAM + "명 이상이어야합니다.";
        String hasOverFiveCharacterName = "123,123456,124";
        String fiveCharacterNameMessage = "이름은 " + Car.MAXIMUM_NAME + "자 이하여야 합니다.";

        return Stream.of(
                Arguments.of(oneTeam, oneTeamMessage),
                Arguments.of(hasOverFiveCharacterName, fiveCharacterNameMessage)
        );
    }
}