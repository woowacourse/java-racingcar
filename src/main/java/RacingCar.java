public class RacingCar {
    private String name;
    private int position = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public int getPostion() {
        return position;
    }

    public void proceed() {
        position++;
    }
}
