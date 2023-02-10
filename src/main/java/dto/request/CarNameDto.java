package dto.request;

import static domain.Car.BLANK;
import static domain.Car.MAX_NAME_LENGTH;

public class CarNameDto {

    private final String name;

    public CarNameDto(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        validateToContainBlank(name);
        validateLength(name);
    }

    private void validateToContainBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException("이름에 공백을 포함할 수 없습니다." +
                    "입력값 : " + name);
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다. " +
                    "입력값 : "  + name);
        }
    }
}
