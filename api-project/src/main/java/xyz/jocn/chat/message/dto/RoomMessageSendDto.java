package xyz.jocn.chat.message.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import xyz.jocn.chat.message.enums.ChatMessageType;

@Data
public class RoomMessageSendDto {
	private Long userId;
	private ChatMessageType type;
	private Long participantId;
	private Long roomId;
	private List<MultipartFile> files;
	private String message;
}
