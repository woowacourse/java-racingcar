package racingCar.controller.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingCar.domain.CarDTO;

@SuppressWarnings("NonAsciiCharacters")
public class RacingCarsServiceTest {
    private RacingCarsService carsService;

    @BeforeEach
    void setup() {
        carsService = new RacingCarsService("juri,hunch", "5");
    }

    @Test
    void 생성자_cars_값이_들어가는지_테스트() {
        //when
        List<String> names = new ArrayList<>();
        for (CarDTO carDTO : carsService.getCars().get()) {
            names.add(carDTO.name);
        }

        //then
        assertThat(names).isEqualTo(Arrays.asList("juri","hunch"));
    }

    @Test
    void 생성자_roundCount_값이_들어가는지_테스트() {
        assertThat(carsService.getRoundCount().get()).isEqualTo(5);
    }

    @Test
    void playGame_게임_작동_테스트() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        carsService.playGame();
        String result = out.toString();

        //then
        assertThat(
                Arrays.stream(result.split(" "))
                        .filter(s -> s.contains("juri"))
                        .count() == 5 &&
                Arrays.stream(result.split(" "))
                        .filter(s -> s.contains("hunch"))
                        .count() == 5)
                .isTrue();
    }

    @Test
    void getWinnerCars_우승자_찾기_테스트() {
        //given
        carsService.playGame();

        //when
        int max = carsService.getCars().getMaxPosition();
        List<CarDTO> result = carsService.getCars().get()
                .stream()
                .filter(carDTO -> carDTO.position == max)
                .collect(Collectors.toList());

        //then
        assertThat(result)
                .isEqualTo(carsService.getWinnerCars());
    }
}