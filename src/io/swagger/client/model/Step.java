package io.swagger.client.model;

import io.swagger.client.model.HACCP;
import io.swagger.client.model.Note;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Step  {
  
  private String id = null;
  private String stepDetails = null;
  private HACCP haccp = null;
  private Note notes = null;
  private Integer order = null;

  
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
  @JsonProperty("step_details")
  public String getStepDetails() {
    return stepDetails;
  }
  public void setStepDetails(String stepDetails) {
    this.stepDetails = stepDetails;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("haccp")
  public HACCP getHaccp() {
    return haccp;
  }
  public void setHaccp(HACCP haccp) {
    this.haccp = haccp;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("notes")
  public Note getNotes() {
    return notes;
  }
  public void setNotes(Note notes) {
    this.notes = notes;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("order")
  public Integer getOrder() {
    return order;
  }
  public void setOrder(Integer order) {
    this.order = order;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Step {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  stepDetails: ").append(stepDetails).append("\n");
    sb.append("  haccp: ").append(haccp).append("\n");
    sb.append("  notes: ").append(notes).append("\n");
    sb.append("  order: ").append(order).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
