package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnersTest {
    @Test
    @DisplayName("우승자 생성 확인")
    void winners_make() {
        assertThat(Winners.makeWinners(Arrays.asList(new Car("1"), new Car("2"), new Car("3"))).size()).isEqualTo(3);
    }
}
