package racingcarTest;

import org.junit.jupiter.api.*;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.Output;
import racingcarTest.domain.AlwaysMoveStrategy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OutputTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private void makeCarMoveCountTimes(Car car, int count) {
        AlwaysMoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();
        for (int i = 0; i < count; i++) {
            car.goForward(alwaysMoveStrategy.generateNumber());
        }
    }

    @BeforeAll
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @DisplayName("자동차_개별_상태_출력")
    @Test
    void printRightCarStatus() {
        List<Car> carList = new ArrayList<>();

        // name: dog, position: 5
        Car carDog = new Car("dog");
        makeCarMoveCountTimes(carDog, 5);
        // name:cat, position: 3
        Car carCat = new Car("cat");
        makeCarMoveCountTimes(carCat, 3);

        carList.add(carDog);
        carList.add(carCat);

        Cars cars = new Cars(carList);
        Output.printCarsStatus(cars.getCars());
        assertThat(outContent.toString()).contains("dog : -----");
        assertThat(outContent.toString()).contains("cat : ---");
    }

}
