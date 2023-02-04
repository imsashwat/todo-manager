package com.lcwd.todo.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

//yaha bnayi h logic
public class Todo {

    private int id;
    private String title;
    private String content;
    private String status;
    private java.util.Date addedDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date todoDate;

    public Todo(int id, String title, String content, String status, Date addedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.addedDate = addedDate;

    }

    public Todo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public java.util.Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(java.util.Date date) {
        this.addedDate = date;
    }

    public Date getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(Date date) {
        this.todoDate = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTodoDate(java.util.Date date) {
    }

}
