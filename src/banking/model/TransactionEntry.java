package banking.model;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionEntry(
        long id,
        Long debitAccountId,
        Long creditAccountId,
        BigDecimal amount,
        String transactionType,
        String status,
        String referenceCode,
        String narrative,
        LocalDateTime createdAt) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
