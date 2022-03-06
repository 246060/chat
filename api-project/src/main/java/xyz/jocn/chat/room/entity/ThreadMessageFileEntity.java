package xyz.jocn.chat.room.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import xyz.jocn.chat.file.FileEntity;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "thread_message_file")
@Entity
public class ThreadMessageFileEntity {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;

	@CreatedDate
	private Instant createdAt;

	@CreatedBy
	private Instant createdBy;

	@OneToOne
	private FileEntity file;

	@ManyToOne
	private ThreadMessageEntity threadMessage;
}
