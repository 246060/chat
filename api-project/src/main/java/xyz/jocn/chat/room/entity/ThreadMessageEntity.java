package xyz.jocn.chat.room.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ThreadMessageEntity {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
}