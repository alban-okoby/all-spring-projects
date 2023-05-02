package com.digitalsouag.portfolio.services;

import com.digitalsouag.portfolio.payloads.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Integer postId);

	void deleteComment(Integer commentId);

}
