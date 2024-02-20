import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeParser {

  public static List<Employee> parseEmployees() {
    String csvFilePath = "employees.csv";
    System.out.println("Parsing employees from: " + new File(csvFilePath).getAbsolutePath());

    List<Employee> employees = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
      String line;
      boolean isFirstLine = true;
      while ((line = br.readLine()) != null) {
        String[] values = line.split(";");

        if (isFirstLine) {
          isFirstLine = false;
          continue;
        }

        if (values.length < 8) {
          System.err.println("Invalid line: " + line);
          continue;
        }

        for (int i = 0; i < values.length; i++) {
          values[i] = values[i].trim();
        }

        // Create Employee.Builder instance
        Employee.Builder builder = new Employee.Builder(values[0], values[1], values[2]);

        // Set optional fields
        builder.bvPlus1Category(values[3])
            .bvPlus1ID(values[4])
            .bvPlus1Name(values[5])
            .bvPlus2Category(values[6])
            .bvPlus2ID(values[7])
            .bvPlus2Name(values[8]);

        // If there are more values than 8, set additional fields
        if (values.length > 9) {
          builder.bvPlus3Category(values[9]);
        }
        if (values.length > 10) {
          builder.bvPlus3ID(values[10]);
        }
        if (values.length > 11) {
          builder.bvPlus3Name(values[11]);
        }
        if (values.length > 12) {
          builder.profileCategory(values[12]);
        }
        if (values.length > 13) {
          builder.functionalProfile(values[13]);
        }
        if (values.length > 14) {
          builder.requestedOrAvailable(values[14]);
        }
        if (values.length > 15) {
          builder.requestSquad1(values[15]);
        }
        // Build Employee object and add to list
        employees.add(builder.build());
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
    return employees;
  }

  public static BVEmployeeNode createBV1Node(Employee employee) {
    return new BVEmployeeNode.Builder()
        .withName(employee.getBvPlus1Name())
        .withID(employee.getBvPlus1ID())
        .withCategory(employee.getBvPlus1Category())
        .build();
  }

  public static BVEmployeeNode createBV2Node(Employee employee) {
    return new BVEmployeeNode.Builder()
        .withName(employee.getBvPlus2Name())
        .withID(employee.getBvPlus2ID())
        .withCategory(employee.getBvPlus2Category())
        .build();
  }

  public static BVEmployeeNode createBV3Node(Employee employee) {
    return new BVEmployeeNode.Builder()
        .withName(employee.getBvPlus3Name())
        .withID(employee.getBvPlus3ID())
        .withCategory(employee.getBvPlus3Category())
        .build();
  }

  public static BVEmployeeNode buildBVTree(List<Employee> list) {
    BVEmployeeNode root = new BVEmployeeNode.Builder().withCategory("root").withName("root").withID("root").build();

    for (Employee employee : list) {
      BVEmployeeNode bv1Node = Optional.ofNullable(root.getChild(employee.getBvPlus1ID()))
          .orElseGet(() -> createBV1Node(employee));
      root.addChild(bv1Node);

      BVEmployeeNode bv2Node = Optional.ofNullable(bv1Node.getChild(employee.getBvPlus2ID()))
          .orElseGet(() -> createBV2Node(employee));
      bv1Node.addChild(bv2Node);

      if (employee.getBvPlus3ID() != null && !employee.getBvPlus3ID().isEmpty()) {
        BVEmployeeNode bv3Node = Optional.ofNullable(bv2Node.getChild(employee.getBvPlus3ID()))
            .orElseGet(() -> createBV3Node(employee));
        bv3Node.addEmployee(employee);
        bv2Node.addChild(bv3Node);

      } else {
        bv2Node.addEmployee(employee);
      }
    }
    return root;
  }


  public static void dumpBVTree(BVEmployeeNode node, int level, boolean printEmployees) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < level; i++) {
      System.out.print("  ");
      sb.append("  ");
    }
    String indent = sb.toString();;
    if (level == 1) System.out.println(" ");

    System.out.println(node.info());

    if (printEmployees) {
      for (Employee emp : node.getEmployeeList()) {
        System.out.println(indent + "   " + emp.getAssociateGID() + " " + emp.getFirstName()  + " " + emp.getLastName() + " " + emp.getRequestSquad1());
      }
    }

    for (BVEmployeeNode child : node.getChildren()) {
      dumpBVTree(child, level + 1, printEmployees);
    }
  }

  public static void main(String[] args) {
    List<Employee> employees = parseEmployees();
    System.out.println("Employees: " + employees.size());

    List<Employee> list = employees.stream()
//        .filter(e -> e.getBvPlus1ID().equals("ALX-EST"))
//        .filter(e -> e.getBvPlus1Category().equals("Domain"))
//        .filter(e -> e.getBvPlus1Category().equals("Alliance"))
//        .filter(e -> e.getBvPlus1ID().equals("Domain_SoftwareEngineering"))
//        .filter(e -> e.getBvPlus2Name().equals("Backend Development 1"))
//        .filter(e -> e.getRequestSquad1().equals("ALX-MOB_T02_Sq134"))
        .filter(e -> e.getRequestSquad1().equals("ALX-TRC_T10_Sq157"))

        .collect(Collectors.toList());

//    // Print or process the list of employees
//    for (Employee emp : list) {
//      System.out.println(emp);
//    }

    BVEmployeeNode node = buildBVTree(list);
    dumpBVTree(node, 0, true);

    System.out.println("List: " + list.size());
  }
}
