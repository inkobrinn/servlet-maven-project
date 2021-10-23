package com.example.servlet.project.service;

import com.example.servlet.project.util.PropertiesUtil;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ImageService {
    private static final ImageService INSTANCE = new ImageService();
    private final String basePath = PropertiesUtil.get("image.base.url");

    @SneakyThrows
    public void upload(String imagePath, InputStream imageContent) {
        Path fullPath = Path.of(basePath, imagePath);
        try (imageContent) {
            Files.createDirectories(fullPath.getParent());
            Files.write(fullPath, imageContent.readAllBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }

    public static ImageService getInstance() {
        return INSTANCE;
    }
}
