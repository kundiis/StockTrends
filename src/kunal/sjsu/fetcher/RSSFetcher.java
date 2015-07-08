package kunal.sjsu.fetcher;

import java.nio.channels.Channel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.httpclient.HttpURL;

import de.l3s.boilerpipe.extractors.ArticleExtractor;

import yarfraw.core.datamodel.ItemEntry;
import yarfraw.core.datamodel.Link;
import yarfraw.io.FeedReader;

public class RSSFetcher {

	public static void main(String[] args) {
		try{
		//     FeedReader reader2 = new FeedReader(new HttpURL("http://feeds.sfgate.com/sfgate/rss/feeds/business"));
		     FeedReader reader2 = new FeedReader(new HttpURL("http://finance.yahoo.com/rss/blog?s=EBAY"));
		     
		      //integrate from here 
		      // http://www.vogella.de/articles/JavaNetworking/article.html#web_readpage
		     	List<Article> news = new ArrayList<Article>();
		      	List<Link> l = reader2.readChannel().getLinks();
		      	Link urltext = l.get(0);	
		      	// Get all the items
		      	List<ItemEntry> items = reader2.readChannel().getItems();      	
		      	Iterator<ItemEntry> i = items.iterator();
		      	while(i.hasNext()){
		      		ItemEntry e = i.next();
		      		URL url = new URL(e.getLinks().get(0).getHref());
		      		System.out.println(e.getLinks().get(0).getHref());
		      		System.out.println(e.getPubDate());
		      		//System.out.println("Summary"+e.getDescriptionOrSummaryText());
		      		System.out.println("Title"+e.getTitleText());
		      		System.out.println("_________________________________"+url);
		      		String text = ArticleExtractor.INSTANCE.getText(url);
					System.out.println(text);
					System.out.println("*****************");
					// create a new article
					Article a = new Article(e.getPubDate(), e.getTitleText(), text, e.getLinks().get(0).getHref());
					// add it to the List
					news.add(a);
		      	}
		      	System.out.println("Total Number of articles:"+items.size());
		      	
		      //	RecordData rd = new RecordData();
		     // 	rd.insertData(news);
		      	
//				BufferedReader in = new BufferedReader(new InputStreamReader(url
//						.openStream()));
//				String inputLine;
//
//				while ((inputLine = in.readLine()) != null) {
//					// Process each line.
//					//System.out.println(inputLine);
//				}
//				in.close();			
		      	
		      	// Fetch Sector Data, then companies in each sector.
		      	// Get companies data from the excel.
		      	
		      	// Fetch company RSS feeds. Check Hash, update with new data applying Data algorithm.
		      	// One time fetch company historical data. 
		      	
		      	
			}catch(Exception e){
				e.printStackTrace();
	 	}
	}
}
