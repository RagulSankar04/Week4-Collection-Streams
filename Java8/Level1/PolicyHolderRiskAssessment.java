import java.util.*;
import java.util.stream.Collectors;

class PolicyHolder {
    String holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
}

class RiskAssessment {
    String holderId;
    String name;
    double riskScore;

    RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    @Override
    public String toString() {
        return holderId + " - " + name + " (Risk Score: " + riskScore + ")";
    }
}

public class PolicyHolderRiskAssessment {
    public static Map<String, List<RiskAssessment>> assess(List<PolicyHolder> holders) {
        return holders.stream()
                .filter(h -> h.policyType.equals("Life") && h.age > 60)
                .map(h -> new RiskAssessment(h.holderId, h.name, h.premiumAmount / h.age))
                .sorted((a, b) -> Double.compare(b.riskScore, a.riskScore))
                .collect(Collectors.groupingBy(r -> r.riskScore > 0.5 ? "High Risk" : "Low Risk"));
    }

    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder("H001", "Alice", 65, "Life", 40000),
                new PolicyHolder("H002", "Bob", 70, "Life", 25000),
                new PolicyHolder("H003", "Charlie", 61, "Health", 30000),
                new PolicyHolder("H004", "David", 75, "Life", 20000),
                new PolicyHolder("H005", "Eve", 80, "Life", 30000));

        Map<String, List<RiskAssessment>> result = assess(holders);
        result.forEach((risk, list) -> {
            System.out.println(risk + ":");
            list.forEach(System.out::println);
        });
    }
}
