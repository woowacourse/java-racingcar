# java-racingcar
자동차 경주 게임 미션 저장소

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 목록
* 자동차 이름을 입력을 받는다.
   * **예외** : 자동차 이름을 쉼표로 구분한다.
   * **예외** :  이름은 5자 이하인지 판별하는 기능 구현한다.
   * **예외** : 쉼표 사이에 글자가 없는 경우도 골라내야 한다.
   * **예외** : 아무것도 입력이 안됐을 때도 골라내야 한다.
   * **예외** : 중복되는 이름이 있는지 판단해야 한다.
   
* 자동차를 생성하는 기능을 구현한다. 
* 시도할 횟수를 입력받는다.
   * **예외** 횟수가 자연수인지 확인한다.
* 경주를 실행한다. 
    * 자동차를 움직이기 위한 난수를 생성한다.
    * 생성한 난수를 토대로 움직일 수 있는지 없는지 판단해야 한다.
    * 자동차를 움직인다.
* 우승자를 판단한다.
    * 가장 멀리 이동한 거리를 구한다.
    * 해당 거리와 일치하는 자동차 이름을 리스트에 추가한다.
* 실행 결과를 출력한다.

##테스트 코드 목록 
* 난수생성이 올바른지 판단하는 테스트코드를 작성한다.
* 자동차가 움직이는 조건을 판단하는 테스트코드를 작성한다.
* 숫자가 4이하일 때 움직이지 않는지 확인하는 테스트코드를 작성한다.
* 숫자가 5이상일 때 움직이는지 확인하는 테스트코드를 작성한다.

*