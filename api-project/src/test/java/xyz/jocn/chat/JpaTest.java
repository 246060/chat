package xyz.jocn.chat;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.*;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import xyz.jocn.chat.chat_space.entity.RoomEntity;
import xyz.jocn.chat.user.entity.UserEntity;

@Rollback(false)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class JpaTest {

	@Autowired
	EntityManager em;

	@DisplayName("id 값만 있는 걸로 fk 값이 들어가는지 확인")
	@Test
	void test1() {
		UserEntity user = UserEntity.builder().email("hello@test.com").build();
		em.persist(user);
		em.flush();

		RoomEntity r = RoomEntity.builder().user(new UserEntity(1)).build();
		em.persist(r);
		em.flush();
	}
}