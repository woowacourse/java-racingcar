package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.CarTest.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.vo.MovingNumber;
import racingcar.domain.vo.Name;

class WinnerTest {

    @Test
    @DisplayName("자동차 경주의 우승자를 구한다")
    void findWinners() {
        // given
        Cars cars = new Cars(givenCarsNames("hoho", "rich", "pobi"));
        cars.move(givenNumbers(ADVANCE, ADVANCE, STOP));

        // when
        Winner winner = new Winner(cars.getCars());
        List<Name> winners = winner.findWinners();

        // then
        assertThat(winners).containsExactly(new Name("hoho"), new Name("rich"));
    }

    @Test
    @DisplayName("자동차가 없으면 우승자를 생성할 때 예외를 발생한다")
    void throwExceptionWhenNewWinnerByEmptyCar() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Winner(Collections.emptyList()))
            .withMessageContaining("자동차 한대 이상이 필요합니다.");
    }

    private List<Name> givenCarsNames(String... names) {
        return Arrays.stream(names)
            .map(Name::new)
            .collect(Collectors.toList());
    }

    private Queue<MovingNumber> givenNumbers(int... numbers) {
        return Arrays.stream(numbers)
            .mapToObj(MovingNumber::new)
            .collect(Collectors.toCollection(LinkedList::new));
    }
}