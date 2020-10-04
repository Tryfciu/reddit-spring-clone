package pwxon.redditclone.model;

import java.time.Instant;
import java.util.UUID;

public class VerificationToken {
    private UUID id;
    private String token;
    private User user;
    private Instant expireAt;
}
