package com.searchengine.pipeline.tokenizer;

import com.searchengine.models.Token;

import java.util.List;

public class StopWordFilter implements TokenFilter{
    @Override
    public List<Token> filter(List<Token> tokens) {
        return List.of();
    }
}
