package com.dream.coffee.domain.info.dto;

import java.util.List;

public record OrderMenuInfo(String menuId, String menuName, List<UserResponse> ordererList) {

}
