package pwxon.redditclone.model;

import java.time.Instant;
import java.util.UUID;

public class Comment {
    private UUID id;
    private String comment;
    private Post post;
    private Instant createdAt;
    private User author;
}
