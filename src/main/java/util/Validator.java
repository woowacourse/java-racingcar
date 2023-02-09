package util;

public abstract class Validator {
    abstract void validate(String input) throws IllegalArgumentException;
}