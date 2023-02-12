package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {
    @Test
    @DisplayName("중복된 자동차 이름이 있으면 예외가 발생한다.")
    void validateDuplicateCarNameTest() {
        List<String> duplicateCarNames = new ArrayList<>(List.of("leo", "leo"));

        assertThrows(IllegalArgumentException.class,
                () -> new Cars(duplicateCarNames));
    }

    @Test
    @DisplayName("중복된 자동차 이름이 없으면 예외가 발생하지 않는다.")
    void validateNonDuplicateCarNameTest() {
        List<String> nonDuplicateCarNames = new ArrayList<>(List.of("leo", "mint"));

        assertThatCode(() -> new Cars(nonDuplicateCarNames))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("제일 멀리 움직인 자동차가 우승자인지 확인한다.")
    void findWinnersTest() {
        Cars cars = new Cars(List.of("leo", "mint", "yh"));
        cars.progressRound(List.of(1,5,3), new RoundResult());
        List<String> winners = cars.findWinners();

        assertThat(winners).contains("mint");
    }

    @Test
    @DisplayName("제일 멀리 움직인 자동차가 여러 대면 공동 우승자인지 확인한다.")
    void findMultipleWinnersTest() {
        Cars cars = new Cars(List.of("leo", "mint", "yh"));
        cars.progressRound(List.of(4,5,3), new RoundResult());
        List<String> winners = cars.findWinners();

        assertThat(winners).contains("mint","leo");
    }
}
