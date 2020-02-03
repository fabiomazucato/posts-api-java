package com.posts.api.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Posts")
public class Post {

	@Id
	private String id;

	private String title;
	private String text;
	private String author;
	private Integer votes;
	private String createDate;

	/**
	 * get / set - id
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * get / set - title
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * get / set - text
	 */
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	/**
	 * get / set - author
	 */
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * get / set - votes
	 */
	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	/**
	 * get / set - createDate
	 */
	public String getCreateDate() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(createDate));
	}

	public void setCreateDate() {
		this.createDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm"));
	}

	// public Post() {
	// }
}