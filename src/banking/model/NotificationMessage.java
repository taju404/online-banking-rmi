package banking.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public record NotificationMessage(
        NotificationType type,
        String title,
        String body,
        LocalDateTime createdAt) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
