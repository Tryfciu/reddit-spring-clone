package pwxon.redditclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwxon.redditclone.model.User;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
