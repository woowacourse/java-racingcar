package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class RaceTest {
    Race race;

    @BeforeEach
    void setUp() {
        race = new Race();
    }




    @Test
    void 중복확인테스트() {
        List<String> names = Arrays.asList(new String[]{"a", "b", "b"});
        assertThrows(IllegalArgumentException.class, () -> {
            race.checkDuplicated(names);
        });
        names.set(2, "c");
        assertThat(race.checkDuplicated(names)).isEqualTo(true);
    }

    @Test
    void 자연수확인테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            race.checkValidNumTrials(-30);
        });
        assertThat(race.checkValidNumTrials(23)).isEqualTo(true);
    }
}
