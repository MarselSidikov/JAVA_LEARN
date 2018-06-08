package ru.itpark.files.services;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itpark.files.models.FileInfo;
import ru.itpark.files.repository.FileInfosRepository;
import ru.itpark.files.util.FilesUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilesServiceImpl implements FilesService {

  @Autowired
  private FilesUtil filesUtil;

  @Autowired
  private FileInfosRepository fileInfosRepository;

  @Value("${storage.path}")
  private String storagePath;

  @SneakyThrows
  @Override
  public List<String> saveFiles(MultipartFile[] files) {
    List<String> paths = new ArrayList<>();
    for (MultipartFile file : files) {
      FileInfo fileInfo = filesUtil.convertFromMultipart(file);
      fileInfosRepository.save(fileInfo);
      Files.copy(file.getInputStream(), Paths.get(storagePath, fileInfo.getStorageFileName()));
      paths.add(fileInfo.getStorageFileName());
    }
    return paths;
  }

  @SneakyThrows
  @Override
  public void writeFileToResponse(String fileName, HttpServletResponse response) {
    Optional<FileInfo> fileCandidate = fileInfosRepository.findOneByStorageFileName(fileName);
    if (fileCandidate.isPresent()) {
      FileInfo fileInfo = fileCandidate.get();
      response.setContentType(fileInfo.getType());
      response.setHeader("Content-Disposition",
          "attachment; filename=\"" + fileInfo.getOriginalFileName() + "\"");
      File file = new File(fileInfo.getUrl());
      InputStream inputStream = new FileInputStream(file);
      IOUtils.copy(inputStream, response.getOutputStream());
      response.flushBuffer();
    }
  }
}
