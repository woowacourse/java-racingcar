# java-racingcar

자동차 경주 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 요구사항 해석

1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    - n 은 2 이상 10 이하의 정수만 가능하다.
2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
3. 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
    - 자동차 이름은 알파벳 대문자 혹은 소문자의 조합으로 이루어져있어야 한다.
    - 각 자동차 이름은 중복될 수 없다. 대소문자를 구분한다.
    - 자동차 이름은 1글자 이상이어야 한다.
4. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
    - 이동 횟수는 1 이상 100이하의 정수만 가능하다.
5. 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
6. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
    - 최종 이동 거리가 제일 먼 자동차가 우승한다.
7. 사용자가 잘못된 입력을 한 경우, 해당 입력부터 다시 수행한다. 이전에 입력한 내용은 그대로 유지된다.
    - 입력이 왜 잘못되었는지 에러 메세지를 출력한다.
    - 5번째 재입력이 잘못된 입력인 경우 프로그램을 종료한다. 이때, 비정상 종료 메세지를 출력한다.

## 예시

```
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

pobi : -----
crong : ----
honux : -----

pobi, honux가 최종 우승했습니다.
```

## 기능 목록

- [x] 자동차 이름 입력 기능
- [x] 자동차 이동 횟수 입력 기능
- [x] 지동차 이동 기능
- [x] 랜덤 숫자 생성 기능
- [x] 우승자 판별 기능
- [x] 결과 출력 기능
- [x] 입력 가이드 출력 기능
- [x] 잘못된 입력 처리 기능

## 피드백 반영 사항

- [x] 메서드 15줄 꽉 채운거 분리
- [x] 의미 있는 상수 추가
- [x] Cars 누락된 테스트 추가
- [x] 구글 컨벤션 적용
- [x] RetryHelper early return
- [x] DTO Mapper 삭제

## 2단계 피드백 반영 예정 사항

- [ ] 간단한 코드로 대체 가능한 것은 대체
- [ ] Car의 distance 대신 positon 으로 필드명 변경
- [ ] RandomGenerator 클래스 위치 변경
- [ ] Car의 stop 메서드 제거
- [ ] RaceController.readFromConsole 메서드 위치 뷰로 변경
- [ ] 입출력 검증을 뷰에서 분리