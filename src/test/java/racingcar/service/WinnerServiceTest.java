package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerServiceTest {
    private WinnerService winnerService;

    @BeforeEach
    public void setUp() {
        winnerService = new WinnerService();
    }

    @DisplayName("최종 우승자 판단 성공")
    @Test
    void getWinnerNames_최종_우승자를_판단() {
        final String winnerName = "dani";

        List<String> carNames = Arrays.asList("dani", "brown", "pobi");
        List<Integer> positions = Arrays.asList(8, 3, 6);
        Cars cars = new Cars(carNames, positions);

        List<String> winnerNames = winnerService.getWinnerNames(cars);

        assertThat(winnerNames.get(0)).isEqualTo(winnerName);
    }
}