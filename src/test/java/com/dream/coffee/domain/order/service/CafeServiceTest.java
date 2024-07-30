package com.dream.coffee.domain.order.service;
import com.dream.coffee.domain.info.entity.Cafe;
import com.dream.coffee.domain.info.repository.CafeRepository;
import com.dream.coffee.domain.info.service.cafe.CafeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

@SpringBootTest
public class CafeServiceTest {
    @Autowired
    private CafeService cafeService;

    @Autowired
    private CafeRepository cafeRepository;


    @Test
    public void testGetAllCafe() {
        // Given

        // When
        Page<Cafe> cafePage = cafeService.getAllCafe(0, 10);

        // Then
      System.out.println(cafePage.getContent());

}
}
