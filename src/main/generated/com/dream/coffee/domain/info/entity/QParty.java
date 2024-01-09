package com.dream.coffee.domain.info.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QParty is a Querydsl query type for Party
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QParty extends EntityPathBase<Party> {

    private static final long serialVersionUID = 961391323L;

    public static final QParty party = new QParty("party");

    public final StringPath cafeId = createString("cafeId");

    public final DateTimePath<java.time.LocalDateTime> endDt = createDateTime("endDt", java.time.LocalDateTime.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> party_id = createNumber("party_id", Long.class);

    public final SetPath<PartyAttendee, QPartyAttendee> partyAttendees = this.<PartyAttendee, QPartyAttendee>createSet("partyAttendees", PartyAttendee.class, QPartyAttendee.class, PathInits.DIRECT2);

    public QParty(String variable) {
        super(Party.class, forVariable(variable));
    }

    public QParty(Path<? extends Party> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParty(PathMetadata metadata) {
        super(Party.class, metadata);
    }

}

