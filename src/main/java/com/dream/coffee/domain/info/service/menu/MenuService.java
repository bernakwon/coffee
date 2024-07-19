package com.dream.coffee.domain.info.service.menu;

import com.dream.coffee.domain.info.dto.MenuSaveRequestParam;
import com.dream.coffee.domain.info.entity.Menu;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MenuService {
    Long save(MenuSaveRequestParam menuSaveRequestParam);

    Page<Menu> getMenus(String partyId, int page, int size);
}
