package com.bosch.app.bdsquads;

public class Employee {
  // Fields
  private final String associateGID;
  private final String firstName;
  private final String lastName;
  private final String bvPlus1Category;
  private final String bvPlus1ID;
  private final String bvPlus1Name;
  private final String bvPlus2Category;
  private final String bvPlus2ID;
  private final String bvPlus2Name;
  private final String bvPlus3Category;
  private final String bvPlus3ID;
  private final String bvPlus3Name;
  private final String profileCategory;
  private final String functionalProfile;
  private final String requestedOrAvailable;
  private final String requestSquad1;
  private final String requestSquad2;
  private final String requestSquad3;

  // Private constructor to enforce object creation through builder
  private Employee(Builder builder) {
    this.associateGID = builder.associateGID;
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.bvPlus1Category = builder.bvPlus1Category;
    this.bvPlus1ID = builder.bvPlus1ID;
    this.bvPlus1Name = builder.bvPlus1Name;
    this.bvPlus2Category = builder.bvPlus2Category;
    this.bvPlus2ID = builder.bvPlus2ID;
    this.bvPlus2Name = builder.bvPlus2Name;
    this.bvPlus3Category = builder.bvPlus3Category;
    this.bvPlus3ID = builder.bvPlus3ID;
    this.bvPlus3Name = builder.bvPlus3Name;
    this.profileCategory = builder.profileCategory;
    this.functionalProfile = builder.functionalProfile;
    this.requestedOrAvailable = builder.requestedOrAvailable;
    this.requestSquad1 = builder.requestSquad1;
    this.requestSquad2 = builder.requestSquad2;
    this.requestSquad3 = builder.requestSquad3;
  }

  // Getter methods

  public String getAssociateGID() {
    return associateGID;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getBvPlus1Category() {
    return bvPlus1Category;
  }

  public String getBvPlus1ID() {
    return bvPlus1ID;
  }

  public String getBvPlus1Name() {
    return bvPlus1Name;
  }

  public String getBvPlus2Category() {
    return bvPlus2Category;
  }

  public String getBvPlus2ID() {
    return bvPlus2ID;
  }

  public String getBvPlus2Name() {
    return bvPlus2Name;
  }

  public String getBvPlus3Category() {
    return bvPlus3Category;
  }

  public String getBvPlus3ID() {
    return bvPlus3ID;
  }

  public String getBvPlus3Name() {
    return bvPlus3Name;
  }

  public String getProfileCategory() {
    return profileCategory;
  }

  public String getFunctionalProfile() {
    return functionalProfile;
  }

  public String getRequestedOrAvailable() {
    return requestedOrAvailable;
  }

  public String getRequestSquad1() {
    return requestSquad1;
  }

  public String getRequestSquad2() {
    return requestSquad2;
  }

  public String getRequestSquad3() {
    return requestSquad3;
  }

  public String toString() {
    return "com.bosch.app.bdsquads.Employee{" +
        "associateGID='" + associateGID + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", bvPlus1Category='" + bvPlus1Category + '\'' +
        ", bvPlus1ID='" + bvPlus1ID + '\'' +
        ", bvPlus1Name='" + bvPlus1Name + '\'' +
        ", bvPlus2Category='" + bvPlus2Category + '\'' +
        ", bvPlus2ID='" + bvPlus2ID + '\'' +
        ", bvPlus2Name='" + bvPlus2Name + '\'' +
        ", bvPlus3Category='" + bvPlus3Category + '\'' +
        ", bvPlus3ID='" + bvPlus3ID + '\'' +
        ", bvPlus3Name='" + bvPlus3Name + '\'' +
        ", profileCategory='" + profileCategory + '\'' +
        ", functionalProfile='" + functionalProfile + '\'' +
        ", requestedOrAvailable='" + requestedOrAvailable + '\'' +
        ", requestSquad1='" + requestSquad1 + '\'' +
        ", requestSquad2='" + requestSquad2 + '\'' +
        ", requestSquad3='" + requestSquad3 + '\'' +
        '}';
  }

  // Builder class
  public static class Builder {
    // Fields
    private String associateGID;
    private String firstName;
    private String lastName;
    private String bvPlus1Category;
    private String bvPlus1ID;
    private String bvPlus1Name;
    private String bvPlus2Category;
    private String bvPlus2ID;
    private String bvPlus2Name;
    private String bvPlus3Category;
    private String bvPlus3ID;
    private String bvPlus3Name;
    private String profileCategory;
    private String functionalProfile;
    private String requestedOrAvailable;
    private String requestSquad1;
    private String requestSquad2;
    private String requestSquad3;

    // Constructor with required fields
    public Builder(String associateGID, String firstName, String lastName) {
      this.associateGID = associateGID;
      this.firstName = firstName;
      this.lastName = lastName;
    }

    // Setters for optional fields

    public Builder bvPlus1Category(String bvPlus1Category) {
      this.bvPlus1Category = bvPlus1Category;
      return this;
    }

    public Builder bvPlus1ID(String bvPlus1ID) {
      this.bvPlus1ID = bvPlus1ID;
      return this;
    }

    public Builder bvPlus1Name(String bvPlus1Name) {
      this.bvPlus1Name = bvPlus1Name;
      return this;
    }

    public Builder bvPlus2Category(String bvPlus2Category) {
      this.bvPlus2Category = bvPlus2Category;
      return this;
    }

    public Builder bvPlus2ID(String bvPlus2ID) {
      this.bvPlus2ID = bvPlus2ID;
      return this;
    }

    public Builder bvPlus2Name(String bvPlus2Name) {
      this.bvPlus2Name = bvPlus2Name;
      return this;
    }

    public Builder bvPlus3Category(String bvPlus3Category) {
      this.bvPlus3Category = bvPlus3Category;
      return this;
    }

    public Builder bvPlus3ID(String bvPlus3ID) {
      this.bvPlus3ID = bvPlus3ID;
      return this;
    }

    public Builder bvPlus3Name(String bvPlus3Name) {
      this.bvPlus3Name = bvPlus3Name;
      return this;
    }

    public Builder profileCategory(String profileCategory) {
      this.profileCategory = profileCategory;
      return this;
    }

    public Builder functionalProfile(String functionalProfile) {
      this.functionalProfile = functionalProfile;
      return this;
    }

    public Builder requestedOrAvailable(String requestedOrAvailable) {
      this.requestedOrAvailable = requestedOrAvailable;
      return this;
    }

    public Builder requestSquad1(String requestSquad1) {
      this.requestSquad1 = requestSquad1;
      return this;
    }

    public Builder requestSquad2(String requestSquad2) {
      this.requestSquad2 = requestSquad2;
      return this;
    }

    public Builder requestSquad3(String requestSquad3) {
      this.requestSquad3 = requestSquad3;
      return this;
    }

    // Build method to create com.bosch.app.bdsquads.Employee instance
    public Employee build() {
      return new Employee(this);
    }
  }
}
