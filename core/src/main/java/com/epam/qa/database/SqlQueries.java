package com.epam.qa.database;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class SqlQueries {

    @Getter
    @AllArgsConstructor
    public enum SelectQueries {

        SELECT_ALL_POSTS("SELECT ...");

        private String query;

    }

    @Getter
    @AllArgsConstructor
    public enum InsertQueries {

        INSERT_POSTS("INSERT ....");

        private String query;

    }
}
