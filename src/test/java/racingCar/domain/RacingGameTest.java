package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingCar.domain.dto.CarDto;

@SuppressWarnings("NonAsciiCharacters")
public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setup() {
        racingGame = new RacingGame("juri,hunch", "5");
    }

    @Test
    void 생성자_cars_값이_들어가는지_테스트() {
        //when
        List<String> names = new ArrayList<>();
        for (CarDto carDTO : racingGame.getResult()) {
            names.add(carDTO.getName());
        }

        //then
        assertThat(names).isEqualTo(Arrays.asList("juri", "hunch"));
    }

    @Test
    void 생성자_roundCount_값이_들어가는지_테스트() {
        assertThat(racingGame)
                .extracting("roundCount")
                .isEqualTo(new RoundCount(5));
    }

    @Test
    void getWinnerCars_우승자_찾기_테스트() {
        //given
        racingGame.go();
        racingGame.go();

        //when
        int max = racingGame.getResult().stream()
                .mapToInt(CarDto::getPosition)
                .max()
                .orElse(-1);
        List<String> result = racingGame.getResult()
                .stream()
                .filter(carDTO -> carDTO.getPosition() == max)
                .map(CarDto::getName)
                .collect(Collectors.toList());

        //then
        assertThat(result)
                .isEqualTo(racingGame.getWinnerCars());
    }
}