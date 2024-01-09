package com.dream.coffee.domain.info.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsers is a Querydsl query type for Users
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUsers extends EntityPathBase<Users> {

    private static final long serialVersionUID = 966532605L;

    public static final QUsers users = new QUsers("users");

    public final StringPath name = createString("name");

    public final SetPath<PartyAttendee, QPartyAttendee> partyAttendees = this.<PartyAttendee, QPartyAttendee>createSet("partyAttendees", PartyAttendee.class, QPartyAttendee.class, PathInits.DIRECT2);

    public final StringPath team = createString("team");

    public final StringPath telNo = createString("telNo");

    public final NumberPath<Long> user_id = createNumber("user_id", Long.class);

    public QUsers(String variable) {
        super(Users.class, forVariable(variable));
    }

    public QUsers(Path<? extends Users> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUsers(PathMetadata metadata) {
        super(Users.class, metadata);
    }

}

