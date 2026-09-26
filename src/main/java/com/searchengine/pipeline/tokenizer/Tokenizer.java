package com.searchengine.pipeline.tokenizer;

import com.searchengine.models.Token;

import java.util.List;

public interface Tokenizer {
    List<Token> tokenize(String text);
}
