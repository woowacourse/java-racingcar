# StringCalculator
1. 커스텀구분자를 확인하는 기능
   * 기본구분자는 ',',':'이다.
   * 커스텀구분자일 경우, 기본구분자에 더해준다.
2. 구분자를 기준으로 문자열을 나눠주는 기능
3. 문자열의 숫자를 더해주는 기능
   * [예외] 문자열이 숫자가 아닌경우, RuntimeException을 발생시킨다.
   * [예외] 문자열이 음수인 경우, RuntimeException을 발생시킨다.
   * [예외] 문자열이 공백인 경우, 0을 리턴한다.

<br>

# RacingCar
1. 입력받는 기능
   * 자동차의 이름을 ',' 기준으로 입력
   * 이동할 횟수 입력
2. 랜덤 값 생성 기능
3. 자동차 이동 기능
   * 값이 4이상인 경우 전진, 미만인 경우 그대로
4. 최종우승자 계산 기능
5. 출력 기능

model Car 
controller InputController OutputController RaceController
view InputView, OutputView
util RandomNumberGenerator


<br>
<br>

자동차 경주 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)