package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingCarController;

import java.io.*;
import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

public class ApplicationTest {

    private static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    private static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("전체 테스트")
    void applicationTest() {
        String carNames = "제이,이오,성하\n";
        String tryNum = "3\n";

        System.setIn(new SequenceInputStream(generateUserInput(carNames), generateUserInput(tryNum)));
        System.setOut(new PrintStream(outputStream));

        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(newArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8));
        RacingCarController racingCarController = new RacingCarController(testNumberGenerator);
        racingCarController.run();

        Assertions.assertThat(outputStream.toString()).contains("이오, 성하가 최종 우승했습니다.");
        System.setOut(System.out);
    }

    static class TestNumberGenerator implements CarNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
