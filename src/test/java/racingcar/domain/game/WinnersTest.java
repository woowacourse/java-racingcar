package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Winners 는")
class WinnersTest {

    private static final int ON_GOING_NUMBER = 5;
    private static final int STOP_NUMBER = 1;

    @Test
    void 생성_시_자동차들_중_가장_멀리_간_자동차를_우승자로_가진다() {
        // given
        Cars cars = new Cars(List.of("말랑", "채채", "카일", "시카"));
        cars.move(new NumberGenerator() {
            private final List<Integer> numbers = List.of(ON_GOING_NUMBER, ON_GOING_NUMBER, ON_GOING_NUMBER, STOP_NUMBER);
            private int index = 0;

            @Override
            public int generate(final int minNumber, final int maxNumber) {
                return numbers.get(index++);
            }
        });

        // when
        Winners winners = new Winners(cars.cars());

        // then
        assertThat(winners.winners().stream().map(it -> it.name().value()).collect(Collectors.toList()))
                .containsExactlyInAnyOrderElementsOf(List.of("말랑", "채채", "카일"));
    }
}
