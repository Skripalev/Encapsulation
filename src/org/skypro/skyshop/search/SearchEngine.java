package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] searchables;
    private int count;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
        this.count = 0;
    }

    public void add(Searchable searchable) {
        if (count < searchables.length) {
            searchables[count] = searchable;
            count++;
        } else {
            System.out.println("Невозможно добавить элемент: массив переполнен");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;
        for (int i = 0; i < count && resultCount < 5; i++) {
            if (searchables[i].getSearchTerm().contains(query)) {
                results[resultCount] = searchables[i];
                resultCount++;
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
        for (int i = 0; i < count; i++) {
            Searchable searchable = searchables[i];
            if (searchable != null) {
                String term = searchable.getSearchTerm();
                int countOccurrences = countSubstringOccurrences(term, search);
                if (countOccurrences > maxCount) {
                    maxCount = countOccurrences;
                    mostRelevant = searchable;
                }
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


