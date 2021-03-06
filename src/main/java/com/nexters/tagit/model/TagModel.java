package com.nexters.tagit.model;

/**
 * tag 테이블의 맵핑 모델
 * 
 * @author madplay
 * created on 2016. 8. 21.
 */
public class TagModel {
	private Integer id;
	private String content;
	private String createTime;
	private String editTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getEditTime() {
		return editTime;
	}
	public void setEditTime(String editTime) {
		this.editTime = editTime;
	}
	
	
}
