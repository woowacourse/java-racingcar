package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        String oneTeamMessage = "참가자는 2명 이상이어야합니다.";
        String hasOverFiveCharacterName = "123,123456,124";
        String fiveCharacterNameMessage = "이름은 5자 이하여야 합니다.";

        return Stream.of(
                Arguments.of(oneTeam, oneTeamMessage),
                Arguments.of(hasOverFiveCharacterName, fiveCharacterNameMessage)
        );
    }
}