package com.burcu.constants;

public class RestApiUrls {


    private static final String VERSION ="/v1";
    private static final String DEV="/dev";
    private static final String ROOT= DEV + VERSION;
    public static final String VEHICLE = ROOT + "/vehicle";
    public static final String RENTING = ROOT + "/renting";

    public static final String CREATE_VEHICLE= "/create-vehicle";
    public static final String FIND_ALL= "/find-all";
    public static final String FIND_VEHICLES_BY_STATUS_AND_AMOUNT_OF_FUEL= "/find-vehicles-by-status-and-fuel";
    public static final String SELECT_VEHICLE= "/select-vehicle";
    public static final String RENT_CAR= "/rent-car";
    public static final String FIND_BY_TOKEN= "/find-by-token";
    public static final String UPDATE_VEHICLE= "/update-vehicle";
}
