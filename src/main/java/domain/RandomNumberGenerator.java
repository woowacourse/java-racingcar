package domain;

import java.util.Random;

/**
 * TODO: util 패키지로 분리
 * 해당 객체는 다양하게 활용 가능한 Util 성질의 객체이며
 * 메서드 또한 static으로 정의되어 있어 domain에 두기보다 util 패키지로 분리하여 관리하는 것이 좋다고 느껴짐
 *
 * TODO: 매직 넘버 제거
 * 0, 9는 매직 넘버이기 때문에 어떤 의미를 가졌는지 상수화시켜 이름을 부여하면 좋겠음
 * ex) MIN_POWER_RANGE, MAX_POWER_RANGE
  */

public class RandomNumberGenerator {
    private static final Random random = new Random();

    public static int generate() {
        return random.nextInt(0, 9);
    }
}
