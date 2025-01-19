package com.JobAssist.app.utils;

import com.JobAssist.app.dto.ProjectDTO;
import com.JobAssist.app.entities.Project;
import com.JobAssist.app.entities.UserProfile;

public class ProjectConverter {

    public static ProjectDTO toDTO(Project project) {
        if (project == null) return null;

        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId());
        dto.setTitle(project.getTitle());
        dto.setDescription(project.getDescription());
        dto.setStartDate(project.getStartDate());
        dto.setEndDate(project.getEndDate());

        // Map userId from UserProfile
        UserProfile user = project.getUser();
        if (user != null) {
            dto.setUserId(user.getId());
        }

        return dto;
    }

    public static Project toEntity(ProjectDTO dto) {
        if (dto == null) return null;

        Project project = new Project();
        project.setId(dto.getId());
        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());

        // Map UserProfile if userId exists
        if (dto.getUserId() != null) {
            UserProfile user = new UserProfile();
            user.setId(dto.getUserId());
            project.setUser(user);
        }

        return project;
    }
}

