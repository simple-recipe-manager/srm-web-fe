package io.swagger.client.model;


import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class UnitTag  {
  
  private String id = null;
  private String tag = null;
  private String multipleTag = null;

  
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
  @JsonProperty("tag")
  public String getTag() {
    return tag;
  }
  public void setTag(String tag) {
    this.tag = tag;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("multipleTag")
  public String getMultipleTag() {
    return multipleTag;
  }
  public void setMultipleTag(String multipleTag) {
    this.multipleTag = multipleTag;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnitTag {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  tag: ").append(tag).append("\n");
    sb.append("  multipleTag: ").append(multipleTag).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
