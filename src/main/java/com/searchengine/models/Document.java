package com.searchengine.models;


import java.util.Objects;

public record Document<ID,T>(ID id, T content, String title) {

    //Personalized constructor for validation before creating a document
    public Document{
        Objects.requireNonNull(id, "Document should have been labelled");
        Objects.requireNonNull(title, "Document's title required");
        Objects.requireNonNull(content, "Fill the document's content");
    }
}
