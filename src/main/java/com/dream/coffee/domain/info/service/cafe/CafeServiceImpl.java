package com.dream.coffee.domain.info.service.cafe;

import com.dream.coffee.domain.info.entity.Cafe;
import com.dream.coffee.domain.info.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeServiceImpl implements CafeService {

    private final CafeRepository cafeRepository;

    @Override
    public Page<Cafe> getAllCafe(int page, int i) {
      //page가 0부터 시작해야하는데 1부터 넘어올때 -1을 해줌,0보다 작으면 0으로 설정
        page = page <= 0 ? 0 : page - 1;
        int size = 10;
        Pageable pageable = PageRequest.of(page, size);
        return cafeRepository.findAll(pageable);
    }
}
