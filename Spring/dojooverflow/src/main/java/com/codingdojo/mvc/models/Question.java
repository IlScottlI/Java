package com.codingdojo.mvc.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message="Question is required")
    private String title;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
	@OneToMany(mappedBy="question", fetch = FetchType.LAZY)
    private List<Answer> answers;
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "tags_questions", 
        joinColumns = @JoinColumn(name = "question_id"), 
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tagsQuestions;
    public Question() {
        
    }
	public List<Tag> getTagsQuestions() {
		return tagsQuestions;
	}
	public void setTagsQuestions(List<Tag> tagsQuestions) {
		this.tagsQuestions = tagsQuestions;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTagsString() {
		String res = "";
		for (int i = 0; i < tagsQuestions.size(); i++) {
			if(i+1 < tagsQuestions.size()) {
				res += tagsQuestions.get(i).getName() + ", ";
			} else {
				res += tagsQuestions.get(i).getName() ;
			}
		}
		return res;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
	}
	public static char[] join(String separator, List<TagQuestion> tagsQuestions2) {
		// TODO Auto-generated method stub
		return null;
	}
}