package dto;

public class CarDto {

    private final String name;
    private int moveCount;

    public CarDto(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(moveCount);
    }
}
