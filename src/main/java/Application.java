import controller.RacingController;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        racingController.setUp();
        racingController.run();
    }
}
