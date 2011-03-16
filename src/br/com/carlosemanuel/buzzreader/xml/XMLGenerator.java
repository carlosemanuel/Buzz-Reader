package br.com.carlosemanuel.buzzreader.xml;

import br.com.carlosemanuel.buzzreader.exception.BuzzValidationException;
import br.com.carlosemanuel.buzzreader.model.BuzzContent;
import br.com.carlosemanuel.buzzreader.model.BuzzLink;

public class XMLGenerator
{
    /**
     * Generates new post request body.
     * 
     * @param content of the new post
     * @param link (if any)
     * @return the xml representation of the new entry.
     * @throws BuzzValidationException if any required value is missing.
     */
    public static String constructContentPayload( BuzzContent content, BuzzLink link )
        throws BuzzValidationException
    {
        StringBuilder sb = new StringBuilder();
		sb.append("<entry xmlns=\"http://www.w3.org/2005/Atom\" xmlns:buzz=\"http://schemas.google.com/buzz/2010\" xmlns:poco=\"http://portablecontacts.net/ns/1.0\">");
		sb.append("<activity:object>");
		sb.append("<activity:object-type>http://activitystrea.ms/schema/1.0/note</activity:object-type>");
        sb.append( constructContent( content ) );
		sb.append("</activity:object>");
        sb.append( link != null ? constructLink( link ) : "" );
        sb.append( "</entry>" );
        return sb.toString();
    }

	/**
	 * Generates new post request body.
	 * 
	 * @param content
	 *            of the new post
	 * @param link
	 *            (if any)
	 * @return the xml representation of the new entry.
	 * @throws BuzzValidationException
	 *             if any required value is missing.
	 */
	public static String constructCommentPayload(BuzzContent content,
			BuzzLink link) throws BuzzValidationException {
		StringBuilder sb = new StringBuilder();
		sb.append("<entry xmlns=\"http://www.w3.org/2005/Atom\" xmlns:buzz=\"http://schemas.google.com/buzz/2010\" xmlns:poco=\"http://portablecontacts.net/ns/1.0\">");
		sb.append(constructContent(content));
		sb.append(link != null ? constructLink(link) : "");
		sb.append("</entry>");
		return sb.toString();
	}

    /**
     * Generates the Content xml element to be included in the request body
     * 
     * @param link object to write the xml element.
     * @return the xml element.
     * @throws BuzzValidationException if the object is missing any required value.
     */
    private static String constructContent( BuzzContent content )
        throws BuzzValidationException
    {
        if ( content == null || content.getText() == null || content.getText().equals( "" ) )
        {
            throw new BuzzValidationException( "The content is invalid. null or required attributes are empty?" );
        }
        StringBuilder sb = new StringBuilder();
        sb.append( "<content type=\"" );
        sb.append( content.getType() );
        sb.append( "\">" );
        sb.append( content.getText() );
        sb.append( "</content>" );
        return sb.toString();
    }

    /**
     * Generates the Link xml element to be included in the request body.
     * 
     * @param link object to write the xml element
     * @return the xml element
     * @throws BuzzValidationException if the object is missing any required value
     */
    private static String constructLink( BuzzLink link )
        throws BuzzValidationException
    {
        if ( link == null || link.getHref() == null || link.getType() == null || link.getRel() == null
            || link.getHref().equals( "" ) || link.getType().equals( "" ) || link.getRel().equals( "" ) )
        {
            throw new BuzzValidationException( "The content is invalid. null or empty attributes?" );
        }
        StringBuilder sb = new StringBuilder();
        sb.append( "<link rel=\"" );
        sb.append( link.getRel() );
        sb.append( "\" type=\"" );
        sb.append( link.getType() );
        sb.append( "\" href=\"" );
        sb.append( link.getHref() );
        sb.append( "\" />" );
        return sb.toString();
    }
}