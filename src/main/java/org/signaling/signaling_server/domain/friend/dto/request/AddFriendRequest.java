package org.signaling.signaling_server.domain.friend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "친구 추가를 위한 요청")
public record AddFriendRequest(
        @Email @NotNull @Schema(description = "유저 이메일", example = "exemple@gmail.com") String email
) {
}
