# java-racingcar
자동차 경주 게임 미션 저장소

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 목록
- 이름을 입력 받는다.
	- [예외] 공백을 제거했을 때, 0글자가 되는 이름이 있는 경우
	- [예외] 5글자를 초과하는 이름이 있는 경우
- 입력을 쉼표(,)로 분리하여 자동차 이름 배열을 만든다.
- 자동차 이름 배열을 이용해서 Car 객체 리스트를 만든다.
- 게임 횟수를 입력 받는다.
	- [예외] 0 이하의 숫자가 입력된 경우
- 입력받은 횟수만큼 게임을 진행한다.
	- 각 Car 객체는 한 round 당 하나의 random 숫자를 생성한다.
	- random 숫자가 4 이상이면, position을 1 증가시킨다.
	- 각 Car 객체의 이름과 position을 시각화하여 출력한다.
- 우승자를 선정하여 출력한다.