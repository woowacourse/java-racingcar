package domain.validation;

import domain.dto.InputValidationRequest;

public interface InputValidationChain {

    void setNext(InputValidationChain next);

    boolean validate(InputValidationRequest request);
}
