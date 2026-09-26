package com.searchengine.models;

import java.util.Objects;

public record SearchResult<ID, T>(Document<ID, T> document, double score)
    implements Comparable<SearchResult<ID,T>>
{

    public SearchResult{
        Objects.requireNonNull(document);
    }

    @Override
    public int compareTo(SearchResult<ID, T> other) {
        return Double.compare(other.score, this.score);
    }
}

