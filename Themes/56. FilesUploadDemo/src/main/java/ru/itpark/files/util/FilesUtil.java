package ru.itpark.files.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.itpark.files.models.FileInfo;

import java.util.UUID;

@Component
public class FilesUtil {

  @Value("${storage.path}")
  private String storagePath;

  public FileInfo convertFromMultipart(MultipartFile file) {
    String originalFileName = file.getOriginalFilename();
    String type = file.getContentType();
    long size = file.getSize();
    String storageName = createStorageName(originalFileName);
    String fileUrl = storagePath + "/" + storageName;
    return FileInfo.builder()
        .originalFileName(originalFileName)
        .size(size)
        .storageFileName(storageName)
        .type(type)
        .url(fileUrl)
        .build();
  }


  private String createStorageName(String originalFileName) {
    String extension = FilenameUtils.getExtension(originalFileName);
    String newFileName = UUID.randomUUID().toString();
    return newFileName + "." + extension;
  }

}
