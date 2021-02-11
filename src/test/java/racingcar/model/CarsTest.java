package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarsTest {
    @Test
    public void Cars_생성자_자동차_이름이_5자_초과일_경우() {
        String[] carNames = {"veryLong", "evenLonger", "superLong"};
        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void Cars_생성자_거리_배열에_음수가_포함된_경우() {
        String[] carNames = {"test1", "test2", "test3", "test4", "test5"};
        int[] carDistances = {0, -1, -2, -3, -4};
        assertThatThrownBy(() -> new Cars(carNames, carDistances))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void Cars_생성자_자동차_이름_배열의_갯수와_거리_배열의_갯수가_다를_경우() {
        String[] carNames = {"test1", "test2", "test3", "test4", "test5"};
        int[] carDistances = {0, 1, 2, 3};
        assertThatThrownBy(() -> new Cars(carNames, carDistances))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void Cars_getWinner_단일_우승자_테스트() {
        String[] carNames = {"test1", "test2", "test3", "test4", "test5"};
        int[] carDistances = {1, 2, 3, 4, 5};
        Cars carsInGame = new Cars(carNames, carDistances);
        List<String> result = new ArrayList<>();
        result.add("test5");
        assertThat(carsInGame.getWinner().equals(result)).isTrue();
    }

    @Test
    public void Cars_getWinner_다중_우승자_테스트() {
        String[] carNames = {"test1", "test2", "test3", "test4", "test5"};
        int[] carDistances = {1, 3, 3, 3, 2};
        Cars carsInGame = new Cars(carNames, carDistances);
        List<String> result = new ArrayList<>();
        result.add("test2");
        result.add("test3");
        result.add("test4");
        assertThat(carsInGame.getWinner().equals(result)).isTrue();
    }

    @Test
    public void Cars_getWinner_우승자_조작_시도_테스트() {
        String[] carNames = {"test1", "test2", "test3", "test4", "test5"};
        int[] carDistances = {1, 2, 3, 4, 5};
        Cars carsInGame = new Cars(carNames, carDistances);
        assertThatThrownBy(() -> carsInGame.getWinner().add("attack"))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}