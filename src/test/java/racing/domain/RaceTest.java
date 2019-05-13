package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    Race race;

    @Test
    void 게임진행(){
        List<String> carNames = Arrays.asList(new String []{"a","b","c","d"});
        Race race = new Race(carNames);
    }
}
