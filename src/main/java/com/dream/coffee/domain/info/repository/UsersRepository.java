package com.dream.coffee.domain.info.repository;

import com.dream.coffee.domain.info.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
}
