package com.dream.coffee.domain.info.service.cafe;

import com.dream.coffee.domain.info.entity.Cafe;
import org.springframework.data.domain.Page;

public interface CafeService{
    Page<Cafe> getAllCafe(int page, int i);
}
