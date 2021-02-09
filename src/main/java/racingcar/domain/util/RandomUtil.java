package racingcar.domain.util;

public interface RandomUtil<T> {
    T generate(int bound);
}