package com.jambit.project.service;

import com.jambit.project.dto.BoardDto;

import java.util.List;

public interface BoardService {
    BoardDto findPost(Long post_id);

    Long createPost(BoardDto boardDto);

    Long modifyPost(BoardDto boardDto);

    boolean deletePost(Long post_id);

    List<BoardDto> findAllPosts();

    List<BoardDto> findPostListByUserNickname(String nickname);

    List<BoardDto> findPostByTitle(String title);
}