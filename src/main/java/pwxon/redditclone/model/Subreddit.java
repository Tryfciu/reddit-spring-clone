package pwxon.redditclone.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Subreddit {
    private UUID id;
    private String name;
    private String description;
    private List<Post> posts;
    private Instant createdAt;
    private User users;
}
