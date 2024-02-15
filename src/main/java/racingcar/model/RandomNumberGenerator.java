package racingcar.model;

public class RandomNumberGenerator implements NumberGenerator{
    @Override
    public int generateNumber(int bound){
        return (int) (Math.random()*bound);
    }
}
