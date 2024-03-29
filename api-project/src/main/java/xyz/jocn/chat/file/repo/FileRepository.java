package xyz.jocn.chat.file.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.jocn.chat.file.entity.FileEntity;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long>, FileRepositoryExt {
}
