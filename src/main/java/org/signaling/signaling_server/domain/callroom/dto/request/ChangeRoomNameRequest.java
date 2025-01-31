package org.signaling.signaling_server.domain.callroom.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "통화방 이름 변경 위한 요청")
public record ChangeRoomNameRequest(
        @NotNull @Schema(description = "통화방 고유 아이디", example = "1") Long callRoomId,
        @NotBlank @Schema(description = "변경할 통화방 이름", example = "홍길동") String roomName

) {
}
