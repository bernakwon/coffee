package com.dream.coffee.domain.info.dto;

import com.dream.coffee.domain.info.entity.Party;
import com.dream.coffee.domain.info.entity.PartyAttendee;
import com.dream.coffee.domain.info.entity.Users;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PartySaveRequestParam {


    @Schema(defaultValue = "pd팀커피")
    private String partyName;


    @Schema(defaultValue = "1")
    private String cafeId;


    @Schema(defaultValue = "20240112")
    private String endDate;

    @Schema(defaultValue = "1700")
    private String endTime;


    @Schema(defaultValue = "[1,2]")
    private List<Long> userList;


    public Pair<Party, List<PartyAttendee>> createParty(List<Users> users){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        Party party =  Party.builder()
                .name(partyName)
                .cafeId(cafeId)
                .endDt(LocalDateTime.parse(endDate+endTime,dateTimeFormatter))
                .build();
        List<PartyAttendee> partyAttendees = new ArrayList<>();
        users.forEach(users1 -> {
            partyAttendees.add(PartyAttendee.builder()
                    .party(party)
                    .user(users1)
                    .attendanceStatus("1")
                    .build());
        });

      return Pair.of(party,partyAttendees);
    }


}
