package com.jambit.project.domain.repository;

import com.jambit.project.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long>{
    /*@Query("select * from Project p where p.participatedNickname Like ?1")
    List<Project> findAllProjectListByNicknameLike(String nickname);*/

    List<Project> findTop5ByOrderByLikesCountDesc();
}

