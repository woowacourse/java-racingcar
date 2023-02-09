package racingcar.step;

public interface Step {
    boolean executable();

    Step execute();
}
