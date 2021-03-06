package com.jambit.project.service;

import com.jambit.project.dto.MemberDto;
import com.jambit.project.dto.ProjectDto;
import com.jambit.project.dto.RegisterSkillDto;
import com.jambit.project.dto.SkillSetDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MemberService {
    MemberDto modify(MemberDto memberDto);
    MemberDto findMember(String nickname);
    void delete(Long memberId);
    List<MemberDto> searchMemberList(String nickname);
    List<ProjectDto> getMyProjectList(Long memberId);
    List<SkillSetDto> getMemberSkillSet(Long memberId);
    Boolean registerSkill(RegisterSkillDto registerSkillDto);
    Boolean registerImage(Long memberId, MultipartFile[] files) throws Exception;
    Long createMember(MemberDto memberDto);
    String generateToken(String nickname);
    MemberDto findMemberByUserId(String userId);
    Page<MemberDto> getRecommendMember(Pageable pageable);
    Boolean checkDuplicateNickname(String nickname);
    List<MemberDto> searchMemberWithType(String type, String payload);
}
