package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Car;
import racingcar.service.RacingcarService;

class RacingcarServiceTest {

    @ParameterizedTest
    @DisplayName("우승자 확인하기")
    @CsvSource("car1,car2,car3")
    void findWinner(String car1, String car2, String car3) {
        RacingcarService racingcarService = new RacingcarService(Arrays.asList(car1, car2, car3));

        List<Car> winnersCars = racingcarService.findWinners();

        assertAll(
                () -> assertThat(winnersCars.get(0).getName()).isEqualTo(car1),
                () -> assertThat(winnersCars.get(1).getName()).isEqualTo(car2),
                () -> assertThat(winnersCars.get(2).getName()).isEqualTo(car3)
        );
    }

    @Test
    @DisplayName("경주 참여 인원 두명 미만인 경우 예외")
    void validateParticipants() {
        assertThatThrownBy(() -> new RacingcarService(Arrays.asList("car1")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 경주는 최소 2명이 필요해요.");
    }
}
