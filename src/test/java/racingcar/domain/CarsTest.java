package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {
    private static final List<String> defaultCarNames = Arrays.asList("포비", "웨지", "삭정");

    @DisplayName("우승자 가려내는지 테스트")
    @ParameterizedTest
    @MethodSource("provideRaceWinnerCases")
    void findWinners_우승자_올바르게_가려내는지(List<String> carNames, List<String> expectedWinnerNames) {
        Cars cars = proceedRaceAccordingToWinnerNames(new Cars(carNames), expectedWinnerNames);
        WinnersDto winnersDto = new WinnersDto(cars.findWinners());

        List<String> winnerNames = winnersDto.getWinnerNames();
        assertThat(winnerNames).isEqualTo(expectedWinnerNames);
    }

    private static Stream<Arguments> provideRaceWinnerCases() {
        List<String> winnerNames1 = Arrays.asList("포비");
        List<String> winnerNames2 = Arrays.asList("웨지");
        List<String> winnerNames3 = Arrays.asList("포비", "웨지");
        List<String> winnerNames4 = Arrays.asList("포비", "웨지", "삭정");

        return Stream.of(
                Arguments.of(defaultCarNames, winnerNames1),
                Arguments.of(defaultCarNames, winnerNames2),
                Arguments.of(defaultCarNames, winnerNames3),
                Arguments.of(defaultCarNames, winnerNames4)
        );
    }

    private static Cars proceedRaceAccordingToWinnerNames(Cars cars, List<String> winnerNames) {
        cars.getCars()
                .stream()
                .filter(car -> winnerNames.contains(car.getName()))
                .forEach(car -> car.move(5));

        return cars;
    }
}