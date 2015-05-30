package io.swagger.client.model;

import io.swagger.client.model.UnitTag;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Yield  {
  
  private String id = null;
  private Long serves = null;
  private UnitTag unit = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("serves")
  public Long getServes() {
    return serves;
  }
  public void setServes(Long serves) {
    this.serves = serves;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("unit")
  public UnitTag getUnit() {
    return unit;
  }
  public void setUnit(UnitTag unit) {
    this.unit = unit;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Yield {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  serves: ").append(serves).append("\n");
    sb.append("  unit: ").append(unit).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
