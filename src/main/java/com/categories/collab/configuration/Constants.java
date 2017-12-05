package com.categories.collab.configuration;

public final class Constants {

    private Constants() {
        // restrict instantiation
    }

    public static final String AUTH_METHOD_LDAP = "LDAP";
    public static final String AUTH_METHOD_NONE = "NONE";
    public static final String AUTH_METHOD_IN_MEMORY = "IN_MEMORY";
    public static final String AUTH_METHOD_DATA_STORE = "DATA_STORE";
    public static final String AUTH_METHOD = AUTH_METHOD_NONE;


    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    public static final int PAGE_SIZE = 12;
}
