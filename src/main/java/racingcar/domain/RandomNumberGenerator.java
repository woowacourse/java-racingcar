package racingcar.domain;

public class RandomNumberGenerator implements NumberGenerator{
    @Override
    public int generateNumber(int bound){
        return (int) (Math.random()*bound);
    }
}
