package ru.itpark.files.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.files.models.FileInfo;

import java.util.Optional;

public interface FileInfosRepository extends JpaRepository<FileInfo, Long> {
  Optional<FileInfo> findOneByStorageFileName(String storageFileName);
}
