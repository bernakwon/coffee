package com.dream.coffee.domain.info.service.menu;

import com.dream.coffee.domain.info.dto.*;
import com.dream.coffee.domain.info.entity.Menu;
import com.dream.coffee.domain.info.repository.MenuRepository;
import com.dream.coffee.domain.info.repository.PartyAttendeeRepository;
import com.dream.coffee.domain.info.repository.PartyRepository;
import com.dream.coffee.domain.info.repository.UsersRepository;
import com.dream.coffee.global.error.CommonException;
import com.dream.coffee.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final PartyRepository partyRepository;
    private final UsersRepository usersRepository;
    private final MenuRepository menuRepository;
    private final PartyAttendeeRepository partyAttendeeRepository;

    @Override
    public Long save(MenuSaveRequestParam menuSaveRequestParam) {
        if (Objects.isNull(menuSaveRequestParam)) {
            throw new CommonException(ErrorCode.INVALID_PARAM);
        }
        Menu menu = Menu.builder().cafeId(menuSaveRequestParam.getCafeId()).name(menuSaveRequestParam.getMenuNm()).build();
        Menu newMenu = menuRepository.save(menu);
        return !Objects.isNull(newMenu)?newMenu.getId():null;
    }

    @Override
    public Page<MenuInfoResponse> getMenus(String partyId, int page, String searchTag) {
        //page가 0부터 시작해야하는데 1부터 넘어올때 -1을 해줌,0보다 작으면 0으로 설정
        page = page <= 0 ? 0 : page - 1;
        int size = 10;
        Pageable pageable = PageRequest.of(page, size);
        return menuRepository.findMenusByPartyId(partyId,searchTag, pageable);
    }


}
