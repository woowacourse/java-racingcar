# java-racingcar

자동차 경주 미션 저장소

## 🚀 구현할 기능 목록

---

> ### 1. 입력

- ### 자동차 이름 목록
  - [ ] [ 예외 ] : `공백` - *(입력받은 문자열의 앞 뒤를 제거해준다.)*
  - [x] [ 예외 ] : 자동차가 `2대 미만`
  - [x] [ 예외 ] : 이름이 `중복`
  - [x] [ 예외 ] : `5글자 초과`


- ### 시도할 횟수
  - [ ] [ 예외 ] : `공백` - *(입력받은 문자열의 앞 뒤를 제거해준다.)*
  - [ ] [ 예외 ] : 숫자가 아닌 `문자`
  - [ ] [ 예외 ] : `1 미만`


- ### 예외 처리
  - [ ] `IllegalArgumentException`를 발생 시킴
  - [ ] `[ERROR]`로 시작하는 에러 메시지를 출력
  - [ ] 에러 생성 지점부터 `다시 입력 받음 ` 



> ### 2. 레이싱

- ### 자동차 이동
  - [ ] `0에서 9 사이에서 무작위 값을 구한 후` 무작위 값이 `4 이상일 경우 전진`
    - [ ] 입력 받은 횟수 만큼 이동 시도
  - [ ] 개별 자동차 위치 갱신


- ### 경기 진행
  - [ ] 입력 받은 `횟수 만큼 반복해서 경기 진행`
  - [ ] 경기 별 우승자 판별
  - [ ] 최종 우승자 판별



> ### 3. 출력

- ### 각 차수별 실행 결과
  - [ ] `이름 : 이동한 거리 * ( - ) 로 출력`
- ### 최종 우승자
  - [ ] `단독` 우승자
  - [ ] `공동` 우승자
    - [ ] "," 로 분리하여 출력


----