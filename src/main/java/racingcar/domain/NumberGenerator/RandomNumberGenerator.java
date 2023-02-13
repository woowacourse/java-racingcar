package racingcar.domain.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int getNumber() {
        return (int) (Math.random() * 10);
    }
}
