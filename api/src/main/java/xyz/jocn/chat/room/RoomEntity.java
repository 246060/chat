package xyz.jocn.chat.room;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoomEntity {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
}
