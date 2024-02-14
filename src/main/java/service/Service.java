package service;

public class Service {

    public static boolean willMove() {
        int randomNumber = (int) (Math.random() * 10);
        return randomNumber >= 4;
    }

}
