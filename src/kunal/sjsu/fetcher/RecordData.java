package kunal.sjsu.fetcher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

public class RecordData {
	
	public void insertData(List<Article> news){
		Iterator<Article> i = news.iterator(); 
		Connection con = new DBConnect().getConnection();
		PreparedStatement pst;
		while(i.hasNext()){
			try{
				Article a = i.next();
				//String insert = "insert into article(NewsTitle,NewsDate,Article, NewsLink) values('"+a.title+"','"+a.dateTime+"','"+a.article+"','"+a.url+"')";
				pst=con.prepareStatement("insert into article(articleid,keywordid,NewsTitle,NewsDate,Article,NewsLink) values(NULL,1,?,?,?,?)");
				//st.executeUpdate(insert);
				pst.setString(1, a.title);
				pst.setString(2, a.dateTime);
				pst.setString(3, a.article);
				pst.setString(4, a.url);
				pst.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
