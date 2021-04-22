package testcase.ConversionUnits;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@CucumberContextConfiguration
@SpringBootTest
@AutoConfigureMockMvc
public class CucumberSteps {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private SIConversion siConversion;

    @When("o cliente converte de {string} para SI")
    public void whenClientRequestsConversion(String unitName) throws Exception {
        ResultActions units = this.mockMvc.perform(MockMvcRequestBuilders.get("/units/si").queryParam("units", unitName));
        String responseJSON = units.andExpect(status().is(200)).andReturn().getResponse().getContentAsString();
        siConversion = objectMapper.readValue(responseJSON, SIConversion.class);
    }

    @Then("o unitSI será igual a {string}")
    public void thenConvertedUnitIs(String expectedUnitSI) {
        Assert.assertEquals(expectedUnitSI, this.siConversion.getUnitSI());
    }

    @Then("o multiplicationFactor será igual a {double}")
    public void thenMultiplicationFactorIs(Double expectedMultiplicationFactor) {
        Assert.assertEquals(expectedMultiplicationFactor, this.siConversion.getMultiplicationFactor());
    }
}