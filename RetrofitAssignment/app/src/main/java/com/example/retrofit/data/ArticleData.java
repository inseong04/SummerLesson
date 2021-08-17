package com.example.retrofit.data;

import java.util.List;

public class ArticleData {

    public String title;
    public String slug;
    public String body;
    public String createdAt;
    public String updatedAt;
    public List<String> tagList = null;
    public String description;
    public AuthorData author;
    public Boolean favorited;
    public Integer favoritesCount;

}
