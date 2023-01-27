package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setOutPrintStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void outPutStreamReset() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 레이싱_테스트() {
        // given
        RangedRandomNumberPicker moveNumberPicker = new RangedRandomNumberPicker(4, 9);
        RangedRandomNumberPicker stayNumberPicker = new RangedRandomNumberPicker(0, 3);

        List<Car> cars = new ArrayList<>();
        cars.add(new RandomMovingCar("jinho1", moveNumberPicker));
        cars.add(new RandomMovingCar("jinho2", stayNumberPicker));

        Racing racing = new Racing(cars, 3);

        print_레이싱_테스트_ExpectedOutput();
        String expectedOutputString = output.toString();
        output.reset();

        // when
        racing.race();
        String actualOutputString = output.toString();

        // then
        assertThat(actualOutputString).isEqualTo(expectedOutputString);
    }

    void print_레이싱_테스트_ExpectedOutput() {

        System.out.println("실행 결과");
        System.out.println("jinho1 : -");
        System.out.println("jinho2 : ");
        System.out.println();

        System.out.println("jinho1 : --");
        System.out.println("jinho2 : ");
        System.out.println();

        System.out.println("jinho1 : ---");
        System.out.println("jinho2 : ");
        System.out.println();

        System.out.println("최종 우승자 : jinho1");
    }
}
