package com.dream.coffee.domain.info.service.party;

import com.dream.coffee.domain.info.dto.*;
import com.dream.coffee.domain.info.entity.Party;
import com.dream.coffee.domain.info.entity.PartyAttendee;
import com.dream.coffee.domain.info.entity.Users;
import com.dream.coffee.domain.info.repository.PartyAttendeeRepository;
import com.dream.coffee.domain.info.repository.PartyRepository;
import com.dream.coffee.domain.info.repository.UsersRepository;
import com.dream.coffee.global.error.CommonException;
import com.dream.coffee.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyService {

    private final PartyRepository partyRepository;
    private final UsersRepository usersRepository;

    private final PartyAttendeeRepository partyAttendeeRepository;

    @Override
    public PartySaveResponse save(PartySaveRequestParam partySaveRequestParam) {
        if (Objects.isNull(partySaveRequestParam)) {
            throw new CommonException(ErrorCode.INVALID_PARAM);
        }

        List<Users> usersList = usersRepository.findAllById(partySaveRequestParam.getUserList());
        if (Objects.isNull(usersList)) {
            throw new CommonException(ErrorCode.INVALID_USER);
        }

        Pair<Party,List<PartyAttendee>> newParty = partySaveRequestParam.createParty(usersList);
        Party result = partyRepository.save(newParty.getLeft());
        partyAttendeeRepository.saveAll(newParty.getRight());

        return new PartySaveResponse(result.getPartyId(),result.getName());
    }

    @Override
    @Transactional
    public List<PartyDtlInfoResponse> getById(Long partyId) {

        List<PartyInfoResponse> attendees = partyAttendeeRepository.findAttendeesByPartyId(partyId);
        List<PartyDtlInfoResponse> infoResponse = attendees.stream()
                .collect(Collectors.groupingBy(i -> Arrays.asList(i.getPartyId(), i.getPartyName(),i.getEndDt())))
                .entrySet().stream()
                .map(e -> new PartyDtlInfoResponse((Long) e.getKey().get(0), (String) e.getKey().get(1), (LocalDateTime) e.getKey().get(2),
                        e.getValue().stream().map(i -> new UserResponse(i.getUserId(), i.getName())).collect(Collectors.toSet())
                   ))
                .collect(Collectors.toList());
        return infoResponse;
    }
}
