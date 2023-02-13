package validation;

import dto.InputValidationRequest;

public interface InputValidationChain {

    void setNext(InputValidationChain next);

    boolean validate(InputValidationRequest request);
}
