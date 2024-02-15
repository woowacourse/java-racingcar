import java.util.concurrent.ThreadLocalRandom;

public class Car {

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    // 0 ~ 9 까지의 랜덤한 수를 생성해 4이상일 경우 전진, 4미만일 경우 정지한다.
    public void moveCar() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomNumber = random.nextInt(10);
        if (randomNumber >= 4) {
            distance++;
        }
        if (distance < 0) {
            throw new IllegalArgumentException("이동 거리는 음수가 될 수 없습니다.");
        }
    }
}
