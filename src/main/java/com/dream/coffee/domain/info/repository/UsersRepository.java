package com.dream.coffee.domain.info.repository;

import com.dream.coffee.domain.info.dto.UserResponse;
import com.dream.coffee.domain.info.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users,Long>  {

    @Query("select new com.dream.coffee.domain.info.dto.UserResponse(u.userId,u.name,u.team,u.department,u.level) from Users u")
    List<UserResponse> getAllList();
}
