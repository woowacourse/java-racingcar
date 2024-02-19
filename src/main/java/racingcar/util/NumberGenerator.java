package racingcar.util;

@FunctionalInterface
public interface NumberGenerator<T> {
    T generate(T arg1, T arg2);
}
