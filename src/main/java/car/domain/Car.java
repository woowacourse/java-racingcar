package car.domain;


public class Car {
    private final static int INITIAL_POSITION = 0;
    private static final String UNDER_INITIAL_POINT_EXCEPTION_MASSAGE = "[ERROR] 위치는 시작점보다 작으면 안됩니다.";
    private final String name;
    private int position;

    public Car(String name) {
        this(name, INITIAL_POSITION);
    }

    public Car(String name, int position) {
        validatePositionOverInitialPosition(position);
        this.name = name;
        this.position = position;
    }

    private void validatePositionOverInitialPosition(int position) {
        if (position < INITIAL_POSITION) {
            throw new IllegalArgumentException(UNDER_INITIAL_POINT_EXCEPTION_MASSAGE);
        }
    }

    public int selectMaxPosition(int otherPosition) {
        return Math.max(position, otherPosition);
    }

    public boolean hasSamePositionWith(int otherPosition) {
        return position == otherPosition;
    }

    public void move(MoveChance moveChance) {
        if (moveChance.isMovable()) {
            position++;
        }
    }


    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
    public CarDto getCarDto(){return new CarDto(this);}
}
