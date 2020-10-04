package pwxon.redditclone.model;

import java.time.Instant;
import java.util.UUID;

public class Post {
    private UUID postId;
    private String title;
    private String description;
    private int voteCount;
    private User author;
    private Instant creationDate;
    private Subredit subredit;
}
