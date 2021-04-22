package testcase.ConversionUnits;


import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class ConvertUnits {
    private ExpressionParser expressionParser;

    public ConvertUnits() {
        this.expressionParser = new SpelExpressionParser();
    }

    public SIConversion resolve(String unitName) {
        String unit = unit(unitName);
        String equation = equation(unitName);
        Number value = (Number) expressionParser.parseExpression(equation).getValue();

        return new SIConversion(unit, value);

    }


    public static String unit(String unit_name) {

        // NAME

        unit_name = unit_name.replaceAll("degree", "RAD");
        unit_name = unit_name.replaceAll("arcminute", "RAD");
        unit_name = unit_name.replaceAll("arcsecond", "RAD");

        unit_name = unit_name.replaceAll("minute", "s");
        unit_name = unit_name.replaceAll("hour", "s");
        unit_name = unit_name.replaceAll("day", "s");

        unit_name = unit_name.replaceAll("hectare", "m²");

        unit_name = unit_name.replaceAll("litre", "m³");

        unit_name = unit_name.replaceAll("tonne", "kg");

        //SYMBOL

        unit_name = unit_name.replaceAll("ha", "m²");

        unit_name = unit_name.replaceAll("min", "s");
        unit_name = unit_name.replaceAll("h", "s");
        unit_name = unit_name.replaceAll("d", "s");

        unit_name = unit_name.replaceAll("º", "rad");
        unit_name = unit_name.replaceAll("'", "rad");
        unit_name = unit_name.replaceAll("\"", "rad");

        unit_name = unit_name.replaceAll("L", "m³");

        unit_name = unit_name.replaceAll("t", "kg");

        //change RAD to rad, because de "d" replace

        unit_name = unit_name.replaceAll("RAD", "rad");

        return unit_name;
    }

    public static String equation(String equation) {

        double n = Math.PI;
        double degree = (n / 180);
        double arcminute = (n / 10800);
        double arcsecond = (n / 648000);

        DecimalFormat format = new DecimalFormat("0.00000000000000000");
        String degreeStr = format.format(degree);
        String arcminuteStr = format.format(arcminute);
        String arcsecondStr = format.format(arcsecond);

        degreeStr = degreeStr.replaceAll(",", ".");
        arcminuteStr = arcminuteStr.replaceAll(",", ".");
        arcsecondStr = arcsecondStr.replaceAll(",", ".");

        // NAME

        equation = equation.replaceAll("degree", degreeStr);
        equation = equation.replaceAll("arcminute", arcminuteStr);
        equation = equation.replaceAll("arcsecond", arcsecondStr);

        equation = equation.replaceAll("minute", "60.0");
        equation = equation.replaceAll("hour", "3600.0");
        equation = equation.replaceAll("day", "86400.0");

        equation = equation.replaceAll("hectare", "10000.0");

        equation = equation.replaceAll("litre", "0.001");

        equation = equation.replaceAll("tonne", "1000.0");

        //SYMBOL

        equation = equation.replaceAll("ha", "10000.0");

        equation = equation.replaceAll("min", "60.0");
        equation = equation.replaceAll("h", "3600.0");
        equation = equation.replaceAll("d", "86400.0");

        equation = equation.replaceAll("º", degreeStr);
        equation = equation.replaceAll("'", arcminuteStr);
        equation = equation.replaceAll("\"", arcsecondStr);

        equation = equation.replaceAll("L", "0.001");

        equation = equation.replaceAll("t", "1000.0");

        return equation;
    }
}
