package xyz.jocn.chat.chat_space.converter;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import xyz.jocn.chat.chat_space.dto.RoomDto;
import xyz.jocn.chat.chat_space.entity.RoomEntity;
import xyz.jocn.chat.user.entity.UserEntity;

class RoomConverterTest {

	RoomConverter converter = RoomConverter.INSTANCE;

	@DisplayName("RoomDto toDto(RoomEntity entity)")
	@Test
	void toDto() {
		// given
		Long userId = 1L;
		Long roomId = 100L;

		RoomEntity room =
			RoomEntity.builder()
				.id(roomId)
				.user(new UserEntity(userId))
				.build();

		// when
		RoomDto roomDto = converter.toDto(room);
		System.out.println("roomDto = " + roomDto);

		// then
		assertThat(roomDto).extracting(RoomDto::getRoomId).isEqualTo(roomId);
	}
}