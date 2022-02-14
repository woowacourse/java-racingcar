package racingCar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.controller.service.RacingCarsService;
import racingCar.model.Car;
import racingCar.model.RacingCars;

class RacingCarsServiceTest {

    @DisplayName("게임_작동_테스트")
    @Test
    public void t1() {
        //given
        RacingCarsService racingCarsService = new RacingCarsService();
        racingCarsService.initiateCars("juri,hunch");
        racingCarsService.initiateCount(5);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        racingCarsService.playGame();
        String result = out.toString();

        //then
        assertThat(result)
                .contains("juri : -", "hunch : -");
    }

    @DisplayName("우승자_찾기_테스트")
    @Test
    public void t2() {
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