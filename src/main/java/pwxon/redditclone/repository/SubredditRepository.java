package pwxon.redditclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwxon.redditclone.model.Subreddit;
import java.util.UUID;

@Repository
public interface SubredditRepository extends JpaRepository<Subreddit, UUID> {
}
