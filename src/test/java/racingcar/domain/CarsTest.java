package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.CarTest.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.vo.MovingNumber;
import racingcar.domain.vo.Name;

public class CarsTest {

    @Test
    @DisplayName("자동차의 이름으로 자동차 리스트를 생성한다")
    void newCarsByNames() {
        // given
        List<Name> names = givenCarsNames("hoho", "rich", "pobi");

        // when & then
        assertThatCode(() -> new Cars(names)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("가장 많이 전진한 자동차가 우승한다")
    void existsWinner() {
        // given
        Cars cars = new Cars(givenCarsNames("hoho", "rich", "pobi"));
        Queue<MovingNumber> movingNumbers = givenNumbers(ADVANCE, STOP, STOP);

        // when
        cars.move(movingNumbers);

        // then
        Winners winners = cars.findWinners();
        assertThat(winners.getWinners()).containsExactly(new Name("hoho"));
    }

    @Test
    @DisplayName("가장 많이 전진한 자동차가 2대일경우 2명이 공동 우승자이다")
    void existsWinners() {
        // given
        Cars cars = new Cars(givenCarsNames("hoho", "rich", "pobi"));
        Queue<MovingNumber> movingNumbers = givenNumbers(ADVANCE, ADVANCE, STOP);

        // when
        cars.move(movingNumbers);

        // then
        Winners winners = cars.findWinners();
        assertThat(winners.getWinners()).containsExactly(new Name("hoho"), new Name("rich"));
    }

    @Test
    @DisplayName("자동차의 갯수와 랜덤한 숫자들의 갯수가 일치하지 않을경우 예외를 발새한다")
    void throwExceptionWhenCarsSizeNotEqualsNumbersSize() {
        // given
        Cars cars = new Cars(givenCarsNames("hoho", "rich", "pobi"));
        Queue<MovingNumber> movingNumbers = givenNumbers(ADVANCE);

        // when & then
        assertThatIllegalArgumentException()
            .isThrownBy(() -> cars.move(movingNumbers))
            .withMessage("자동차와 랜덤한 숫자들의 갯수가 일치하지 않습니다.");
    }

    @Test
    @DisplayName("랜덤 숫자들을 음수로 생성한 경우 예외를 발생한다")
    void throwExceptionWhenNumbersNegative() {
        // given
        Cars cars = new Cars(givenCarsNames("hoho", "rich", "pobi"));

        // when && then
        assertThatIllegalArgumentException()
            .isThrownBy(() -> cars.move(givenNumbers(-1, -1, -1)))
            .withMessage("숫자는 0과 9사이어야 합니다.");
    }

    @Test
    @DisplayName("조회한 자동차는 기존 자동차의 상태 변경이 불가능하다")
    void getCarsImmutable() {
        // given
        Cars cars = new Cars(givenCarsNames("hoho", "rich", "pobi"));

        // when && then
        Car anyCar = cars.getCars().get(0);
        anyCar.advance(ADVANCE);

        List<Name> winners = cars.findWinners().getWinners();
        assertThat(winners.size()).isEqualTo(cars.size());
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
