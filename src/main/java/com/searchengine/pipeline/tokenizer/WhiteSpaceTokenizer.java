package com.searchengine.pipeline.tokenizer;

import com.searchengine.models.Token;

import java.util.ArrayList;
import java.util.List;

public class WhiteSpaceTokenizer implements Tokenizer {
    @Override
    public List<Token> tokenize(String text) {
        String[] tokens = text.split(" ");
        List<Token> result = new ArrayList<>();
        int index = 0;
        for (String token : tokens) {
            result.add(new Token(token, index));
            index++;
        }
        return result;
    }
}
