package spellcheck;

import java.io.IOException;
import java.net.URL;

public interface IContentFetcher {
     String fetch(URL url) throws IOException;
}
