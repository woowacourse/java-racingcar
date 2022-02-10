package racingcarTest;

import addCalculatorTest.StringCalculator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingcarTest {

    @Test
    void 플레이어_이름_입력() {
        // Carcontroller가 input을 이용해서 "pobi,zero,summer"
        List<String> playerNames = CarController.convertInputToNames("pobi,zero,summer");
        String[] names = {"pobi", "zero", "summer"};
        List<String> expect = Arrays.asList(names);

        for (int i = 0; i < playerNames.size(); i++) {
            assertThat(playerNames.get(i)).isEqualTo(names[i]);
        }
    }

    @Test
    void 게임_회수_입력() {
        int rounds = CarController.convertInputToRound("5");
        int expect = 5;
        assertThat(rounds).isEqualTo(expect);
    }

    @Test
    void 정수_입력_실패()  {
        assertThatThrownBy(() -> CarController.convertInputToRound("A")
                .isInstanceOf(RuntimeException.class));
    }
}
