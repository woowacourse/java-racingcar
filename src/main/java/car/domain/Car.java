package car.domain;



public class Car {
    private final static int INITIAL_POSITION = 0;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final String LONGER_THAN_MAX_NAME_LENGTH_EXCEPTION_MASSAGE = "[ERROR] 이름이 너무 깁니다.";
    private static final String SHORTER_THAN_MIN_NAME_LENGTH_EXCEPTION_MASSAGE = "[ERROR] 이름이 너무 짧습니다.";
    private static final String UNDER_INITIAL_POINT_EXCEPTION_MASSAGE = "[ERROR] 위치는 시작점보다 작으면 안됩니다.";
    private final String name;
    private int position;

    public Car(String name) {
        this(name, INITIAL_POSITION);
    }

    public Car(String name, int position) {
        validatePositionOverInitialPosition(position);
        catchInputCarNamesException(name);
        this.name = name;
        this.position = position;
    }
    private void catchInputCarNamesException(String input){
        validateNameLength(input);
    }
    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(LONGER_THAN_MAX_NAME_LENGTH_EXCEPTION_MASSAGE);
        }
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(SHORTER_THAN_MIN_NAME_LENGTH_EXCEPTION_MASSAGE);
        }
    }
    private void validatePositionOverInitialPosition(int position) {
        if (position < INITIAL_POSITION) {
            throw new IllegalArgumentException(UNDER_INITIAL_POINT_EXCEPTION_MASSAGE);
        }
    }
    public int selectMaxPosition(int otherPosition) {
        return Math.max(position, otherPosition);
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
}
