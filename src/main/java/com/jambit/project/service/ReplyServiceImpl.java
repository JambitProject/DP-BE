package com.jambit.project.service;

import com.jambit.project.domain.entity.Reply;
import com.jambit.project.domain.repository.ReplyRepository;
import com.jambit.project.dto.ReplyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReplyServiceImpl implements ReplyService {
    private final ReplyRepository replyRepository;

    @Transactional
    public List<ReplyDto> findAllPostRepliesList(Long postId) {
        List<Reply> findReplyList = replyRepository.findAllReplyListByPostId(postId);
        return findReplyList.stream()
                .map(Reply::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ReplyDto> findAllReferenceRepliesList(Long referenceId) {
        List<Reply> referenceReplyList = replyRepository.findByReferenceId(referenceId);
        return referenceReplyList.stream()
                .map(Reply::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public Page<ReplyDto> findAllPostRepliesPage(Long postId, Pageable pageable) {
        Page<Reply> findReplyList = replyRepository.findAllReplyPageByPostIdAndReferenceIdNull(postId, pageable);
        return findReplyList.map(Reply::toDTO);
    }

    @Transactional
    public String create(ReplyDto replyDto) {
        if (replyDto != null) {
            replyDto.setLikesCount(0L);
            replyDto.setIsDeleted(false);
            Reply reply = ReplyDto.toEntity(replyDto);
            replyRepository.save(reply);
            return reply.getNickname();
        }
        return null;
    }

    @Transactional
    public String modify(ReplyDto replyDto) {
        Optional<Reply> findModifyingReply = replyRepository.findByIdAndReferenceId(
                replyDto.getId(), replyDto.getReferenceId());
        if (findModifyingReply.isPresent()) {
            Reply findReply = findModifyingReply.get();
            replyRepository.save(findReply);
            return findReply.getNickname();
        }
        return null;
    }

    @Transactional
    public boolean deletePostReply(Long reply_id) {
        Optional<Reply> deleteReply = replyRepository.findById(reply_id);
        if (deleteReply.isPresent()) {
            Reply reply = deleteReply.get();
            if (reply.getIsDeleted()) {
                return false;
            }
            reply.setIsDeleted(true);
            return true;
        }
        return false;
    }
}