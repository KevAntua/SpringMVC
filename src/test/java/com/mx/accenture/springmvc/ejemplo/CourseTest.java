package com.mx.accenture.springmvc.ejemplo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.accenture.springmvc.ejemplo.controller.ControladorPrincipal;
import com.mx.accenture.springmvc.ejemplo.service.ICursosService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ControladorPrincipal.class)
public class CourseTest {

    //MockMvc component is provided by Spring to make calls to the Spring MVC API and assert different properties like status code and received response.
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    private ICursosService iCursoService; // This will mock a Spring Bean and Inject it where is needed


    @WithMockUser("admin")
    @Test
    void getAllCoursesTest() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/listar"))
                .andExpect(status().isOk()).andReturn(); //check is response status is 200
        assertEquals(200, result.getResponse().getStatus());
    }

    @WithMockUser("admin")
    @Test
    void deleteCourseByIdTest() throws Exception{
        MvcResult result =mockMvc.perform(MockMvcRequestBuilders.get("/eliminar/1"))
                .andExpect(status().isOk()) //check is response status is 200
                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }
}