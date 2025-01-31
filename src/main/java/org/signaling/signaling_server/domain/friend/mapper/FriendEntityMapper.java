package org.signaling.signaling_server.domain.friend.mapper;

import org.signaling.signaling_server.domain.friend.dto.request.AddFriendRequest;
import org.signaling.signaling_server.entity.friend.FriendEntity;
import org.signaling.signaling_server.entity.friend.enums.FriendStatus;
import org.signaling.signaling_server.entity.member.MemberEntity;

public class FriendEntityMapper {
    public static FriendEntity toEntity(MemberEntity friendMemberEntity, Long fromMemberId){
        return FriendEntity.builder()
                .fromMemberId(fromMemberId)
                .toMemberId(friendMemberEntity.getId())
                .status(FriendStatus.REQUEST)
                .build();
    }
}
