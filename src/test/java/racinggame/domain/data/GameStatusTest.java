package racinggame.domain.data;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

public class GameStatusTest {
    GameStatus gamestatus;

    @ParameterizedTest
    @CsvSource(value = {"pobi,3,pobi : ---", "crong,4,crong : ----", "honux,0,honux : "})
    void 로그_테스트(String name, int position, String log) {
        List<String> names = new ArrayList<>();
        names.add(name);
        gamestatus = new GameStatus(names);
        if (position == 0) {
            log += " ";
        }
        Assertions.assertThat(gamestatus.makeStatusLog(name, position)).isEqualTo(log);
    }
}
