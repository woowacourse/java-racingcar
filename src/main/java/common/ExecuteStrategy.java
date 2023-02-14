package common;

public interface ExecuteStrategy<T> {


    T executeOption() throws IllegalArgumentException;
}
