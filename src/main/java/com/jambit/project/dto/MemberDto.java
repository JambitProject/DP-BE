package com.jambit.project.dto;

import com.jambit.project.domain.entity.Member;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDto {
    private Long id;
    private String userId;
    private String nickname;

    public static Member toEntity(MemberDto memberDto){
        return Member.builder()
                .id(memberDto.getId())
                .userId(memberDto.getUserId())
                .nickname(memberDto.getNickname())
                .build();
    }

}
