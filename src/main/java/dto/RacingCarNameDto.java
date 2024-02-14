package dto;

public class RacingCarNameDto {
    private final String name;

    public RacingCarNameDto(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하만 가능합니다.");
        }
    }
}
