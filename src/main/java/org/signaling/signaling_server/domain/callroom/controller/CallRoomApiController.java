package org.signaling.signaling_server.domain.callroom.controller;

import lombok.RequiredArgsConstructor;
import org.signaling.signaling_server.common.api.Api;
import org.signaling.signaling_server.common.type.success.CallRoomSuccessType;
import org.signaling.signaling_server.domain.callroom.dto.response.CallRoomInfoListResponse;
import org.signaling.signaling_server.domain.callroom.service.CallRoomService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/call-room")
public class CallRoomApiController implements CallRoomApi {
    private final CallRoomService callRoomService;

    //방 생성
    @PostMapping
    public Api<?> createRoom(Authentication authentication) {
        callRoomService.createRoom(authentication);
        return Api.success(CallRoomSuccessType.CREATE_CALL_ROOM);
    }

    @GetMapping
    public Api<CallRoomInfoListResponse> searchRoom(
            @RequestParam String search,
            Authentication authentication
    ) {
        CallRoomInfoListResponse callRoomInfoListResponse = callRoomService.searchRoom(search, authentication);
        return Api.success(CallRoomSuccessType.SEARCH_CALL_ROOM, callRoomInfoListResponse);
    }

    @MessageMapping("/notice/{roomNumber}")
    @SendTo("/sub/notice/{roomNumber}")
    public String handleNotice(@DestinationVariable String roomNumber, String offer) {
        return offer; // Offer 전달
    }

    @MessageMapping("/offer/{roomNumber}")
    @SendTo("/sub/offer/{roomNumber}")
    public String handleOffer(@DestinationVariable String roomNumber, String offer) {
        return offer; // Offer 전달
    }

    @MessageMapping("/answer/{roomNumber}")
    @SendTo("/sub/answer/{roomNumber}")
    public String handleAnswer(@DestinationVariable String roomNumber, String answer) {
        return answer; // Answer 전달
    }

    @MessageMapping("/ice-candidate/{roomNumber}")
    @SendTo("/sub/ice-candidate/{roomNumber}")
    public String handleIceCandidate(@DestinationVariable String roomNumber, String candidate) {
        return candidate; // ICE Candidate 전달
    }
}
