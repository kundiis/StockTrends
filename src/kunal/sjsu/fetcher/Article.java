package kunal.sjsu.fetcher;

public class Article {
	String dateTime;
	String title;
	String article;
	String url;
	
	public Article(String d, String t, String a, String u){
		this.dateTime = d;
		this.title = t;
		this.article = a;
		this.url = u;
	}
}
