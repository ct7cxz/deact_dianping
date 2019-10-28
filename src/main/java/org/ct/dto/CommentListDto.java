package org.ct.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.ct.bean.Comment;

import java.util.List;

@JsonInclude(Include.NON_NULL)
public class CommentListDto {
	
	private boolean hasMore;
	private List<Comment> data;
	
	public boolean isHasMore() {
		return hasMore;
	}
	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}
	public List<Comment> getData() {
	    return data;
	}
	public void setData(List<Comment> data) {
	    this.data = data;
	}
}