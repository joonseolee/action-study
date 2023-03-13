package com.joonseolee.actionstudy.module;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InsertCompany {

    @Getter
    public static class Request {
        private String name;
    }
}
