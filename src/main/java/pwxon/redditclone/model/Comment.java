package pwxon.redditclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.UUID;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private UUID id;
    @NotEmpty
    private String comment;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "postId", referencedColumnName = "id")
    private Post post;
    private Instant createdAt;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "authorId", referencedColumnName = "id")
    private User author;
}
