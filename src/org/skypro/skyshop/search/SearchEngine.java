package org.skypro.skyshop.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchEngine {
    private final Set<Searchable> searchables;
    private boolean caseSensitive = false;

    public SearchEngine() {
        this.searchables = ConcurrentHashMap.newKeySet();
    }

    public void add(Searchable searchable) {
        if (searchable == null) {
            throw new IllegalArgumentException("Обьект не может быть null!");
        }
        searchables.add(searchable);
    }

    public Set<Searchable> search(String query) {
        if (query == null || query.isEmpty()) {
            return Collections.emptySortedSet();
        }
        String searchQuery;
        if (caseSensitive) {
            searchQuery = query;
        } else {
            searchQuery = query.toLowerCase();
        }
        return searchables.stream()
                .filter(searchable -> {
                    String term;
                    if (caseSensitive) {
                        term = searchable.getSearchTerm();
                    } else {
                        term = searchable.getSearchTerm().toLowerCase();
                    }
                    return term.contains(searchQuery);
                })
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(new SearchableComparator())
                ));
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