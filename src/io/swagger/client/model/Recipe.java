package io.swagger.client.model;

import io.swagger.client.model.Note;
import io.swagger.client.model.OvenFan;
import io.swagger.client.model.Author;
import io.swagger.client.model.Yield;
import java.util.*;
import io.swagger.client.model.Step;
import io.swagger.client.model.IngredientAndAmount;
import io.swagger.client.model.SourceBook;
import io.swagger.client.model.OvenTemp;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Recipe  {
  
  private String recipeUuid = null;
  private String recipeName = null;
  private OvenFan ovenFan = null;
  private Long ovenTime = null;
  private OvenTemp ovenTemp = null;
  private List<Yield> yields = new ArrayList<Yield>() ;
  private Note notes = null;
  private SourceBook sourceBook = null;
  private List<Author> sourceAuthors = new ArrayList<Author>() ;
  private String sourceUrl = null;
  private List<Step> steps = new ArrayList<Step>() ;
  private List<IngredientAndAmount> ingredients = new ArrayList<IngredientAndAmount>() ;
  private Long prepTime = null;
  private Long cookingTime = null;
  private Long addedAt = null;
  private String defaultImageUrl = null;
  private Boolean isPrivate = null;

  
  /**
   * Unique identifier representing a specific recipe.
   **/
  @ApiModelProperty(value = "Unique identifier representing a specific recipe.")
  @JsonProperty("recipe_uuid")
  public String getRecipeUuid() {
    return recipeUuid;
  }
  public void setRecipeUuid(String recipeUuid) {
    this.recipeUuid = recipeUuid;
  }

  
  /**
   * Description of product.
   **/
  @ApiModelProperty(value = "Description of product.")
  @JsonProperty("recipe_name")
  public String getRecipeName() {
    return recipeName;
  }
  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("oven_fan")
  public OvenFan getOvenFan() {
    return ovenFan;
  }
  public void setOvenFan(OvenFan ovenFan) {
    this.ovenFan = ovenFan;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("oven_time")
  public Long getOvenTime() {
    return ovenTime;
  }
  public void setOvenTime(Long ovenTime) {
    this.ovenTime = ovenTime;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("oven_temp")
  public OvenTemp getOvenTemp() {
    return ovenTemp;
  }
  public void setOvenTemp(OvenTemp ovenTemp) {
    this.ovenTemp = ovenTemp;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("yields")
  public List<Yield> getYields() {
    return yields;
  }
  public void setYields(List<Yield> yields) {
    this.yields = yields;
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
  @JsonProperty("source_book")
  public SourceBook getSourceBook() {
    return sourceBook;
  }
  public void setSourceBook(SourceBook sourceBook) {
    this.sourceBook = sourceBook;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("source_authors")
  public List<Author> getSourceAuthors() {
    return sourceAuthors;
  }
  public void setSourceAuthors(List<Author> sourceAuthors) {
    this.sourceAuthors = sourceAuthors;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("source_url")
  public String getSourceUrl() {
    return sourceUrl;
  }
  public void setSourceUrl(String sourceUrl) {
    this.sourceUrl = sourceUrl;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("steps")
  public List<Step> getSteps() {
    return steps;
  }
  public void setSteps(List<Step> steps) {
    this.steps = steps;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("ingredients")
  public List<IngredientAndAmount> getIngredients() {
    return ingredients;
  }
  public void setIngredients(List<IngredientAndAmount> ingredients) {
    this.ingredients = ingredients;
  }

  
  /**
   * The time in minutes it takes to prep for a recipe.
   **/
  @ApiModelProperty(value = "The time in minutes it takes to prep for a recipe.")
  @JsonProperty("prep_time")
  public Long getPrepTime() {
    return prepTime;
  }
  public void setPrepTime(Long prepTime) {
    this.prepTime = prepTime;
  }

  
  /**
   * The time in minutes for this recipe to cook.
   **/
  @ApiModelProperty(value = "The time in minutes for this recipe to cook.")
  @JsonProperty("cooking_time")
  public Long getCookingTime() {
    return cookingTime;
  }
  public void setCookingTime(Long cookingTime) {
    this.cookingTime = cookingTime;
  }

  
  /**
   * The timestamp in milliseconds when this was created relative to the unix epoch.
   **/
  @ApiModelProperty(value = "The timestamp in milliseconds when this was created relative to the unix epoch.")
  @JsonProperty("added_at")
  public Long getAddedAt() {
    return addedAt;
  }
  public void setAddedAt(Long addedAt) {
    this.addedAt = addedAt;
  }

  
  /**
   * The header image for a recipe.
   **/
  @ApiModelProperty(value = "The header image for a recipe.")
  @JsonProperty("default_image_url")
  public String getDefaultImageUrl() {
    return defaultImageUrl;
  }
  public void setDefaultImageUrl(String defaultImageUrl) {
    this.defaultImageUrl = defaultImageUrl;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("is_private")
  public Boolean getIsPrivate() {
    return isPrivate;
  }
  public void setIsPrivate(Boolean isPrivate) {
    this.isPrivate = isPrivate;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Recipe {\n");
    
    sb.append("  recipeUuid: ").append(recipeUuid).append("\n");
    sb.append("  recipeName: ").append(recipeName).append("\n");
    sb.append("  ovenFan: ").append(ovenFan).append("\n");
    sb.append("  ovenTime: ").append(ovenTime).append("\n");
    sb.append("  ovenTemp: ").append(ovenTemp).append("\n");
    sb.append("  yields: ").append(yields).append("\n");
    sb.append("  notes: ").append(notes).append("\n");
    sb.append("  sourceBook: ").append(sourceBook).append("\n");
    sb.append("  sourceAuthors: ").append(sourceAuthors).append("\n");
    sb.append("  sourceUrl: ").append(sourceUrl).append("\n");
    sb.append("  steps: ").append(steps).append("\n");
    sb.append("  ingredients: ").append(ingredients).append("\n");
    sb.append("  prepTime: ").append(prepTime).append("\n");
    sb.append("  cookingTime: ").append(cookingTime).append("\n");
    sb.append("  addedAt: ").append(addedAt).append("\n");
    sb.append("  defaultImageUrl: ").append(defaultImageUrl).append("\n");
    sb.append("  isPrivate: ").append(isPrivate).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
