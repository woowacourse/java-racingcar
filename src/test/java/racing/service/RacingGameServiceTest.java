package racing.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.NumberGenerator;
import racing.domain.Car;
import racing.dto.GameResultDto;

class RacingGameServiceTest {

    MockNumberGenerator numberGenerator = new MockNumberGenerator();
    Car boxster = new Car("박스터");
    Car sonata = new Car("소나타");

    List<Car> dummy = List.of(
            boxster,
            sonata,
            new Car("벤츠")
    );

    @Test
    @DisplayName("레이싱 게임을 한 라운드 진행한다")
    void moveTest() {
        numberGenerator.setNumber(4);
        RacingGameService gameService = new RacingGameService(numberGenerator, 3, dummy);

        GameResultDto result = gameService.play();

        Set<String> names = result.getNames();

        assertAll(() -> {
            assertThat(names).contains("박스터", "소나타", "벤츠");

            assertThat(names.stream()
                    .map(result::getPosition)
                    .collect(Collectors.toList()))
                    .containsOnly(1);
        });


    }


    static class MockNumberGenerator implements NumberGenerator {
        private int number;

        @Override
        public int generate() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }

}