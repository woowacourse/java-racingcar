package view.dto;

public class CarDto {

    private String carName;
    private int movement;

    public CarDto(String carName, int movement) {
        this.carName = carName;
        this.movement = movement;
    }

    public String getCarName() {
        return carName;
    }

    public int getMovement() {
        return movement;
    }
}
