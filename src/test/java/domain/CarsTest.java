package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("judgeWinners 메서드는 우승한 자동차들을 반환한다.")
    @Test
    void should_ReturnWinners_When_UsingJudgeWinnersMethod() {
        //given
        Car notWinnerCarA = new Car("carA");
        Car winnerCarB = new Car("carB");
        Car winnerCarC = new Car("carC");
        Cars cars = new Cars(List.of(notWinnerCarA, winnerCarB, winnerCarC));

        //when
        notWinnerCarA.move(9);

        winnerCarB.move(9);
        winnerCarB.move(9);

        winnerCarC.move(9);
        winnerCarC.move(9);

        Cars winners = cars.judgeWinners();

        //then
        assertThat(winners.getCars()).containsExactly(winnerCarB, winnerCarC);
    }
}
