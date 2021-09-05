package com.localstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.localstore.modal.Comment;

public interface CommentDao extends JpaRepository<Comment, Long> {

}
