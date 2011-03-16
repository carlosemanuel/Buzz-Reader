package br.com.carlosemanuel.buzzreader.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONObject;

import br.com.carlosemanuel.buzzreader.exception.BuzzIOException;
import br.com.carlosemanuel.buzzreader.exception.BuzzParsingException;
import br.com.carlosemanuel.buzzreader.model.BuzzComment;
import br.com.carlosemanuel.buzzreader.parsers.handlers.CommentHandler;

/**
 * Parser for element: <b>comment<b/>.
 * 
 * @author roberto.estivill
 */
public class BuzzCommentParser {

	public static BuzzComment parseComment(InputStream in)
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

		BuzzComment comment = null;
		try {
			JSONObject root = new JSONObject(builder.toString());
			JSONObject data = root.getJSONObject("data");
			comment = CommentHandler.handle(data);
		} catch (Exception e) {
			throw new BuzzParsingException(e);
		}

		return comment;
	}
}