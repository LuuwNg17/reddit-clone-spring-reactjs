package com.lilso.lireddit.repository;

import com.lilso.lireddit.model.Comment;
import com.lilso.lireddit.model.Post;
import com.lilso.lireddit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findByUser(User user);
}
