# java-racingcar
자동차 경주 게임 미션 저장소

# 기능 요구사항
## 1. 경주할 자동차 이름 입력

- 이름들을 쉼표(,) 구분으로 받아 나눠서 각각의 Car 객체에 삽입
- 이름이 5자가 넘는다면 예외처리

## 2. 이동 시도 횟수 입력

- 전진 시도 횟수를 입력한다.
- 숫자가 아닌 입력을 받으면 예외처리

## 3. 랜덤값을 통한 position 설정

- 각각의 Car 객체에 대해 랜덤 조건 실행
- 랜덤값이 4 이상일 경우 Car.position에 +1

## 4. 결과 출력
- 모든 Car 객체가 한번씩 랜덤 조건을 실행했다면 그 결과를 출력
- "실행 결과" 출력 후 줄바꿈
- Car.name + " : " + Car.position의 형태로 출력
- position값만큼 '-'를 출력

## 5. 반복

- 시도횟수에 도달할 때까지 3~4번 반복

## 6. 최종 우승자 출력

- Car.position 값을 비교하여 최대값을 가진 객체의 name을 출력
- 동점자들이 있으면 해당 객체들의 name을 출력
- 이때 name들 사이에 쉼표(,)로 구분해야 함

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
