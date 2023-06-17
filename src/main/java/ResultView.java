public class ResultView {
    public ResultView() {
        System.out.println("실행 결과");
    }

    public void showCarLocation(Car car) {
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
