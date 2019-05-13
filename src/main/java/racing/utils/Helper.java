package racing.utils;
/**
 * 공용으로 사용되는 기능들을 모아놓은 클래스
 *
 * @author imkimheejoo
 * @version 1.0.0
 */
public class Helper {
    public static final String COMMA = ",";

    public static int getRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
