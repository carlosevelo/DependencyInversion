
package spellcheck;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class SpellingChecker {
    private IContentFetcher fetcher;
    private IWordExtractor extractor;
    private IDictionary dictionary;

    SpellingChecker(IContentFetcher contentFetcher, IWordExtractor wordExtractor, IDictionary dictionary) {
        this.fetcher = contentFetcher;
        this.extractor = wordExtractor;
        this.dictionary = dictionary;
    }

	public SortedMap<String, Integer> check(URL url) throws IOException {

		// download the document content
        String content = fetcher.fetch(url);

		// extract words from the content
        List<String> words = extractor.extract(content);

		// find spelling mistakes
        SortedMap<String, Integer> mistakes = new TreeMap<>();

        for (String word : words) {
            if (!dictionary.isValidWord(word)) {
                if (mistakes.containsKey(word)) {
                    int oldCount = mistakes.get(word);
                    mistakes.put(word, oldCount + 1);
                } else {
                    mistakes.put(word, 1);
                }
            }
        }

		return mistakes;
	}
}

