package com.dream.coffee.domain.info.service.party;

import com.dream.coffee.domain.info.dto.PartySaveRequestParam;
import com.dream.coffee.domain.info.dto.PartySaveResponse;

public interface PartyService{
    PartySaveResponse save(PartySaveRequestParam partySaveRequestParam);
}
