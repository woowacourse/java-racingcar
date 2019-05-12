package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @Test
    void create() {
        List<String> names = new ArrayList<>();

        names.add("pobi");
        names.add("crong");

        assertThat(new GameResult(names, 2)).isEqualTo(new GameResult(names, 2));
    }
}
