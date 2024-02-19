package utils;

import utils.NumberGenerator;

public class Random implements NumberGenerator {
    @Override
    public int generate() {
        return (int) (Math.random() * 9);
    }
}
