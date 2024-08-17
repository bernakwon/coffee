package com.dream.coffee.domain.info.service.cafe;

import com.dream.coffee.domain.info.entity.Cafe;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CafeService{
    List<Cafe> getAllCafe();
}
