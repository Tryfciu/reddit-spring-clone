package pwxon.redditclone.model;

import java.util.UUID;

public class Vote {
    private UUID id;
    private VoteType voteType;
    private Post post;
    private User author;
}
