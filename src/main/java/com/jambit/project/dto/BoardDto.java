package com.jambit.project.dto;

import com.jambit.project.domain.entity.Board;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BoardDto {

    private Long id;
    private Long imageId;
    private String nickname;
    private String title;
    private String content;
    private Long likes;
    private Long viewCount;
    private Long replyCount;
    private LocalDateTime createdDate;

    public static Board toEntity(BoardDto boardDto) {
        return Board.builder()
                .id(boardDto.getId())
                .imageId(boardDto.getImageId())
                .nickname(boardDto.getNickname())
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .likes(boardDto.getLikes())
                .viewCount(boardDto.getViewCount())
                .replyCount(boardDto.getReplyCount())
                .build();
    }
}