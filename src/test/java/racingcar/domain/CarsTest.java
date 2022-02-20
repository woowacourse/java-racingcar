package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class CarsTest {

    private Cars cars;
    private int size;
    private int winnerPosition;

    @BeforeEach
    void setUpCars() {
        String[] carNames = {"dwoo","woo","te","ch"};
        cars = new Cars(carNames);
        size = cars.getSize();
        winnerPosition = 0;
    }

    @Test
    @DisplayName("우승자가 한 명일 경우에 대해서 테스트")
    public void 우승자_테스트() {
        //when
        winnerPosition = progressWithAllCars(size, cars, winnerPosition);

        cars.getCar(0).progress(() -> true);
        winnerPosition++;

        //then
        List<String> winner = cars.getWinner(winnerPosition);

        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner.get(0)).isEqualTo("dwoo");
        assertThat(winnerPosition).isEqualTo(cars.getCar(0).getPosition());
    }

    @Test
    @DisplayName("우승자가 여러명일 경우에 대해서 테스트")
    public void 복수_우승자_테스트() {
        //when
        winnerPosition = progressWithAllCars(size, cars, winnerPosition);

        //then
        List<String> winner = cars.getWinner(winnerPosition);

        assertThat(winner.size()).isEqualTo(4);
        assertThat(winnerPosition).isEqualTo(cars.getCar(0).getPosition());
    }

    private int progressWithAllCars(int size, Cars cars, int winnerPosition) {
        for (int i = 0; i < size; i++) {
            Car car = cars.getCar(i);

            car.progress(() -> true);
        }
        winnerPosition++;
        return winnerPosition;
    }
}