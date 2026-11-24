package banking.model;

import java.io.Serial;
import java.io.Serializable;

public record LoanDecision(boolean approved, String reason) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
