package com.superadtech.modids.proxy;

import unified.vpn.sdk.Country;

public class CountryData {
    private Country countryvalue;
    public static final String COUNTRY_DATA = "Country_data";
    public static final String SELECTED_COUNTRY = "selected_country";
    public static String noty_selected_country = "";

    public Country getCountryvalue() {
        return countryvalue;
    }

    public void setCountryvalue(Country countryvalue) {
        this.countryvalue = countryvalue;
    }
}
