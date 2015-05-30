package io.swagger.client.model;


import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class HACCP  {
  
  private String criticalControlPoint = null;
  private String controlPoint = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("critical_control_point")
  public String getCriticalControlPoint() {
    return criticalControlPoint;
  }
  public void setCriticalControlPoint(String criticalControlPoint) {
    this.criticalControlPoint = criticalControlPoint;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("control_point")
  public String getControlPoint() {
    return controlPoint;
  }
  public void setControlPoint(String controlPoint) {
    this.controlPoint = controlPoint;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class HACCP {\n");
    
    sb.append("  criticalControlPoint: ").append(criticalControlPoint).append("\n");
    sb.append("  controlPoint: ").append(controlPoint).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
