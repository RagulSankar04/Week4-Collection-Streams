import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
class Claim {
    String claimId;
    String policyNumber;
    double claimAmount;
    String claimDate;
    String status;

    Claim(String claimId, String policyNumber, double claimAmount, String claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }
}

class PolicyClaimSummary {
    String policyNumber;
    double totalClaimAmount;
    double averageClaimAmount;

    PolicyClaimSummary(String policyNumber, double totalClaimAmount, double averageClaimAmount) {
        this.policyNumber = policyNumber;
        this.totalClaimAmount = totalClaimAmount;
        this.averageClaimAmount = averageClaimAmount;
    }

    @Override
    public String toString() {
        return policyNumber + " - Total: $" + totalClaimAmount + ", Average: $" + averageClaimAmount;
    }
}

public class ClaimsAnalysis {
    public static List<PolicyClaimSummary> analyze(List<Claim> claims) {
        Map<String, List<Claim>> grouped = claims.stream()
                .filter(c -> c.status.equals("Approved") && c.claimAmount > 5000)
                .collect(Collectors.groupingBy(c -> c.policyNumber));

        return grouped.entrySet().stream()
                .map(e -> {
                    String p = e.getKey();
                    List<Claim> cs = e.getValue();
                    double total = cs.stream().mapToDouble(c -> c.claimAmount).sum();
                    double avg = total / cs.size();
                    return new PolicyClaimSummary(p, total, avg);
                })
                .sorted(Comparator.comparingDouble(s -> -s.totalClaimAmount))
                .limit(3)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C101", "P001", 7000, "2024-01-01", "Approved"),
                new Claim("C102", "P002", 12000, "2024-01-05", "Approved"),
                new Claim("C103", "P001", 6000, "2024-01-10", "Approved"),
                new Claim("C104", "P003", 4000, "2024-01-12", "Rejected"),
                new Claim("C105", "P002", 8000, "2024-01-15", "Approved"),
                new Claim("C106", "P004", 10000, "2024-01-18", "Approved"),
                new Claim("C107", "P005", 5500, "2024-01-20", "Approved"),
                new Claim("C108", "P001", 4500, "2024-01-22", "Approved"),
                new Claim("C109", "P004", 12000, "2024-01-25", "Approved"));

        List<PolicyClaimSummary> result = analyze(claims);
        result.forEach(System.out::println);
    }
}
