package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultControllerTest {
    ResultController resultController;

    @BeforeEach
    void setUp() {
        resultController = new ResultController();
    }

    @Test
    void 올바른_우승자_선정() {
        List<Car> carList = Arrays.asList(
                                    new Car("pobi",1),
                                    new Car("win", 5),
                                    new Car("brown",3),
                                    new Car("cu", 5));
        ArrayList<Car> carArrayList = new ArrayList<Car>(carList);
        ArrayList<Car> resultCarArrayList =resultController.findWinners(carArrayList);
        String[] winnerName = {"win", "cu"};

        assertThat(resultCarArrayList.size()).isEqualTo(winnerName.length);
        for (int i = 0; i< winnerName.length; i++) {
            assertThat(resultCarArrayList.get(i).getName()).isEqualTo(winnerName[i]);
        }
    }
}
