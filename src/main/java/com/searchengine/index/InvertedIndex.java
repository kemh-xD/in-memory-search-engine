package com.searchengine.index;

import com.searchengine.models.Document;
import com.searchengine.models.Token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertedIndex<ID, T> {

    //Here is the index
    //Implemented using a HashMap
    private final Map<String, List<Posting<ID>>> index = new HashMap<>();

    //The computeIfAbsent method works pretty well
    //it's make sure that if the value isn't in our HasMap it's added as a key and then associated with an empty ArrayList
    //But we add the token position directly to the array
    //Using the HashMap helps us to have a time complexity of O(N)
    public void addDocument(Document<ID, T> document, List<Token> tokens){
        Map<String, List<Integer>> linkValueToPositions = new HashMap<>();
        tokens.forEach(token -> linkValueToPositions
                .computeIfAbsent(token.value(), v -> new ArrayList<>())
                .add(token.position())
        );

        //Same logic apply here to build the index
        linkValueToPositions.forEach((key, value) -> index
                .computeIfAbsent(key, k -> new ArrayList<>())
                .add(new Posting<>(document.id(), value.size(), value))
        );

    }

}

