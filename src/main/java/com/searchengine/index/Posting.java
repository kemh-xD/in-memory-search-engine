package com.searchengine.index;

import java.util.List;

public record Posting<ID>(ID documentID, int frequency, List<Integer> positions) {
}
