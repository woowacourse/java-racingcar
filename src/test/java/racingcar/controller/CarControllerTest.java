package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import racingcar.domain.Car;
import racingcar.domain.Cars;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarControllerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    List<Car> cars = new ArrayList<>();

    @BeforeAll
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        Car carOne = new Car("one", 1);
        Car carTwo = new Car("two", 2);
        Car carThree = new Car("three", 3);
        cars.add(carOne);
        cars.add(carTwo);
        cars.add(carThree);
    }

    @AfterAll
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void 자동차_경주_출력_검증() {
        CarController.printRace(new Cars(cars));
        assertThat(outContent.toString()).contains("one : -");
        assertThat(outContent.toString()).contains("two : --");
        assertThat(outContent.toString()).contains("three : ---");
    }


    @Test
    void 우승자_검증() {
        CarController.findFinalWinner(new Cars(cars));
        assertThat(outContent.toString()).contains("three가 최종 우승했습니다.");
    }
}
