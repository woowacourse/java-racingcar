package view;

import domain.Car;
import dto.Result;
import org.junit.jupiter.api.*;
import vo.CarName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private final OutputView outputView = new OutputView();
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Nested
    @DisplayName("에러 메시지를 출력하는 printErrorMessage() 테스트")
    class PrintErrorMessageTest {
        @Test
        @DisplayName("메시지가 주어지면, 앞에 [ERROR]를 단 메시지가 출력된다.")
        void givenErrorMessage_whenPrinting_thenPrintsMessageWithErrorHead() {
            String errorMessage = "테스트 예외메시지입니다.";

            outputView.printErrorMessage(errorMessage);

            assertThat(getPrintedMessage())
                    .startsWith(OutputView.ERROR)
                    .contains(errorMessage);
        }
    }

    @Nested
    @DisplayName("이동 결과와 관련한 메시지를 출력하는 메소드들 테스트")
    class PrintingResultTest {
        @Test
        @DisplayName("실행 결과 출력을 시작하는 메시지를 출력한다,")
        void printsResult() {
            outputView.printResultMessage();

            assertThat(getPrintedMessage())
                    .contains(OutputView.MOVING_RESULT_MESSAGE);
        }

        @Test
        @DisplayName("Result가 넘어오면 적절한 결과 메시지를 만들어 출력한다.")
        void givenResult_whenPrintingResultMessage_thenPrintsMessage() {
            Car car1 = makeCar("Car1", 4);
            Car car2 = makeCar("Car2", 2);
            Result result = Result.of(List.of(car1, car2));

            outputView.printResult(result);

            String printedMessage = getPrintedMessage();
            assertThat(printedMessage)
                    .contains("Car1 : ----")
                    .contains("Car2 : --");
        }

        private Car makeCar(String carName, int moveCount) {
            Car car = Car.of(CarName.of(carName));
            for (int i = 0; i < moveCount; i++) {
                car.move(4);
            }
            return car;
        }
    }

    @Nested
    @DisplayName("최종 우승자를 출력하는 printWinners() 메소드 테스트")
    class PrintWinnersTest {
        @Test
        @DisplayName("우승자 이름이 주어지면 포맷에 맞게 메시지가 출력된다.")
        void givenWinnerName_whenPrintingWinners_thenPrintsWinner() {
            List<String> winners = List.of("Car1");

            outputView.printWinners(winners);

            assertThat(getPrintedMessage())
                    .contains("Car1가 최종 우승했습니다.");
        }

        @Test
        @DisplayName("여러 우승자 이름이 주어지면 포맷에 맞게 메시지가 출력된다.")
        void givenMultipleWinnerNames_whenPrintingWinners_thenPrintsWinners() {
            List<String> winners = List.of("Car1, Car2");

            outputView.printWinners(winners);

            assertThat(getPrintedMessage())
                    .contains("Car1, Car2가 최종 우승했습니다.");
        }
    }

    private String getPrintedMessage() {
        return outputStreamCaptor.toString();
    }
}