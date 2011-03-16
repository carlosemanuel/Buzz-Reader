package br.com.carlosemanuel.buzzreader.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONObject;

import br.com.carlosemanuel.buzzreader.exception.BuzzIOException;
import br.com.carlosemanuel.buzzreader.exception.BuzzParsingException;
import br.com.carlosemanuel.buzzreader.model.BuzzFeed;
import br.com.carlosemanuel.buzzreader.parsers.handlers.FeedHandler;

/**
 * Parser for element: <b>feed<b/>.
 * 
 * @author roberto.estivill
 */
public class BuzzFeedParser {

	public static BuzzFeed parseFeedJson(InputStream in)
			throws BuzzParsingException, BuzzIOException {

		InputStreamReader reader = new InputStreamReader(in);

		BufferedReader bf = new BufferedReader(reader);
		
		StringBuilder builder = new StringBuilder();

		try {
			String linha = "";
			while ((linha = bf.readLine()) != null) {
				builder.append(linha);
				builder.append("\n");
			}
		} catch (Exception e) {
			throw new BuzzIOException(e);
		} finally {
			try {
				bf.close();
				reader.close();
				in.close();
			} catch (Exception e) {
				throw new BuzzIOException(e);
			}
		}

		BuzzFeed feed = null;
		try {
			JSONObject root = new JSONObject(builder.toString());
			JSONObject data = root.getJSONObject("data");
			feed = FeedHandler.handle(data);
		} catch (Exception e) {
			throw new BuzzParsingException(e);
		}
		
		return feed;
	}
}