/* TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work.
You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */

public class Codec {
    private Dictionary<int, string> urls = new Dictionary<int, string>();
    private int counter = 0;

    // Encodes a URL to a shortened URL
    public string encode(string longUrl) {
        // Increment the counter and add the longUrl to the DB
        this.counter++;
        urls.Add(counter, longUrl);

        // the shortened url is the counter as a string
        return counter.ToString();
    }

    // Decodes a shortened URL to its original URL.
    public string decode(string shortUrl) {
        string value;
        int key = 0;
        // Convert the key to an integer
        Int32.TryParse(shortUrl, out key);

        // Look up the shortUrl key in the DB and return it if found
        if (urls.TryGetValue(key, out value))
        {
            return value;
        }
        else return null;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));