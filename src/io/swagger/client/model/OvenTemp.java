package io.swagger.client.model;

import io.swagger.client.model.TemperatureUnit;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class OvenTemp  {
  
  private Long value = null;
  private TemperatureUnit unit = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("value")
  public Long getValue() {
    return value;
  }
  public void setValue(Long value) {
    this.value = value;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("unit")
  public TemperatureUnit getUnit() {
    return unit;
  }
  public void setUnit(TemperatureUnit unit) {
    this.unit = unit;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class OvenTemp {\n");
    
    sb.append("  value: ").append(value).append("\n");
    sb.append("  unit: ").append(unit).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
