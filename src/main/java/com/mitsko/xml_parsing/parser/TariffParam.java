package com.mitsko.xml_parsing.parser;

public enum TariffParam {
    TARIFFS("tariffs"),
    TARIFF("tariff"),
    NAME("name"),
    OPERATOR_NAME("operator_name"),
    PAYROLL("payroll"),
    CALL_PRICES("call_prices"),
    INSIDE("inside"),
    OUTSIDE("outside"),
    HOME_PHONE("home_phone"),
    SMS_PRICE("SMS_price"),
    PARAMETERS("parameters"),
    FAVORITE_NUMBER("favorite-number"),
    CHARGING("charging"),
    CONNECTION_PRICE("connection_price");

    private String value;

    TariffParam(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
