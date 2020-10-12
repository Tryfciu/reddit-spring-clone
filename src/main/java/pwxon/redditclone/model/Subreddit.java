package pwxon.redditclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subreddit {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @OneToMany(fetch = LAZY)
    private List<Post> posts;
    private Instant createdAt;
    @ManyToOne(fetch = LAZY)
    private User users;
}
