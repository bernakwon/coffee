package com.dream.coffee.domain.info.service.party;

import com.dream.coffee.domain.info.dto.PartyInfoResponse;
import com.dream.coffee.domain.info.dto.PartySaveRequestParam;
import com.dream.coffee.domain.info.dto.PartySaveResponse;
import com.dream.coffee.domain.info.entity.Party;

import java.util.List;

public interface PartyService{
    PartySaveResponse save(PartySaveRequestParam partySaveRequestParam);

    PartyInfoResponse getById(Long partyId);
}
