package ru.itpark.files.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itpark.files.services.FilesService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class FilesController {

  @Autowired
  private FilesService service;

  @GetMapping("/upload")
  public String getFilesUploadPage() {
    return "FileUpload";
  }

  @GetMapping("/avatar")
  public String getAvatarPage() {
    return "AvatarPage";
  }

  @PostMapping(value = "/files", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<List<String>>
  handleFileUpload(@RequestParam("file") MultipartFile files[]) {
    List<String> filesPaths = service.saveFiles(files);
    return ResponseEntity.ok(filesPaths);
  }

  @GetMapping("/files/{file-name:.+}")
  public void getFile(@PathVariable("file-name") String fileName,
                      HttpServletResponse response) {
    service.writeFileToResponse(fileName, response);
  }

}
