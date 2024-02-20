package com.bosch.app.bdsquads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BVEmployeeNode {
  private String category;
  private String ID;
  private String name;

  private Map<String, BVEmployeeNode> children = new HashMap<>();
  private List<Employee> employeeList = new ArrayList<>();

  private BVEmployeeNode(Builder builder) {
    this.category = builder.category;
    this.ID = builder.ID;
    this.name = builder.name;
  }

  public void addEmployee(Employee employee) {
    employeeList.add(employee);
  }

  public List<Employee> getEmployeeList() {
    return employeeList;
  }

  public BVEmployeeNode[] getChildren() {
    return children.values().toArray(new BVEmployeeNode[0]);
  }


  public static class Builder {
    private String category;
    private String ID;
    private String name;

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

    public BVEmployeeNode build() {
      return new BVEmployeeNode(this);
    }
  }

  public void addChild(BVEmployeeNode node) {
    children.put(node.getID(), node);
  }

  public BVEmployeeNode getChild(String ID) {
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


  public String info() {
    return "[" + category + "] " + name + " (" + ID + ")" + (!children.isEmpty() ? " / <" + children.size() + ">" : "") + (!employeeList.isEmpty() ? " / <" + employeeList.size() + ">" : "");
  }

  @Override
  public String toString() {
    return "com.bosch.app.bdsquads.BVNode{" +
        "category='" + category + '\'' +
        ", ID='" + ID + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
