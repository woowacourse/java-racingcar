package common;

import domain.validation.InputValidationChain;

public class InputContext {

    public <T> T workWithInputStrategy(InputValidationChain validator,
        InputStrategy<T> inputStrategy) {
        T input = null;
        while (input == null) {
            try {
                input = inputStrategy.executeInput(validator);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }
}
