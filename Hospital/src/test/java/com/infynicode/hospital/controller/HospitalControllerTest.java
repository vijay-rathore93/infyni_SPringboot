package com.infynicode.hospital.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infynicode.hospital.model.HospitalMO;
import com.infynicode.hospital.service.HospitalService;
import com.infynicode.hospital.utility.HospitalConstant;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(HospitalController.class)
public class HospitalControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    HospitalService hospitalService;

    @Test
    public void saveHospitalTest() throws Exception {
        HospitalMO hospitalMO=  getHospitalMO();
        HospitalMO actualResponse=  getHospitalMO();
        actualResponse.setId(1);
        ObjectMapper objectMapper=new ObjectMapper();
        String payload=objectMapper.writeValueAsString(hospitalMO);
        Mockito.when( hospitalService.createHospitalRecord(hospitalMO)).thenReturn(actualResponse);

        mvc.perform(MockMvcRequestBuilders
                        .post(HospitalConstant.HOSPITAL_CONTEXT_PATH)
                        .content(payload)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
        Mockito.verify(hospitalService).createHospitalRecord(hospitalMO);
    }

    @Test
    public void saveHospitalTest_negative() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post(HospitalConstant.HOSPITAL_CONTEXT_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest());
    }



    @Test
    public void saveHospitalTest_negative2() throws Exception {
        HospitalMO hospitalMO=  getHospitalMO();
        HospitalMO actualResponse=  getHospitalMO();
        actualResponse.setId(1);
        ObjectMapper objectMapper=new ObjectMapper();
        String payload=objectMapper.writeValueAsString(hospitalMO);
        mvc.perform(MockMvcRequestBuilders
                        .post(HospitalConstant.HOSPITAL_CONTEXT_PATH)
                        .content(payload)
                        .contentType(MediaType.APPLICATION_XHTML_XML_VALUE)
                        .accept(MediaType.APPLICATION_XHTML_XML_VALUE))
                .andExpect(status().isUnsupportedMediaType());
    }


    @Test
    public void getSingleHospitalTest() throws Exception {
        HospitalMO actualResponse=  getHospitalMO();
        actualResponse.setId(1);
        Mockito.when( hospitalService.getSingleHospital(1)).thenReturn(actualResponse);
        mvc.perform(MockMvcRequestBuilders
                        .get(HospitalConstant.HOSPITAL_CONTEXT_PATH+"/"+1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(hospitalService).getSingleHospital(1);
    }

    @Test
    public void getSingleHospitalTest_negative() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post(HospitalConstant.HOSPITAL_CONTEXT_PATH+"/"+1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }


    @Test
    public void allHospitalDataTest() throws Exception {
        HospitalMO actualResponse=  getHospitalMO();
        actualResponse.setId(1);
        Mockito.when( hospitalService.getAllHospitals("lastModifiedDate","desc")).thenReturn(Arrays.asList(actualResponse));
        mvc.perform(MockMvcRequestBuilders
                        .get(HospitalConstant.HOSPITAL_CONTEXT_PATH+"/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(hospitalService).getAllHospitals("lastModifiedDate","desc");
    }

    @Test
    public void allHospitalDataTest_Negative() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post(HospitalConstant.HOSPITAL_CONTEXT_PATH+"/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    private HospitalMO getHospitalMO(){
        return HospitalMO.builder()
                .name("Test Hospital")
                .code("XYZ12345")
                .country("India")
                .state("KA")
                .city("Bangalore")
                .zipCode(560102)
                .addressLine1("HSR")
                .build();

    }





}
