package com.dream.coffee.domain.info.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoApi {

    /*
    @RequestMapping("/users")
    @RequestMapping("/select/complate")
    @RequestMapping("/cafeinfo")


  * 1)**인원 정보 목록**

/users

모든 인원 정보를 반환

request: x

response

이름(name)

팀(team)

부서(department)

직급(rank)

전화번호(c_no)

2)**다음 버튼 클릭시(선택된 인원 저장 api)**

/select/complate

선택된 인원정보가 임시파티 테이블에 저장됨

request:

선택된 인원정보 배열

[{권혜란,pd팀,기업부설연구소,잡부,010-6111-1111},{~~~}}

response:

임시파티 테이블의 id

WF_크리에이터 파티생성01

---

공통

**1)카페목록(카페이름,카페별 메뉴)**

/cafeinfo

**2)파티정보 저장 api**

request:

임시 파티 id

파티명

카페

마감일

response:

파티정보

WF_주문자 주문현황01

---

**1) 파티별 주문정보api**

**1-1) 파티 정보**

/party/info

request:파티id

response:파티명,마감일,취합종료여부,주문인원목록

**1-2)주문 메뉴 정보**

/party/orderinfo

request:파티id

response:주문메뉴 정보(음료명,카페명,주문자(정보object)api)

WF_주문자 주문현황01_01

---

**파티인원 목록 api(주문정보 포함)**

/party/users

request:파티id

response:주문여부 포함한 파티원 이름 목록

WF_주문자 메뉴선택01

---

**카페별 메뉴조회**

request : 카페아이디

response:[list] 메뉴명

**태그조회**

request:x

response:[list]태그명

**메뉴저장**

request:카페아이디,메뉴명

response:true/false

**메뉴선택 저장 api**

request:카페아이디,주문자,메뉴명

response:true/false

DB

파티명,마감일,취합종료여부,주문인원목록

USER(NAME,TEAM,TEL)

PARTY(NAME,USERS,ENDDATE,)

CAFE**(NAME,MENULiST)**

ORDER**(PARTY,사람명,사람별 메뉴)**
  *
  *
  *
  *
  *
  * */
    
}
