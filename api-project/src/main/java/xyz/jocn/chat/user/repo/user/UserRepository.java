package xyz.jocn.chat.user.repo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.jocn.chat.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryExt {
	Optional<UserEntity> findByEmail(String email);

	List<UserEntity> findByIdIn(List<Long> ids);
}
