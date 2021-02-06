package racingcar.dto;

public class CarResponseDto {
    private final String name;
    private final int position;

    public CarResponseDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
