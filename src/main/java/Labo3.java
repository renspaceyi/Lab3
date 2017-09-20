
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


/** Sentence 0.
 * this javadoc is required
 *
 * @author User
 *
 */
public class Labo3 {
    /**Sentence 1.
     * this is a main javadoc bc its required.
     * @param args it does stuff
     *
     */

    public static void main(final String[] args) {
        String parseMe = urlToString("http://erdani.com/tdpl/hamlet.txt");
        // Counts number of words on website
        stringToWordCount(parseMe,"");
        // Counts number of words equal to the specified word disregarding case
        stringToWordCount(parseMe,"prince");

    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    /**
     * javadock.
     * @param s is a thing
     * @param findMe find number of these
     * @return does stor
     */
    public static int stringToWordCount(final String s, final String findMe) {
        int ret = 0;

        String news = s;
        news = news.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        while (news.indexOf("\n") != -1) {
            news = news.replace("\n", " ");
        }

        for (int i = 0; i >= 0 && i < news.length(); i = i) {
            if (news.indexOf(" ", i + 1) - i != 1) {
                if (findMe.equals("")) {
                    ret++;
                } else if (news.indexOf(" ", i + 1) >= 0) {
                    if (news.substring(i + 1, news.indexOf(" ", i + 1)).equals(findMe)) {
                        ret++;
                    }
                }
            }
            i = news.indexOf(" ", i + 1);
        }
        System.out.println(ret);

        return ret;
    }


}
