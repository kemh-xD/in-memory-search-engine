package com.searchengine.pipeline.tokenizer;

import com.searchengine.models.Token;

import java.util.List;

public interface TokenFilter {
    List<Token> filter(List<Token> tokens);
}
