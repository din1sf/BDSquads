package com.bosch.app.bdsquads;

import java.util.HashMap;
import java.util.Map;

public class BVNode {
  private String category;
  private String ID;
  private String name;
  private String lead;

  private Map<String, BVNode> children = new HashMap<>();


  private BVNode(Builder builder) {
    this.category = builder.category;
    this.ID = builder.ID;
    this.name = builder.name;
    this.lead = builder.lead;
  }

  public BVNode[] getChildren() {
    return children.values().toArray(new BVNode[0]);
  }


  public static class Builder {
    private String category;
    private String ID;
    private String name;
    private String lead;

    public Builder() {
      // Initialize with default values if needed
    }

    public Builder withCategory(String category) {
      this.category = category;
      return this;
    }

    public Builder withID(String ID) {
      this.ID = ID;
      return this;
    }

    public Builder withName(String name) {
      this.name = name;
      return this;
    }

    public Builder withLead(String lead) {
      this.lead = lead;
      return this;
    }

    public BVNode build() {
      return new BVNode(this);
    }
  }

  public void addChild(BVNode node) {
    children.put(node.getID(), node);
  }

  public BVNode getChild(String ID) {
    return children.get(ID);
  }

  // Getters
  public String getCategory() {
    return category;
  }

  public String getID() {
    return ID;
  }

  public String getName() {
    return name;
  }

  public String getLead() {
    return lead;
  }

  public String info() {
    return "[" + category + "] " + name + " (" + ID + ") / <" + lead + "> " + (!children.isEmpty() ? " / <" + children.size() + ">" : "");
  }

  @Override
  public String toString() {
    return "com.bosch.app.bdsquads.BVNode{" +
        "category='" + category + '\'' +
        ", ID='" + ID + '\'' +
        ", name='" + name + '\'' +
        ", lead='" + lead + '\'' +
        '}';
  }
}
