package com.jambit.project.domain.entity;


import com.jambit.project.dto.ProjectDto;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter  @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Project extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Column(nullable = false)
    private String participatedNickname;

    @Column(nullable = false)
    private String projectManager;

    @Column(nullable = false)
    private String projectName;

    @Column(nullable = false)
    private String content;

    @Column
    private String githubLink;

    @Column
    private String projectLink;

    @Column
    private Long viewCount;

    @Column
    private Long replyCount;

    @Column
    private Long likesCount;

    @Column
    private String techStack;

    @Enumerated(EnumType.STRING)
    @Column
    private ProgressType progress;

    public static ProjectDto toDto(Project project){
        return ProjectDto.builder()
                .id(project.getId())
                .participatedNickname(project.getParticipatedNickname())
                .projectName(project.getProjectName())
                .content(project.getContent())
                .githubLink(project.getGithubLink())
                .projectLink(project.getProjectLink())
                .viewCount(project.getViewCount())
                .replyCount(project.getReplyCount())
                .techStack(project.getTechStack())
                .likesCount(project.getLikesCount())
                .progress(project.getProgress())
                .projectManager(project.getProjectManager())
                .build();
    }

    public void update(ProjectDto projectDto) {
        this.content = projectDto.getContent();
        this.projectName = projectDto.getProjectName();
        this.githubLink = projectDto.getGithubLink();
        this.participatedNickname = projectDto.getParticipatedNickname();
        this.progress = projectDto.getProgress();
        this.projectManager = projectDto.getProjectManager();
        this.techStack = projectDto.getTechStack();
        this.projectLink = projectDto.getProjectLink();
    }

}
