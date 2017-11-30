package ru.dkoty.models;

public class Item {
  private String id;
  private String name;
  private String desc;
  private long create;
  private String[] comments;

  public Item() {
  }
  public Item(String name, String desc, long create) {
    this.name = name;
    this.desc = desc;
    this.create = create;
  }

  public void setName(String name) {
    this.name = name;
  }
  public void setDesc(String desc) {
    this.desc = desc;
  }
  public void setId(String id) {
    this.id = id;
  }
  public void setCreate(long created) {
    this.create = created;
  }
  public void setComments(String[] comments) {
    this.comments = comments;
  }
  public String getName() {
    return this.name;
  }
  public String getDesc() {
    return this.desc;
  }
  public String getId() {
    return this.id;
  }
  public long getCreate() {
    return this.create;
  }
  public String[] getComments() {
    return this.comments;
  }
}

