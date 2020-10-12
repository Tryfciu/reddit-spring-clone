package pwxon.redditclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private UUID id;
    private VoteType voteType;
    @NotNull
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "postId", referencedColumnName = "id")
    private Post post;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "authorId", referencedColumnName = "id")
    private User author;
}
