package org.signaling.signaling_server.domain.callroommember.dto;

import org.signaling.signaling_server.entity.callroommember.enums.CallRoomMemberRole;
import org.signaling.signaling_server.entity.friend.enums.FriendStatus;

public record CallRoomMemberInfoDto(
        Long id,
        Long memberId,
        String nickname,
        CallRoomMemberRole role
) {
}
