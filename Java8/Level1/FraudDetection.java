import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
class Transaction {
    String transactionId;
    String policyNumber;
    double amount;
    String transactionDate;
    boolean isFraudulent;

    Transaction(String transactionId, String policyNumber, double amount, String transactionDate,
            boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }
}

class FraudAlert {
    String policyNumber;
    int fraudCount;
    double totalFraudAmount;

    FraudAlert(String policyNumber, int fraudCount, double totalFraudAmount) {
        this.policyNumber = policyNumber;
        this.fraudCount = fraudCount;
        this.totalFraudAmount = totalFraudAmount;
    }

    @Override
    public String toString() {
        return policyNumber + " - Fraud Count: " + fraudCount + ", Total Fraud Amount: $" + totalFraudAmount;
    }
}

public class FraudDetection {
    public static List<FraudAlert> detect(List<Transaction> txns) {
        Map<String, List<Transaction>> grouped = txns.stream()
                .filter(t -> t.isFraudulent && t.amount > 10000)
                .collect(Collectors.groupingBy(t -> t.policyNumber));

        return grouped.entrySet().stream()
                .map(e -> {
                    String p = e.getKey();
                    List<Transaction> ts = e.getValue();
                    int count = ts.size();
                    double total = ts.stream().mapToDouble(t -> t.amount).sum();
                    return new FraudAlert(p, count, total);
                })
                .filter(f -> f.fraudCount > 5 || f.totalFraudAmount > 50000)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T001", "P123", 12000, "2024-01-01", true),
                new Transaction("T002", "P123", 13000, "2024-01-02", true),
                new Transaction("T003", "P123", 15000, "2024-01-03", true),
                new Transaction("T004", "P123", 17000, "2024-01-04", true),
                new Transaction("T005", "P123", 14000, "2024-01-05", true),
                new Transaction("T006", "P123", 16000, "2024-01-06", true),
                new Transaction("T007", "P456", 55000, "2024-01-07", true),
                new Transaction("T008", "P789", 8000, "2024-01-08", true),
                new Transaction("T009", "P789", 12000, "2024-01-09", false));

        List<FraudAlert> alerts = detect(transactions);
        alerts.forEach(System.out::println);
    }
}
