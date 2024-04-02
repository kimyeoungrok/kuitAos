package com.redispractice.kuitaos.repository;

import com.redispractice.kuitaos.Entity.Picture;
import com.redispractice.kuitaos.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
    Picture findByPost(Post post);
}
