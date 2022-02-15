package racingCar.controller.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingCar.model.CarDTO;

@SuppressWarnings("NonAsciiCharacters")
public class RacingCarsServiceTest {
    RacingCarsService carsService;

    @BeforeEach
    void setup() {
        carsService = new RacingCarsService("juri,hunch", "5");
    }

    @Test
    void 게임_작동_테스트() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        carsService.playGame();
        String result = out.toString();

        //then
        assertThat(Arrays.stream(result.split(" ")).filter(s -> s.contains("juri")).count() == 5 &&
                Arrays.stream(result.split(" ")).filter(s -> s.contains("hunch")).count() == 5)
                .isTrue();
    }

    @Test
    void 우승자_찾기_테스트() {
        //given
        List<CarDTO> carDTOs = carsService.cars.get();

        //when
        carsService.playGame();
        int max = carDTOs.stream()
                .mapToInt(carDTO -> carDTO.position)
                .max()
                .orElse(0);
        List<CarDTO> result = carDTOs.stream()
                .filter(carDTO -> carDTO.position == max)
                .collect(Collectors.toList());

        //then
        assertThat(result)
                .isEqualTo(carsService.getWinnerCars());
    }
}