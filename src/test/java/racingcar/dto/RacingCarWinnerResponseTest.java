package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class RacingCarWinnerResponseTest {

    @Test
    @DisplayName("우승자가 다수일 때 asString 호출 시 명세한 문자열이 반환되어야 한다.")
    void asString_success() {
        // given
        List<Car> winners = List.of(new Car("Glen"), new Car("Bero"));
        RacingCarWinnerResponse response = RacingCarWinnerResponse.of(winners);

        // expected
        assertThat(response.asString())
                .isEqualTo("Glen, Bero");
    }

    @Test
    @DisplayName("우승자가 혼자일 때 asString 호출 시 명세한 문자열이 반환되어야 한다.")
    void asString_successWhenOneWinner() {
        // given
        List<Car> winners = List.of(new Car("Glen"));
        RacingCarWinnerResponse response = RacingCarWinnerResponse.of(winners);

        // expected
        assertThat(response.asString())
                .isEqualTo("Glen");
    }
}
