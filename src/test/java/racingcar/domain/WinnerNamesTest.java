package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.util.BoundedRandomNumberGenerator;

@SuppressWarnings("NonAsciiCharacters")
class WinnerNamesTest {
    @Test
    public void 최종_우승자_찾기_테스트() {
        Cars cars = new Cars(Arrays.asList("이브", "클레이"));
        cars.executeCarRacing(new BoundedRandomNumberGenerator(9, 4));
        List<String> winners = new WinnerNames().findWinners(cars.getCars());

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).contains("이브", "클레이");
    }
}