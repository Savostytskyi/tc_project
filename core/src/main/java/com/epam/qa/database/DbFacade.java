package com.epam.qa.database;

import com.epam.qa.config.EnvConfig;
import com.epam.qa.database.SqlQueries.InsertQueries;
import com.epam.qa.database.SqlQueries.SelectQueries;
import com.epam.qa.entities.Entity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.Arrays;
import java.util.List;

@Slf4j
public final class DbFacade {

    private static Sql2o sql2o;

    private DbFacade() {
    }

    static {
        log.info("Create database connection, db url - '{}'", EnvConfig.get().getDbUrl());
        sql2o = new Sql2o(EnvConfig.get().getDbUrl(), EnvConfig.get().getDbLogin(), EnvConfig.get().getDbPassword());
    }

    @SafeVarargs
    public static <T extends Entity> List<T> select(SelectQueries sqlQuery, Class<T> returnType, Pair<String, Object>... params) {
        try (Connection con = sql2o.open()) {
            Query query = con.createQuery(sqlQuery.getQuery());
            Arrays.stream(params).forEach(param -> query.addParameter(param.getKey(), param.getValue()));
            log.info("Select data from database using query: [ {} ]", query.toString());
            return query.executeAndFetch(returnType);
        }
    }

    public static <T extends Entity> void insert(InsertQueries sqlQuery, T entity) {
        try (Connection con = sql2o.beginTransaction()) {
            Query query = con.createQuery(sqlQuery.getQuery());
            entity.toMap().forEach(query::addParameter);
            log.info("Insert data into database using query: [ {} ]", query.toString());
            query.executeUpdate();
            con.commit();
        }
    }
}
