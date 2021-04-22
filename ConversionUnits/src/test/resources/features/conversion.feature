Feature: testar conversão de diferentes unidades para SI
  Scenario Outline: o cliente deseja converter uma unidade específica para SI
    When o cliente converte de "<unitName>" para SI
    Then o unitSI será igual a "<unitSI>"
    And o multiplicationFactor será igual a <multiplicationFactor>
    Examples:
    |unitName|unitSI|multiplicationFactor|
    |(degree/minute)|(rad/s)|0.00029088820866572163|
    |(minute*minute)|(s*s)|3600.0|
    |(day/min)|(s/s)|1440.0|
    |((litre*ha)-d)|((mÂ³*mÂ²)-s)|-86390.0|
    |(tonne+hectare)|(kg+mÂ²)|11000.0|
    |((tonne/hectare)*d)|((kg/mÂ²)*s)|8640.0|


