package ru.itpark.files.services;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface FilesService {
  List<String> saveFiles(MultipartFile[] files);

  void writeFileToResponse(String fileName, HttpServletResponse response);
}
