package com.dream.coffee.domain.info.service.menu;

import com.dream.coffee.domain.info.dto.*;
import com.dream.coffee.domain.info.entity.Cafe;
import com.dream.coffee.domain.info.entity.Menu;
import com.dream.coffee.domain.info.repository.MenuRepository;
import com.dream.coffee.domain.info.repository.PartyAttendeeRepository;
import com.dream.coffee.domain.info.repository.PartyRepository;
import com.dream.coffee.domain.info.repository.UsersRepository;
import com.dream.coffee.global.error.CommonException;
import com.dream.coffee.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<Menu> getMenus(String cafeId) {
        return menuRepository.findMenusByCafeId(cafeId);
    }


}
