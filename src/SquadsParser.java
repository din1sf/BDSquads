import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SquadsParser {

  private static List<SquadInfo> parseSquads(String csvFile) {
    List<SquadInfo> dataList = new ArrayList<>();
    System.out.println("Reading squads: " + new File(csvFile).getAbsolutePath());

    try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(";");
        if (parts.length >= 8) { // Ensure correct number of columns
          String bv3ID = parts.length > 8 ? parts[8].trim() : "";
          String bv3Lead = parts.length > 9 ? parts[9].trim() : "";
          String bv3Name = parts.length > 10 ? parts[10].trim() : "";
          SquadInfo data = new SquadInfo.Builder()
              .withBv1Category(parts[0].trim())
              .withBv1Name(parts[1].trim())
              .withBv1ID(parts[2].trim())
              .withBv1Lead(parts[3].trim())
              .withBv2Category(parts[4].trim())
              .withBv2Name(parts[5].trim())
              .withBv2ID(parts[6].trim())
              .withBv2Lead(parts[7].trim())
              .withBv3ID(bv3ID)
              .withBv3Lead(bv3Lead)
              .withBv3Name(bv3Name)
              .build();
          dataList.add(data);
        } else {
          if (parts.length > 6) {
            System.out.println("Skipping invalid line: (" + parts.length + ") " + line);
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("Squads read: " + dataList.size());
    return dataList;
  }

  public static BVNode createBV1Node(SquadInfo squadInfo) {
    return new BVNode.Builder()
        .withName(squadInfo.getBv1Name())
        .withID(squadInfo.getBv1ID())
        .withLead(squadInfo.getBv1Lead())
        .withCategory(squadInfo.getBv1Category())
        .build();
  }

  public static BVNode createBV2Node(SquadInfo squadInfo) {
    return new BVNode.Builder()
        .withName(squadInfo.getBv2Name())
        .withID(squadInfo.getBv2ID())
        .withLead(squadInfo.getBv2Lead())
        .withCategory(squadInfo.getBv2Category())
        .build();
  }

  public static BVNode createBV3Node(SquadInfo squadInfo) {
    return new BVNode.Builder()
        .withName(squadInfo.getBv3Name())
        .withID(squadInfo.getBv3ID())
        .withLead(squadInfo.getBv3Lead())
        .withCategory("Squad")
        .build();
  }

  public static BVNode buildBVTree(List<SquadInfo> list) {
    BVNode root = new BVNode.Builder().withCategory("root").withName("root").withID("root").build();

    for (SquadInfo squadInfo : list) {
      BVNode bv1Node = Optional.ofNullable(root.getChild(squadInfo.getBv1ID()))
          .orElseGet(() -> createBV1Node(squadInfo));
      root.addChild(bv1Node);

      BVNode bv2Node = Optional.ofNullable(bv1Node.getChild(squadInfo.getBv2ID()))
          .orElseGet(() -> createBV2Node(squadInfo));
      bv1Node.addChild(bv2Node);

      if (squadInfo.getBv3ID() != null && !squadInfo.getBv3ID().isEmpty()) {
        BVNode bv3Node = Optional.ofNullable(bv2Node.getChild(squadInfo.getBv3ID()))
            .orElseGet(() -> createBV3Node(squadInfo));
        bv2Node.addChild(bv3Node);
      }
    }
    return root;
  }

  public static void dumpBVTree(BVNode node, int level) {
    for (int i = 0; i < level; i++) {
      System.out.print("  ");
    }
    if (level == 1) System.out.println(" ");

    System.out.println(node.info());
    for (BVNode child : node.getChildren()) {
      dumpBVTree(child, level + 1);
    }
  }

  public static void main(String[] args) {
    List<SquadInfo> dataList = parseSquads("squads.csv");

    // filtered
    List<SquadInfo> list = dataList.stream()
        // .filter(s -> s.getBv1ID() != null && !s.getBv1ID().isEmpty())
//        .filter(s -> s.getBv2ID().equals("ALX-MOB_T02"))
        // .filter(s -> s.getBv3ID().equals("ALX-MOB_T02_Sq134"))
        .collect(Collectors.toList());

    // tree structure
    BVNode root = buildBVTree(list);
    dumpBVTree(root, 0);
  }
}
