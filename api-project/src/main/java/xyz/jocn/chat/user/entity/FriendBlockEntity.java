package xyz.jocn.chat.user.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "firend_block")
@Entity
public class FriendBlockEntity {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;

	@CreatedDate
	private Instant createdAt;

	@ManyToOne
	private UserEntity user;

	@ManyToOne
	private UserEntity blockedUser;
}
