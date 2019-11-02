package org.ct.dao;

import org.ct.bean.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentDao {
    /**
     *  根据查询条件分页查询评论列表
     * @param comment 查询条件
     * @return 评论列表
     */
    List<Comment> selectByPage(Comment comment);

    /**
     * 新增
     * @param comment 评论对象
     * @return 影响行数
     */
    int insert(Comment comment);
}
