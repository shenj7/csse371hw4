package seed;


public class Textbook {
	public String topic;
	public String paperid;
	public String papertitle;
	public String link;
	public String authorName;
	public String yearPublished;
	public String citedLink;
	public Textbook(String topic, String papertitle, String link, String authorName, String yearPublished, String citedLink) {
		this.topic = topic;
		this.papertitle = papertitle;
		this.link = link;
		this.authorName = authorName;
		this.yearPublished = yearPublished;
		this.citedLink = citedLink;
	}
}
