package utils;

import java.util.function.Supplier;

public class RandomNumberGenerator implements Supplier<Integer> {
    @Override
    public Integer get() {
        return (int) (Math.random()*10);
    }
}
