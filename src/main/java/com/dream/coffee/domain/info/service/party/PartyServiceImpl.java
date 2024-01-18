package com.dream.coffee.domain.info.service.party;

import com.dream.coffee.domain.info.dto.PartyInfoResponse;
import com.dream.coffee.domain.info.dto.PartySaveRequestParam;
import com.dream.coffee.domain.info.dto.PartySaveResponse;
import com.dream.coffee.domain.info.entity.Party;
import com.dream.coffee.domain.info.entity.PartyAttendee;
import com.dream.coffee.domain.info.entity.Users;
import com.dream.coffee.domain.info.repository.PartyAttendeeRepository;
import com.dream.coffee.domain.info.repository.PartyRepository;
import com.dream.coffee.domain.info.repository.UsersRepository;
import com.dream.coffee.global.error.CommonException;
import com.dream.coffee.global.error.ErrorCode;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;

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
    public PartyInfoResponse getById(Long partyId) {
        PartyInfoResponse partyInfoResponse = new PartyInfoResponse();
        Party party = partyRepository.findByPartyId(partyId);
        Set<PartyAttendee> partyAttendeeList = party.getPartyAttendees();
       // partyAttendeeList.
        return null;
    }
}
