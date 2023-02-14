package common;

import domain.validation.InputValidationChain;

public interface InputStrategy<T> {

    T executeInput(InputValidationChain validator) throws IllegalArgumentException;
}
