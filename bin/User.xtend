import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.LinkedHashMap
import java.util.HashMap

@Accessors
class User {
	String code
	String user_name
	String full_name
	String registration_date
	String birthday
	List<User> friends= new ArrayList
	List<User> awaiting_request= new ArrayList
	List<Content> view_content= new ArrayList
	List<Content> favourite_content= new ArrayList
	List<Content> suggested_content= new ArrayList
	
	new (String us_name){
		user_name= us_name
	}
	
	def setUniqueCode(int _number) {
		code= user_name + _number 
	}
	
	def addToWaitingList(User user) {
		awaiting_request.add(user)
	}
	
	def hasInAwaitingList(User user) {
		return awaiting_request.contains(user)
	}
	
	def accept(User user) {
		awaiting_request.remove(user)
		friends.add(user)
		user.friends.add(this)
	}
	
	def watchContent(Content content) {
		if (!view_content.contains(content)){
			view_content.add(content)
		}
	}
	
	def hasSeen(String _code) {
		var has_seen= view_content.findFirst[ it | it.code == _code]
		return has_seen !== null
	}
	
	def getAllChaptersSeenOf(String series_code) {
		var listOfChapters= new ArrayList
		for (var i=0 ; i<view_content.length; i++){
			var cont= view_content.get(i)
			if (cont.code.startsWith(series_code)){
				listOfChapters.add(cont)
			}
		}
		
		return listOfChapters
	}
	
	def hasAsAFriend(User user) {
		return friends.contains(user)
	}
	
	def reciveRecommendation(Content content) {
		suggested_content.add(content)
	}
	
	def addToFavourite(Content content) {
		if (!favourite_content.contains(content)){
			favourite_content.add(content)
		}
	}
	
	def chaptersSeen(Series series, int season) {
		var searched_code= series.code+ "N"+season
		var seen_chapters= 0 
		for (var i= 0 ; i> view_content.length; i++){
			var cont= view_content.get(i)
			if (cont.code.startsWith(searched_code)){
				seen_chapters++
			}
		} 
		return seen_chapters
	}
	
	def contentMoreRecommended() {
		var top_five= new HashMap<Content, Integer>
		for (var i=0; i <suggested_content.size(); i++ ){
			var current_cont= suggested_content.get(i)
			if ( !top_five.containsKey(current_cont)){
				top_five.put (current_cont, 0)	
			}
			else{
				var appearences= top_five.get(current_cont)+1
				top_five.replace(current_cont, appearences)
			}
		}
		
		return top_five
	}
	
}