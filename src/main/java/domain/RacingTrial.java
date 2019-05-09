package domain;

public class RacingTrial {
    public void runTrial() {
        System.out.println("각각 차들에 대해서 움직이기");
        MoveStrategy moveStrategy = new MoveStrategy();

        System.out.println("각각 차들의 상태 출력");
    }
}
