package pwxon.redditclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "token")
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private UUID id;
    private String token;
    @OneToOne(fetch = LAZY)
    private User user;
    private Instant expireAt;
}
