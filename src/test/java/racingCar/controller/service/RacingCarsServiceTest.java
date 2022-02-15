package racingCar.controller.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingCar.model.Car;
import racingCar.model.RacingCars;

@SuppressWarnings("NonAsciiCharacters")
public class RacingCarsServiceTest {
    RacingCarsService carsService;

    @BeforeEach
    void setup() {
        carsService = new RacingCarsService("juri,hunch","5");
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
        int expectMaxPosition = 4;
        Car winCar = carsService.cars.get().get(0);
        ArrayList<Car> result = new ArrayList<>(List.of(winCar));

        //when
        for (int i = 0; i < expectMaxPosition; i++) {
            winCar.move();
        }

        //then
        assertThat(result)
                .isEqualTo(carsService.getWinnerCars());
    }
}