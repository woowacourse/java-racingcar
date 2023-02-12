package dto;

public class CarDto {

    private final String name;
    private final int moveCount;

    public CarDto(String name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
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
