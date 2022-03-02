package spellcheck;

import java.util.List;

public interface IWordExtractor {
    public List<String> extract(String content);
}
