package spellcheck;

import java.util.List;
import java.util.SortedMap;

public interface SpellingCheckerInterface {
    String getContent();
    List<String> getWords();
    SortedMap<String, Integer> getMistakes();

}
