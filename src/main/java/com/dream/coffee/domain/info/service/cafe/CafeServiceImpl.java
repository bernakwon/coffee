package com.dream.coffee.domain.info.service.cafe;

import com.dream.coffee.domain.info.entity.Cafe;
import com.dream.coffee.domain.info.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeServiceImpl implements CafeService {

    private final CafeRepository cafeRepository;

    @Override
    public List<Cafe> getAllCafe() {
        return cafeRepository.findAll();
    }
}
