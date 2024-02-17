package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Test
    @DisplayName("주어진 횟수만큼 진행")
    void proceed() {
        int tryCount = 10;
        Race race = new Race(new Cars("pobi,crong,honux"), new TryCount(tryCount));
        List<Cars> result = race.proceed();
        assertThat(result).hasSize(tryCount);
    }
}
