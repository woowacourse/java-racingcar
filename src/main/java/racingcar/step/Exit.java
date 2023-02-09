package racingcar.step;

public class Exit implements Step {

    @Override
    public boolean executable() {
        return false;
    }

    @Override
    public Step execute() {
        return null;
    }
}
