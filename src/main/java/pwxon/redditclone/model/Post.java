package pwxon.redditclone.model;

import java.time.Instant;
import java.util.UUID;

public class Post {
    private UUID id;
    private String title;
    private String description;
    private int voteCount;
    private User author;
    private Instant createdAt;
    private Subreddit subreddit;
}
