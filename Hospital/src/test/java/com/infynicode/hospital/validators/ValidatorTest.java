package com.infynicode.hospital.validators;

import com.infynicode.hospital.exception.HospitalException;
import com.infynicode.hospital.model.HospitalMO;
import com.infynicode.hospital.utility.Validators;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.infynicode.hospital.utility.HospitalConstant.WRONG_COUNTRY;

@ExtendWith(MockitoExtension.class)
public class ValidatorTest {

    @InjectMocks
    private Validators validators;

    @Test
    public void testValidateRequest(){
        HospitalMO hospitalMO=getHospitalMO();
        HospitalException exception= Assertions.assertThrows(HospitalException.class,()->validators.validateRequest(hospitalMO));
        Assertions.assertNotNull(exception);
        Assertions.assertEquals(WRONG_COUNTRY,exception.getErrorMessage());

    }

    @Test
    public void testValidateRequest2(){
        HospitalMO hospitalMO=getHospitalMO();
        hospitalMO.setCountry("India");
        HospitalException exception= Assertions.assertThrows(HospitalException.class,()->validators.validateRequest(hospitalMO));
        Assertions.assertNotNull(exception);
        Assertions.assertEquals(WRONG_COUNTRY,exception.getErrorMessage());

    }

    private HospitalMO getHospitalMO(){
        return HospitalMO.builder()
                .name("Test Hospital")
                .code("XYZ12345")

                .state("KA")
                .city("Bangalore")
                .zipCode(560102)
                .addressLine1("HSR")
                .build();

    }

}
