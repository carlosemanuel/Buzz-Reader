package br.com.carlosemanuel.buzzreader.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class to represent a Buzz Attachment
 * 
 * @author carlos.emanuel
 * 
 */
public class BuzzAttachment {

	private String type;
	private String title;
	private BuzzContent content;

	private List<BuzzLink> links = new ArrayList<BuzzLink>(0);

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	public BuzzContent getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(BuzzContent content) {
		this.content = content;
	}

	/**
	 * @return the links
	 */
	public List<BuzzLink> getLinks() {
		return links;
	}

	/**
	 * @param links
	 *            the links to set
	 */
	public void setLinks(List<BuzzLink> links) {
		this.links = links;
	}
	
	public void addLink(BuzzLink link) {
		this.links.add(link);
	}
	
}
