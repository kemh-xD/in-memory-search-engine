package com.searchengine.index;

import com.searchengine.models.Document;
import com.searchengine.models.SearchResult;
import com.searchengine.models.Token;

import java.util.*;

public class InvertedIndex<ID, T> {

    //Here is the index
    //Implemented using a HashMap
    private final Map<String, List<Posting<ID>>> index = new HashMap<>();

    private final Map<ID, Document<ID, T>> documentStore = new HashMap<>();
    //The computeIfAbsent method works pretty well
    //it's make sure that if the value isn't in our HashMap it's added as a key and then associated with an empty ArrayList
    //But we add the token position directly to the array
    //Using the HashMap helps us to have a time complexity of O(N)
    public void addDocument(Document<ID, T> document, List<Token> tokens){
        Map<String, List<Integer>> linkedValueToPositions = new HashMap<>();
        tokens.forEach(token -> linkedValueToPositions
                .computeIfAbsent(token.value(), v -> new ArrayList<>())
                .add(token.position())
        );

        //Same logic apply here to build the index
        linkedValueToPositions.forEach((key, value) -> index
                .computeIfAbsent(key, k -> new ArrayList<>())
                .add(new Posting<>(document.id(), value.size(), value))
        );
        documentStore.put(document.id(), document);
    }

    //The documentStore is a HashMap we have created on top
    //Which as soon as a document was indexed it's added to the store
    //The key is the document ID and the value the full document Object
    public List<SearchResult<ID, T>> searchTerm(String term){
        List<Posting<ID>> termListPostings = getPostings(term);
        List<SearchResult<ID, T>> searchResults = new ArrayList<>();
        termListPostings.forEach(posting -> {
            Document<ID, T> document = documentStore.get(posting.documentID());
            if (document != null){
                searchResults.add(new SearchResult<>(document, posting.frequency()));
            }
        });
        return searchResults;
    }


    public List<Posting<ID>> getPostings(String term){
        //Each document holds terms and one term can be refernced to many documents
        // So one term can reference many Postings and indexes
        return index.getOrDefault(term, Collections.emptyList());
    }



}

