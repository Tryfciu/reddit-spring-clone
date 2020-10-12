package pwxon.redditclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.UUID;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private UUID id;
    @NotBlank
    private String title;
    @Nullable
    private String url;
    @Nullable
    @Lob
    private String description;
    private int voteCount;
    @ManyToOne(fetch=LAZY)
    @JoinColumn(name = "authorId", referencedColumnName = "id")
    private User author;
    private Instant createdAt;
    @ManyToOne(fetch=LAZY)
    @JoinColumn(name = "sebredditId", referencedColumnName = "id")
    private Subreddit subreddit;
}
