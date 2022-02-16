package racingcargame.dto;

public class CarDto {
    private final String name;
    private int position;

    public CarDto(final String name, final int position) {
        this.name = name;
        this.position = position;
    }
}
