package com.dream.coffee.domain.info.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCafe is a Querydsl query type for Cafe
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCafe extends EntityPathBase<Cafe> {

    private static final long serialVersionUID = -1493395704L;

    public static final QCafe cafe = new QCafe("cafe");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QCafe(String variable) {
        super(Cafe.class, forVariable(variable));
    }

    public QCafe(Path<? extends Cafe> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCafe(PathMetadata metadata) {
        super(Cafe.class, metadata);
    }

}

