package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarViewTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
    private static final String TURN_INPUT_MESSAGE = "시도할 회수는 몇회인가요?\n";
    private static final String SAMPLE_CAR_NAME = "sample";
    private static final int CRITERIA = 4;
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void carListInput() {
        RacingCarView.carListInput();
        assertEquals(INPUT_MESSAGE, outputStreamCaptor.toString());
    }

    @Test
    void turnNumberInput() {
        RacingCarView.turnNumberInput();
        assertEquals(TURN_INPUT_MESSAGE, outputStreamCaptor.toString());
    }

    @Test
    void displayPosition() {
        Car sampleCar = new Car(SAMPLE_CAR_NAME);
        sampleCar.oneTurn(CRITERIA);
        RacingCarView.displayPosition(sampleCar);
        assertEquals("sample : -", outputStreamCaptor.toString());
    }
}
