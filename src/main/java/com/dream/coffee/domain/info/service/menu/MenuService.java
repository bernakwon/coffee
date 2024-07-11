package com.dream.coffee.domain.info.service.menu;

import com.dream.coffee.domain.info.dto.MenuSaveRequestParam;
import com.dream.coffee.domain.info.entity.Menu;

import java.util.List;

public interface MenuService {
    Long save(MenuSaveRequestParam menuSaveRequestParam);

    List<Menu> getMenus(String partyId);
}
