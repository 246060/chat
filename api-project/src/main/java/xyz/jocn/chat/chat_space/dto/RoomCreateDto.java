package xyz.jocn.chat.chat_space.dto;

import lombok.Data;

@Data
public class RoomCreateDto {
	private long hostId;
	private long inviteeId;

	public void setHostId(String hostId) {
		setHostId(Integer.parseInt(hostId));
	}

	public void setHostId(long hostId) {
		this.hostId = hostId;
	}
}
