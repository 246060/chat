package xyz.jocn.chat.user.repo.friend_block;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.jocn.chat.user.entity.FriendBlockEntity;

@Repository
public interface FriendBlockRepository extends JpaRepository<FriendBlockEntity, Long>, FriendBlockRepositoryExt {
}
