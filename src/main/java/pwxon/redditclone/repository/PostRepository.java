package pwxon.redditclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwxon.redditclone.model.Post;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

}
