package racingcar.domain;

@FunctionalInterface
public interface PrintRequestListener<T> {

    void print(T target);
}
