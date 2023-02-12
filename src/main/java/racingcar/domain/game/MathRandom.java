package racingcar.domain.game;

public class MathRandom implements Random {

    @Override
    public double greaterOrEqualZeroAndLessThenOne() {
        return Math.random();
    }
}
