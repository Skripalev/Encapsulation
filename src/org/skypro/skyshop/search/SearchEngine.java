package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(query)) {
                results.add(searchable);
            }
        }
        return results;
    }

    public Searchable findMostRelevant(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new IllegalArgumentException("Поисковая строка не может быть пустой или null.");
        }
        Searchable mostRelevant = null;
        int maxCount = -1;
        for (Searchable searchable : searchables) {
            String term = searchable.getSearchTerm();
            int countOccurrences = countSubstringOccurrences(term, search);
            if (countOccurrences > maxCount) {
                maxCount = countOccurrences;
                mostRelevant = searchable;
            }
        }
        if (mostRelevant == null) {
            throw new BestResultNotFound("Не найден подходящий объект для поискового запроса: " + search);
        }
        return mostRelevant;
    }

    private int countSubstringOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        int substringLength = substring.length();
        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substringLength;
        }
        return count;
    }
}