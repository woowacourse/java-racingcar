package racingcar.domain;

public class DefaultNumberGenerator implements NumberGenerator {
    private int num;

    public DefaultNumberGenerator(int num) {
        this.num = num;
    }
    
    @Override
    public int getNumber() {
        return num;
    }
}
