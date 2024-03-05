package com.dream.coffee.domain.info.service.party;



import com.dream.coffee.domain.info.entity.Party;
import com.dream.coffee.domain.info.entity.PartyAttendee;
import com.dream.coffee.domain.info.entity.Users;
import com.dream.coffee.domain.info.repository.PartyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class PartyServiceImplTest {

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private PartyService partyService;

    @Test
    public void testGetAttendeesByPartyId() {
        // Given
        Party party = new Party();
        party.setName("Test Party");
        partyRepository.save(party);

        Users user1 = new Users();
        user1.setName("User1");
      //  user1.setRank("pro");
        Users user2 = new Users();
        user2.setName("User2");
       // user2.setRank("pro");

        PartyAttendee attendee1 = new PartyAttendee();
        attendee1.setParty(party);
        attendee1.setUser(user1);
        attendee1.setAttendanceStatus("Attending");

        PartyAttendee attendee2 = new PartyAttendee();
        attendee2.setParty(party);
        attendee2.setUser(user2);
        attendee2.setAttendanceStatus("Attending");

      Set<PartyAttendee> resultAttendee = new HashSet<>();
        resultAttendee.add(attendee1);
        resultAttendee.add(attendee2);
        party.setPartyAttendees(resultAttendee);

        partyRepository.save(party);

        // When
       // List<PartyAttendee> attendees = partyService.getById(party.getPartyId());

        // Then
      //  assertEquals(2, attendees.size());
    //    assertEquals("User1", attendees.get(0).getUser().getName());
      //  assertEquals("User2", attendees.get(1).getUser().getName());
    }
}