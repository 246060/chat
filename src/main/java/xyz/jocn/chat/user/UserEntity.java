package xyz.jocn.chat.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserEntity {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
}