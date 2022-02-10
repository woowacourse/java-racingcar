package racingcar;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {
    @Test
    @DisplayName("쉼표로 자동차 이름 분리 테스트")
    void separateNamesByComma() {
        // given
        String input = "pobi,hoho,rich";

        // when
        RacingGame racingGame = new RacingGame();
        // List<Name> names = racingGame.generate(input);

        // then
        // assertThat(names).containsExactly(Name.of("pobi"), Name.of("hoho"), Name.of("rich"));
    }

}
