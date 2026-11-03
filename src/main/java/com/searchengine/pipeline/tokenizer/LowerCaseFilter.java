package com.searchengine.pipeline.tokenizer;

import com.searchengine.models.Token;

import java.util.List;

public class LowerCaseFilter implements TokenFilter {
    @Override
    public List<Token> filter(List<Token> tokens) {
        return tokens.stream()
        .map(token -> new Token(token.value().toLowerCase(), token.position()))
        .toList();
    }
}


