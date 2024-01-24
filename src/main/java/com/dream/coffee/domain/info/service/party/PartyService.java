package com.dream.coffee.domain.info.service.party;

import com.dream.coffee.domain.info.dto.PartyDtlInfoResponse;
import com.dream.coffee.domain.info.dto.PartySaveRequestParam;
import com.dream.coffee.domain.info.dto.PartySaveResponse;

import java.util.List;

public interface PartyService{
    PartySaveResponse save(PartySaveRequestParam partySaveRequestParam);

    List<PartyDtlInfoResponse> getById(Long partyId);
}
