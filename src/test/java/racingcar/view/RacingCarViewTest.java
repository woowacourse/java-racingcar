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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    private static final String INTEGER_TURN_MESSAGE = "[ERROR] 시도 횟수는 정수여야만 합니다.";
    private static final String NEGATIVE_TURN_MESSAGE = "[ERROR] 시도 횟수는 음수일 수 없습니다";
    private static final String MINUS_TURN_SAMPLE = "-1";
    private static final String STRING_SAMPLE = "String";
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
    @DisplayName("레이싱카 리스트 입력 테스트")
    void carListInput() {
        provideInput(SAMPLE_CAR_NAME);
        scanner = new Scanner(System.in);
        String inputCarName = RacingCarView.carListInput(scanner);
        assertEquals(INPUT_MESSAGE, getOutput());
        System.out.printf("%s", inputCarName);
        assertEquals(SAMPLE_CAR_NAME, inputCarName);
    }

    @Test
    @DisplayName("게임 횟수 입력 테스트")
    void turnNumberInput() {
        provideInput(SAMPLE_TURN);
        scanner = new Scanner(System.in);
        String inputTurn = RacingCarView.turnNumberInput(scanner);
        assertEquals(TURN_INPUT_MESSAGE, getOutput());
        assertEquals(SAMPLE_TURN, inputTurn);
    }

    @Test
    @DisplayName("자동차 위치 확인 테스트")
    void displayPosition() {
        Car sampleCar = new Car(SAMPLE_CAR_NAME);
        sampleCar.oneTurn(CRITERIA);
        RacingCarView.displayPosition(sampleCar);
        assertEquals(SAMPLE_CAR_MESSAGE, getOutput());
    }

    @Test
    @DisplayName("우승자 출력 테스트")
    void showWinner() {
        RacingCarView.showWinner(SAMPLE_WINNERS);
        assertEquals(CONNECTED_SAMPLE_WINNER + WIN_MESSAGE, getOutput());
    }

    @Test
    @DisplayName("정수 여부 확인 테스트")
    void checkInteger() {
        provideInput(STRING_SAMPLE);
        scanner = new Scanner(System.in);
        assertThatThrownBy(() -> {
            RacingCarView.turnNumberInput(scanner);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(INTEGER_TURN_MESSAGE);
    }

    @Test
    @DisplayName("음수 여부 확인 테스트")
    void checkNegative() {
        provideInput(MINUS_TURN_SAMPLE);
        scanner = new Scanner(System.in);
        assertThatThrownBy(() -> {
            RacingCarView.turnNumberInput(scanner);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(NEGATIVE_TURN_MESSAGE);
    }
}
