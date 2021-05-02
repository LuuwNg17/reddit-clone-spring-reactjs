package com.lilso.lireddit.repository;

import com.lilso.lireddit.model.Post;
import com.lilso.lireddit.model.Subreddit;
import com.lilso.lireddit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);
}
