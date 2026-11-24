package banking.model;

import java.io.Serial;
import java.io.Serializable;

public record AuthSession(String token, String username, String fullName, UserRole role) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
