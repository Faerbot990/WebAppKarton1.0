package net.karton.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum GoodCategory {
    ONE_CATEGORIES("NAME"),
    TWO_CATEGORIES("NAME"),
    THREE_CATEGORIES("NAME"),
    FOUR_CATEGORIES("NAME");

    private final String name;

    GoodCategory(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

}
