package io.swagger.client.model;

import io.swagger.client.model.Ingredient;
import io.swagger.client.model.Note;
import java.util.*;
import io.swagger.client.model.ProcessingTag;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Ingredient  {
  
  private String id = null;
  private String name = null;
  private String usdaNum = null;
  private List<Ingredient> substitutions = new ArrayList<Ingredient>() ;
  private Note note = null;
  private List<ProcessingTag> processingTags = new ArrayList<ProcessingTag>() ;

  
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
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("usda_num")
  public String getUsdaNum() {
    return usdaNum;
  }
  public void setUsdaNum(String usdaNum) {
    this.usdaNum = usdaNum;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("substitutions")
  public List<Ingredient> getSubstitutions() {
    return substitutions;
  }
  public void setSubstitutions(List<Ingredient> substitutions) {
    this.substitutions = substitutions;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("note")
  public Note getNote() {
    return note;
  }
  public void setNote(Note note) {
    this.note = note;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("processingTags")
  public List<ProcessingTag> getProcessingTags() {
    return processingTags;
  }
  public void setProcessingTags(List<ProcessingTag> processingTags) {
    this.processingTags = processingTags;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ingredient {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  usdaNum: ").append(usdaNum).append("\n");
    sb.append("  substitutions: ").append(substitutions).append("\n");
    sb.append("  note: ").append(note).append("\n");
    sb.append("  processingTags: ").append(processingTags).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
