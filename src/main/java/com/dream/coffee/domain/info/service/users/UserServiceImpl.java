package com.dream.coffee.domain.info.service.users;

import com.dream.coffee.domain.info.dto.UserResponse;
import com.dream.coffee.domain.info.entity.Users;
import com.dream.coffee.domain.info.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    @Override
    public List<UserResponse> getAllUsers() {
        return usersRepository.getAllList();
    }
}
