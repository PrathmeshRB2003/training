package com.pb.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotEmpty
    private String task;
    
    @Size(min=3, max=4 )
	@Pattern(regexp="^high|low|mid",message="Type Between high/mid/low")
    private String priority;

    private String status="pending";

    @Column(name = "assign_date")
    private LocalDate assignDate = LocalDate.now();

    @Column(name = "finished_date")
    private LocalDate finishedDate;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getAssignDate() {
        return assignDate;
    }
    public void setAssignDate(LocalDate assignDate) {
        this.assignDate = assignDate;
    }
    public LocalDate getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(LocalDate finishedDate) {
        this.finishedDate = finishedDate;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

	public Todo() {
		super();
	}

	public Todo(int id, String task, String priority, String status, LocalDate assignDate, LocalDate finishedDate,
			User user) {
		super();
		this.id = id;
		this.task = task;
		this.priority = priority;
		this.status = "Pending";
		this.assignDate = assignDate;
		this.finishedDate = finishedDate;
		this.user = user;
	}
}