package banking.model;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public record AccountSummary(long id, String accountNumber, String accountType, BigDecimal balance, String status)
        implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
