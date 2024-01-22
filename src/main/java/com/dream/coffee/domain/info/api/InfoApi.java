package com.dream.coffee.domain.info.api;

import com.dream.coffee.domain.info.dto.PartyInfoResponse;
import com.dream.coffee.domain.info.dto.UserResponse;
import com.dream.coffee.domain.info.entity.Cafe;
import com.dream.coffee.domain.info.entity.Party;
import com.dream.coffee.domain.info.entity.PartyAttendee;
import com.dream.coffee.domain.info.entity.Users;
import com.dream.coffee.domain.info.repository.PartyRepository;
import com.dream.coffee.domain.info.repository.UsersRepository;
import com.dream.coffee.domain.info.service.cafe.CafeService;
import com.dream.coffee.domain.info.service.party.PartyService;
import com.dream.coffee.domain.info.service.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class InfoApi {

    private final UserService userService;
    private final CafeService cafeService;

    private final PartyService partyService;
    @GetMapping("/users")
    public List<UserResponse> getList(){

        return userService.getAllUsers();
    }
    @GetMapping("/cafe/info")
    public List<Cafe> getCafeList(){
        return cafeService.getAllCafe();
    }

    @GetMapping("/party/info/{partyId}")
    public List<PartyAttendee> getPartyList(@PathVariable("partyId") Long partyId){
        return partyService.getById(partyId);
    }

    /*


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
