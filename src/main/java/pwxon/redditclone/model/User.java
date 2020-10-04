package pwxon.redditclone.model;

import java.time.Instant;
import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private String password;
    private String email;
    private Instant createdAt;
    private boolean enabled;
}
