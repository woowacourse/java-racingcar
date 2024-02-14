public class Car {
    private final String name;
    private int location;

    public Car(String name) {
        //TODO : 이름 제약사항 처리
        this.name = name;
        location = 0;
    }

    public void tryMove() {
        if ((int) (Math.random() * 9) >= 4) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
