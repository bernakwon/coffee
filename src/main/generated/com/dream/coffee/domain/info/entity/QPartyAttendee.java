package com.dream.coffee.domain.info.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPartyAttendee is a Querydsl query type for PartyAttendee
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPartyAttendee extends EntityPathBase<PartyAttendee> {

    private static final long serialVersionUID = 146985141L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPartyAttendee partyAttendee = new QPartyAttendee("partyAttendee");

    public final NumberPath<Long> attendanceId = createNumber("attendanceId", Long.class);

    public final StringPath attendanceStatus = createString("attendanceStatus");

    public final QParty party;

    public final QUsers user;

    public QPartyAttendee(String variable) {
        this(PartyAttendee.class, forVariable(variable), INITS);
    }

    public QPartyAttendee(Path<? extends PartyAttendee> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPartyAttendee(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPartyAttendee(PathMetadata metadata, PathInits inits) {
        this(PartyAttendee.class, metadata, inits);
    }

    public QPartyAttendee(Class<? extends PartyAttendee> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.party = inits.isInitialized("party") ? new QParty(forProperty("party")) : null;
        this.user = inits.isInitialized("user") ? new QUsers(forProperty("user")) : null;
    }

}

