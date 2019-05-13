package racingcar.model;


import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingGameTest {

    @Test
    void 자동차_이름_중복_확인() {
        assertThrows(IllegalArgumentException.class, () -> new RacingGame("a,a".split(","), 3));
    }

    @Test
    void Set의_순서가_같을_때_True가_나와야_한다() {
        RacingGame racingGame = new RacingGame("a,b,c".split(","), 3);
        Set<Car> testCar = new LinkedHashSet<>(Arrays.asList(new Car("a")
                , new Car("b"), new Car("c")));
        assertThat(racingGame.isEqualCars(testCar)).isTrue();
    }

    @Test
    void Set의_순서가_다를_때_False가_나와야_한다() {
        RacingGame racingGame = new RacingGame("a,b,c".split(","), 3);
        Set<Car> testCar = new LinkedHashSet<>(Arrays.asList(new Car("c")
                , new Car("b"), new Car("a")));
        assertThat(racingGame.isEqualCars(testCar)).isFalse();
    }

    @Test
    void numberOfTry가_1이면_True를_리턴한다() {
        RacingGame racingGame = new RacingGame("a,b,c".split(","), 1);
        assertThat(racingGame.checkNumberOfTry()).isTrue();
    }

    @Test
    void numberOfTry가_0이면_False를_리턴한다() {
        RacingGame racingGame = new RacingGame("a,b,c".split(","), 0);
        assertThat(racingGame.checkNumberOfTry()).isFalse();
    }
}
