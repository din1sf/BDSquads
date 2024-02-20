public class SquadInfo {

  private String bv1Category;
  private String bv1Name;
  private String bv1ID;
  private String bv1Lead;
  private String bv2Category;
  private String bv2Name;
  private String bv2ID;
  private String bv2Lead;
  private String bv3ID;
  private String bv3Lead;
  private String bv3Name;
  private String bv3Mission;
  private String bv3Activities;
  private String ownedPSOrSolutions;

  private SquadInfo(Builder builder) {
    this.bv1Category = builder.bv1Category;
    this.bv1Name = builder.bv1Name;
    this.bv1ID = builder.bv1ID;
    this.bv1Lead = builder.bv1Lead;
    this.bv2Category = builder.bv2Category;
    this.bv2Name = builder.bv2Name;
    this.bv2ID = builder.bv2ID;
    this.bv2Lead = builder.bv2Lead;
    this.bv3ID = builder.bv3ID;
    this.bv3Lead = builder.bv3Lead;
    this.bv3Name = builder.bv3Name;
    this.bv3Mission = builder.bv3Mission;
    this.bv3Activities = builder.bv3Activities;
    this.ownedPSOrSolutions = builder.ownedPSOrSolutions;
  }

  // Getters for all fields
  public String getBv1Category() {
    return bv1Category;
  }

  public String getBv1Name() {
    return bv1Name;
  }

  public String getBv1ID() {
    return bv1ID;
  }

  public String getBv1Lead() {
    return bv1Lead;
  }

  public String getBv2Category() {
    return bv2Category;
  }

  public String getBv2Name() {
    return bv2Name;
  }

  public String getBv2ID() {
    return bv2ID;
  }

  public String getBv2Lead() {
    return bv2Lead;
  }

  public String getBv3ID() {
    return bv3ID;
  }

  public String getBv3Lead() {
    return bv3Lead;
  }

  public String getBv3Name() {
    return bv3Name;
  }

  public String getBv3Mission() {
    return bv3Mission;
  }

  public String getBv3Activities() {
    return bv3Activities;
  }

  public String getOwnedPSOrSolutions() {
    return ownedPSOrSolutions;
  }

  public static class Builder {

    private String bv1Category;
    private String bv1Name;
    private String bv1ID;
    private String bv1Lead;
    private String bv2Category;
    private String bv2Name;
    private String bv2ID;
    private String bv2Lead;
    private String bv3ID;
    private String bv3Lead;
    private String bv3Name;
    private String bv3Mission;
    private String bv3Activities;
    private String ownedPSOrSolutions;

    public Builder withBv1Category(String bv1Category) {
      this.bv1Category = bv1Category;
      return this;
    }

    public Builder withBv1Name(String bv1Name) {
      this.bv1Name = bv1Name;
      return this;
    }

    public Builder withBv1ID(String bv1ID) {
      this.bv1ID = bv1ID;
      return this;
    }

    public Builder withBv1Lead(String bv1Lead) {
      this.bv1Lead = bv1Lead;
      return this;
    }

    public Builder withBv2Category(String bv2Category) {
      this.bv2Category = bv2Category;
      return this;
    }

    public Builder withBv2Name(String bv2Name) {
      this.bv2Name = bv2Name;
      return this;
    }

    public Builder withBv2ID(String bv2ID) {
      this.bv2ID = bv2ID;
      return this;
    }

    public Builder withBv2Lead(String bv2Lead) {
      this.bv2Lead = bv2Lead;
      return this;
    }

    public Builder withBv3ID(String bv3ID) {
      this.bv3ID = bv3ID;
      return this;
    }

    public Builder withBv3Lead(String bv3Lead) {
      this.bv3Lead = bv3Lead;
      return this;
    }

    public Builder withBv3Name(String bv3Name) {
      this.bv3Name = bv3Name;
      return this;
    }

    public Builder withBv3Mission(String bv3Mission) {
      this.bv3Mission = bv3Mission;
      return this;
    }

    public Builder withBv3Activities(String bv3Activities) {
      this.bv3Activities = bv3Activities;
      return this;
    }

    public Builder withOwnedPSOrSolutions(String ownedPSOrSolutions) {
      this.ownedPSOrSolutions = ownedPSOrSolutions;
      return this;
    }

    public SquadInfo build() {
      return new SquadInfo(this);
    }
  }

  @Override
  public String toString() {
    return "SquadInfo{" +
        "bv1Category='" + bv1Category + '\'' +
        ", bv1Name='" + bv1Name + '\'' +
        ", bv1ID='" + bv1ID + '\'' +
        ", bv1Lead='" + bv1Lead + '\'' +
        ", bv2Category='" + bv2Category + '\'' +
        ", bv2Name='" + bv2Name + '\'' +
        ", bv2ID='" + bv2ID + '\'' +
        ", bv2Lead='" + bv2Lead + '\'' +
        ", bv3ID='" + bv3ID + '\'' +
        ", bv3Lead='" + bv3Lead + '\'' +
        ", bv3Name='" + bv3Name + '\'' +
        ", bv3Mission='" + bv3Mission + '\'' +
        ", bv3Activities='" + bv3Activities + '\'' +
        ", ownedPSOrSolutions='" + ownedPSOrSolutions + '\'' +
        '}';
  }
}