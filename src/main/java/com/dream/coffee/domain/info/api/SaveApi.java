package com.dream.coffee.domain.info.api;

import com.dream.coffee.domain.info.dto.PartySaveRequestParam;
import com.dream.coffee.domain.info.dto.PartySaveResponse;
import com.dream.coffee.domain.info.service.party.PartyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SaveApi {

    private final PartyService partyService;

    @PostMapping("/party/save")
    public PartySaveResponse saveParty(@RequestBody PartySaveRequestParam partySaveRequestParam){
        return partyService.save(partySaveRequestParam);
    }
}
