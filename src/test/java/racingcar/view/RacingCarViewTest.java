package racingcar.view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarViewTest {

    private static final List<String> SAMPLE_WINNERS = Arrays.asList("pobi", "bada", "whyb");
    private static final String CONNECTED_SAMPLE_WINNER = "pobi, bada, whyb";
    private static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
    private static final String TURN_INPUT_MESSAGE = "시도할 회수는 몇회인가요?\n";
    private static final String SAMPLE_CAR_NAME = "sample";
    private static final String SAMPLE_CAR_MESSAGE = "sample : -\n";
    private static final String SAMPLE_TURN = "5";
    private static final String WIN_MESSAGE = "가 최종 우승했습니다.\n";
    private static final int CRITERIA = 4;

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    private Scanner scanner;

    @BeforeEach
    public void setUp() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String inputStringData) {
        testIn = new ByteArrayInputStream(inputStringData.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    void carListInput() {
        provideInput(SAMPLE_CAR_NAME);
        scanner = new Scanner(System.in);
        String inputCarName = RacingCarView.carListInput(scanner);
        assertEquals(INPUT_MESSAGE, getOutput());
        System.out.printf("%s", inputCarName);
        assertEquals(SAMPLE_CAR_NAME, inputCarName);
    }

    @Test
    void turnNumberInput() {
        provideInput(SAMPLE_TURN);
        scanner = new Scanner(System.in);
        String inputTurn = RacingCarView.turnNumberInput(scanner);
        assertEquals(TURN_INPUT_MESSAGE, getOutput());
        assertEquals(SAMPLE_TURN, inputTurn);
    }

    @Test
    void displayPosition() {
        Car sampleCar = new Car(SAMPLE_CAR_NAME);
        sampleCar.oneTurn(CRITERIA);
        RacingCarView.displayPosition(sampleCar);
        assertEquals(SAMPLE_CAR_MESSAGE, getOutput());
    }

    @Test
    void showWinner() {
        RacingCarView.showWinner(SAMPLE_WINNERS);
        assertEquals(CONNECTED_SAMPLE_WINNER + WIN_MESSAGE, getOutput());
    }
}
