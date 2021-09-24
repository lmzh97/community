package life.silenceradio.community.mapper;

import life.silenceradio.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}
