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
        carsService = new RacingCarsService();
    }

    @Test
    void initiateCars_테스트() {
        carsService.initiateCars("juri,hunch");

    }

    @Test
    void 게임_작동_테스트() {
        //given
        carsService.initiateCars("juri,hunch");
        carsService.initiateCount(5);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        carsService.playGame();
        String result = out.toString();

        //then
        assertThat(result)
                .contains("juri : -", "hunch : -");
    }

    @Test
    void 우승자_찾기_테스트() {
        //given
        int expectMaxPosition = 4;
        RacingCars cars = new RacingCars(new ArrayList<>(Arrays.asList("juri", "hunch")));
        Car winCar = new Car("pobi");
        cars.addCar(winCar);
        ArrayList<Car> result = new ArrayList<>(List.of(winCar));

        //when
        for (int i = 0; i < expectMaxPosition; i++) {
            winCar.move();
        }

        //then
        assertThat(result)
                .isEqualTo(cars.getSamePositionCars(expectMaxPosition));
    }
}