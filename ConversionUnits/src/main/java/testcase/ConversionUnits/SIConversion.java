package testcase.ConversionUnits;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SIConversion {

    private String unitSI;
    private Number multiplicationFactor;

    public SIConversion(String unitSI, Number multiplicationFactor) {
        this.unitSI = unitSI;
        this.multiplicationFactor = multiplicationFactor;
    }

    @JsonProperty("multiplication_factor")
    public Number getMultiplicationFactor() {

        return multiplicationFactor;
    }

    public void setMultiplicationFactor(Number multiplicationFactor) {
        this.multiplicationFactor = multiplicationFactor;
    }

    @JsonProperty("unit_name")
    public String getUnitSI() {
        return unitSI;
    }

    public void setUnitSI(String unitSI) {
        this.unitSI = unitSI;
    }

}