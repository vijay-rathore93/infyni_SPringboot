package com.infynicode.hospital.utility;


import com.infynicode.hospital.exception.HospitalException;
import com.infynicode.hospital.model.HospitalMO;
import org.springframework.stereotype.Component;

import static com.infynicode.hospital.utility.HospitalConstant.*;

@Component
public class Validators {


    public void validateRequest(HospitalMO input) {

        if (null!=input.getCountry() && !input.getCountry().equalsIgnoreCase(US_COUNTRY)
                && !input.getCountry().equalsIgnoreCase(CANADA_COUNTRY)) {
            throw new HospitalException(WRONG_COUNTRY);
        }
        else{
            String startCharacters=input.getCode().substring(1,5);
            String lastCharacters=input.getCode().substring(5);

        }

    }
}
