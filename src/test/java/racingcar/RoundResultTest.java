package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.GameResult;
import racingcar.model.RoundResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundResultTest {

    @Nested
    class Feature {
        @Test
        @DisplayName("제일 높은 값을 갖는 객체가 하나인 경우, 해당 객체를 제대로 리턴하는지 확인")
        void testGetWinner() {
            RoundResult roundResult = new RoundResult(
                    List.of("차1", "차2", "차3"),
                    List.of(3, 3, 4)
            );

            List<String> actual = roundResult.calculateWinners();
            List<String> expected = List.of("차3");

            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("제일 높은 값을 갖는 객체가 여러 개인 경우, 해당 객체들을 제대로 리턴하는지 확인")
        void testGetWinners() {
            RoundResult roundResult = new RoundResult(
                    List.of("차1", "차2", "차3"),
                    List.of(3, 4, 4)
            );

            List<String> actual = roundResult.calculateWinners();
            List<String> expected = List.of("차2", "차3");

            assertThat(actual).isEqualTo(expected);
        }
    }
}
