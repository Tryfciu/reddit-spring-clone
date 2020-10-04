package pwxon.redditclone.repository;

import org.springframework.stereotype.Repository;
import pwxon.redditclone.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID>{
}
