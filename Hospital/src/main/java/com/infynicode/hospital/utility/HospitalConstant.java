package com.infynicode.hospital.utility;

public interface HospitalConstant {

    String HOSPITAL_CONTEXT_PATH="/api/v1/hospital";
    String NAME_REQUIRED="Hospital name is required";
    String NAME_LENGTH="Hospital name Must be length of 4 or below 20";
    String STATE_REQUIRED="State  is required";
    String STATE_LENGTH="State Must be length of 4 or below 6";

    String CODE_REQUIRED="Code  is required";
    String CODE_LENGTH="Code Must be length of 8";
    String ZIP_REQUIRED="Zip Code is required";
    String COUNTRY_REQUIRED = "Country  is required";

    String US_COUNTRY = "US";

    String CANADA_COUNTRY = "CANADA";

    String WRONG_COUNTRY = "Country must be US or CANADA";
}
