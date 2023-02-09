package racingcar.dto;

public class CarDto {
    private final String name;
    private final int movedCount;

    public CarDto(String name, int movedCount) {
        this.name = name;
        this.movedCount = movedCount;
    }

    public String getName() {
        return name;
    }

    public int getMovedCount() {
        return movedCount;
    }
}
