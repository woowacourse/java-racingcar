package dto.request;

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
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[Error] 이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다. " +
                    "입력값 : "  + name);
        }
    }
}
