package com.jambit.project.service;

import com.jambit.project.domain.entity.Board;
import com.jambit.project.domain.entity.Image;
import com.jambit.project.domain.entity.TargetType;
import com.jambit.project.domain.repository.ImageRepository;
import com.jambit.project.dto.ImageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;


    @Transactional
    public List<ImageDto> getImage(TargetType targetType, Long targetId){
        List<Image> images = imageRepository.findAllImageListByTargetIdAndTargetType(targetId, targetType);
        if(!images.isEmpty()) {
            return images.stream()
                    .map(Image::toDto)
                    .collect(Collectors.toList());
        }
        else return null;
    }

}
