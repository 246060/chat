package xyz.jocn.chat.participant.service;

import static xyz.jocn.chat.common.enums.ResourceType.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import xyz.jocn.chat.chat_space.entity.RoomEntity;
import xyz.jocn.chat.chat_space.entity.ThreadEntity;
import xyz.jocn.chat.chat_space.repo.room.RoomRepository;
import xyz.jocn.chat.chat_space.repo.thread.ThreadRepository;
import xyz.jocn.chat.common.exception.ResourceNotFoundException;
import xyz.jocn.chat.participant.converter.RoomParticipantConverter;
import xyz.jocn.chat.participant.dto.RoomExitDto;
import xyz.jocn.chat.participant.dto.RoomInviteRequestDto;
import xyz.jocn.chat.participant.dto.RoomParticipantDto;
import xyz.jocn.chat.participant.entity.RoomParticipantEntity;
import xyz.jocn.chat.participant.repo.room_participant.RoomParticipantRepository;
import xyz.jocn.chat.participant.repo.thread_participant.ThreadParticipantRepository;
import xyz.jocn.chat.user.entity.UserEntity;
import xyz.jocn.chat.user.repo.user.UserRepository;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class RoomParticipantService {

	private final UserRepository userRepository;
	private final RoomRepository roomRepository;
	private final RoomParticipantRepository roomParticipantRepository;
	private final ThreadParticipantRepository threadParticipantRepository;
	private final ThreadRepository threadRepository;

	private final RoomParticipantConverter roomParticipantConverter = RoomParticipantConverter.INSTANCE;

	@Transactional
	public void invite(RoomInviteRequestDto roomInviteRequestDto) {

		RoomEntity roomEntity =
			roomRepository
				.findById(roomInviteRequestDto.getRoomId())
				.orElseThrow(() -> new ResourceNotFoundException(ROOM));

		List<UserEntity> userEntities =
			userRepository.findByIdIn(roomInviteRequestDto.getInvitees());

		List<RoomParticipantEntity> newParticipants = new ArrayList<>();

		for (UserEntity userEntity : userEntities) {
			newParticipants.add(
				RoomParticipantEntity.builder()
					.room(roomEntity)
					.user(userEntity)
					.build()
			);
		}

		roomParticipantRepository.saveAll(newParticipants);

		// ProducerEvent producerEvent = new ProducerEvent();
		// producer.emit(producerEvent);
	}

	public List<RoomParticipantDto> getParticipants(Long roomId) {
		return roomParticipantConverter.toDto(roomParticipantRepository.findAllByRoomId(roomId));
	}

	@Transactional
	public void exit(RoomExitDto dto) {
		roomParticipantRepository.deleteById(dto.getParticipantId());

		List<ThreadEntity> threadEntities = threadRepository.findAllByRoomId(dto.getRoomId());
		threadParticipantRepository.deleteAllByUserIdAndThreadIn(dto.getUserId(), threadEntities);

		// ProducerEvent producerEvent = new ProducerEvent();
		// producer.emit(producerEvent);
	}
}
