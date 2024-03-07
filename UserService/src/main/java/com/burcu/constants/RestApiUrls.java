package com.burcu.constants;

public class RestApiUrls {



    private static final String VERSION ="/v1";
    private static final String DEV="/dev";

    private static final String ROOT= DEV + VERSION;
    public static final String USER = ROOT + "/user";


    public static final String CREATE_USER= "/create-user";
    public static final String FIND_ALL= "/find-all";
    public static final String UPDATE_USER= "/update-user";
    public static final String FIND_BY_ID= "/find-by-id";
    public static final String DELETE_BY_TOKEN= "/delete-by-token";
    public static final String REGISTER_RABBITMQ ="/register-rabbitmq";
    public static final String REGISTER= "/register";
    public static final String LOGIN= "/login";
    public static final String UPDATE= "/update";
    public static final String ACTIVATE_USER = "/activate-user" ;
    public static final String RENT_CAR = "/rent-car";
    public static final String FIND_BY_TOKEN = "/find-by-token";
    public static final String TOP_UP_BALANCE = "/top-up-balance";
    public static final String VIEW_PROFILE= "/view-profile";
}
