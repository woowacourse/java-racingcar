# java-racingcar
자동차 경주 게임 미션 저장소



## 기능 요구사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.



## 필요한 기능

1. 문자열을 입력받아 car 객체를 생성

   - 문자열을 입력받는다. 

   - 문자열을 나눈다.

   - car 객체들을 생성한다
   - 일급컬렉션에 담아준다.

2. 반복회수를 입력받아 레이싱을 진행하고, 상태를 출력한다.
   - 반복회수 숫자를 입력받는다. 
   - 반복회수마다 Car를 이동시킨다.
     - Car는 랜덤 숫자를 생성하고, 그 숫자가 4 이상일 경우 한칸 전진한다.
   - Car객체의 State를 출력한다.

3. 우승자를 구하고 출력한다.
   - Car의 일급 컬렉션은 모든 Car에 대해 최대 이동 거리를 구한다.
   - 최대 이동거리에 속하는 Car 객체를 구한다.
   - Car객체의 Name을 출력한다.

## 가능한 예외

#### 1번케이스

- 쉼표로 구분되지 않는 경우.
- 구분된 문자열의 길이가 5를 초과하는 경우.
- Car 이름이 공백인 경우

#### 2번케이스

- 반복회수가 숫자가 아닌 경우.
- 반복회수가 0이거나 음수인 경우.





# 문자열 계산기



## 요구사항

- 문자열을 계산하는 계산기 (사칙연산 우선순위는 무시한다.)
- if문을 사용하지 않고 구현



## 기능

- 문자열을 입력 받으면 `Space`를 기준으로 분리해준다. ex) `3 + 2 * 4 / 10`
  - 적절한 입력이 아닐 경우 예외처리 후 재입력한다.
- 분리한 연산자와 숫자들을 이용해서 계산해준다. 
  - 연산자를 Map의 key로 연산은 Value로 구현해준다.  
  - 연산자와 숫자를 넣으면 map에서 해당 연산자(value)의 연산메소드를 이용해서 연산 결과를 반환해준다.

- 

## 해결과정

- https://dublin-java.tistory.com/38



## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
