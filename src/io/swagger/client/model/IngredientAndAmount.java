package io.swagger.client.model;

import io.swagger.client.model.UnitTag;
import io.swagger.client.model.Ingredient;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class IngredientAndAmount  {
  
  private String id = null;
  private Ingredient ingredient = null;
  private Double value = null;
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
  @JsonProperty("ingredient")
  public Ingredient getIngredient() {
    return ingredient;
  }
  public void setIngredient(Ingredient ingredient) {
    this.ingredient = ingredient;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("value")
  public Double getValue() {
    return value;
  }
  public void setValue(Double value) {
    this.value = value;
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
    sb.append("class IngredientAndAmount {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  ingredient: ").append(ingredient).append("\n");
    sb.append("  value: ").append(value).append("\n");
    sb.append("  unit: ").append(unit).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
