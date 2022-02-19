package racingcar.domain;

public class MockCount extends Count{

    public MockCount(int count) {
        super(count);
    }

    @Override
    public boolean hasRemaining() {
        return false;
    }
}
