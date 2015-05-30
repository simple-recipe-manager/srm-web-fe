package io.swagger.client.model;

import io.swagger.client.model.Note;
import io.swagger.client.model.Author;
import java.util.*;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class SourceBook  {
  
  private String id = null;
  private List<Author> authors = new ArrayList<Author>() ;
  private String title = null;
  private String ISBN = null;
  private Note notes = null;

  
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
  @JsonProperty("authors")
  public List<Author> getAuthors() {
    return authors;
  }
  public void setAuthors(List<Author> authors) {
    this.authors = authors;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("ISBN")
  public String getISBN() {
    return ISBN;
  }
  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
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

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceBook {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  authors: ").append(authors).append("\n");
    sb.append("  title: ").append(title).append("\n");
    sb.append("  ISBN: ").append(ISBN).append("\n");
    sb.append("  notes: ").append(notes).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
