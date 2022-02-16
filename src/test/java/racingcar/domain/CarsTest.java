package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class CarsTest {

    public static final int MOVE_CONDITION = 10;
    public static final int WINNER_INDEX = 0;

    @Test
    @DisplayName("우승자가 한 명일 경우에 대해서 테스트")
    public void 우승자_테스트() {
        //given
        Cars cars = new Cars("dwoo,woo,te,ch");
        int size = cars.getSize();
        int winnerPosition = 0;

        //when
        for (int i = 0; i < size; i++) {
            Car car = cars.getCar(i);

            car.progress(MOVE_CONDITION);
        }
        winnerPosition++;

        cars.getCar(WINNER_INDEX).progress(MOVE_CONDITION);
        winnerPosition++;

        //then
        List<String> winner = cars.getWinner(winnerPosition);

        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner.get(0)).isEqualTo("dwoo");
        assertThat(winnerPosition).isEqualTo(cars.getCar(WINNER_INDEX).getPosition());
    }

    @Test
    @DisplayName("우승자가 여러명일 경우에 대해서 테스트")
    public void 복수_우승자_테스트() {
        //given
        Cars cars = new Cars("dwoo,woo,te,ch");
        int size = cars.getSize();
        int winnerPosition = 0;

        //when
        for (int i = 0; i < size; i++) {
            Car car = cars.getCar(i);

            car.progress(MOVE_CONDITION);
        }
        winnerPosition++;

        //then
        List<String> winner = cars.getWinner(winnerPosition);

        assertThat(winner.size()).isEqualTo(4);
        assertThat(winnerPosition).isEqualTo(cars.getCar(WINNER_INDEX).getPosition());
    }
}