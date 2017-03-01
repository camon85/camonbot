# 카카오톡 자동응답 API 서버
스칼라와 플레이프레임워크를 이용해서 만들고 헤로쿠에 배포.

셋다 잘은 모르지만 일단 만들어 보았다.

* 옐로아이디 : @camon


> [카카오톡 옐로아이디](https://yellowid.kakao.com)

> [카카오톡 플러스친구/옐로아이디 API v. 2.0 개요](https://github.com/plusfriend/auto_reply)

> [헤로쿠](https://www.heroku.com)




* 헤로쿠는 30분간 호출이 없으면 슬립 상태가 된다.
다시 실행하는데 10여초 정도 소요되므로 이를 방지하기 위해 크론탭으로 1분마다 호출하게 해주었다.

```sh
# 크론탭 편집모드
$ crontab -e

# 1분마다 호출
* * * * * curl https://camon.herokuapp.com

```
                                                                               
