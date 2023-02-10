package racing.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.NumberGenerator;
import racing.domain.Car;
import racing.dto.GameResultDto;

class RacingGameServiceTest {

    MockNumberGenerator numberGenerator = new MockNumberGenerator();
    Car boxster = new Car("박스터");
    Car sonata = new Car("소나타");
    Car benz = new Car("벤츠");

    List<Car> dummy = List.of(
            boxster,
            sonata,
            benz
    );


    @Test
    @DisplayName("레이싱 게임을 한 라운드 진행한다")
    void moveTest() {
        numberGenerator.setNumber(4);
        RacingGameService gameService = new RacingGameService(numberGenerator, 3, dummy);

        GameResultDto result = gameService.play();

        Set<String> names = result.getNames();

        List<Integer> positions = names.stream()
                .map(result::getPosition)
                .collect(Collectors.toList());

        assertAll(() -> {
            assertThat(names).contains("박스터", "소나타", "벤츠");
            assertThat(positions).containsOnly(1);
        });
    }

    @DisplayName("isEnd 메소드는 게임 종료 여부를 반환한다")
    @ParameterizedTest(name = "시도 횟수가 {0}일 때 {1}번 시도하면 {2}")
    @CsvSource(value = {"3:1:false", "3:3:true"}, delimiter = ':')
    void isEndTest(int count, int tryCount, boolean result) {
        RacingGameService gameService = new RacingGameService(numberGenerator, count, dummy);

        for (int i = 0; i < tryCount; i++) {
            gameService.play();
        }

        assertThat(gameService.isEnd()).isEqualTo(result);
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