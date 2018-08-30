import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class TraiFlix {
	List<User> users=new ArrayList
	List<Film> films =new ArrayList
	List<Series> series =new ArrayList

/*	----------------------------------------------------
 * |													|
 * |					FILMS                           |
 * |													|
   ------------------------------------------------------*/
	def addFilm(Film film){
		film.setUniqueCode(films.length+1)
		films.add(film)	
	}
	
	def lookUpFilmBy(String field, String value){
	
	    switch field 
	    {
    		case 'code' : films.get(Integer.parseInt(value.substring(1, value.length))),
      		case 'title' : films.findFirst[ it | it.title == value]
     		default : "Incorrect field"
    	}
	}
	
	def giveStars( int stars ,String code){
		films.forEach[ it | 
			if (it.code== code){
				it.receive_punctuation(stars)
			}		]
	}
	
	def getFilmsRatin(String title){
		val film= films.findFirst[it | it.title == title]
		return film.stars
	}
	

/*	----------------------------------------------------
 * |													|
 * |					SERIES                          |
 * |													|
   ------------------------------------------------------*/	
   
   def addSerie(Series _series){
   	_series.setUniqueCode(series.length)
   	series.add(_series)
   }
	
	def lookUpChapterOfASerie( String code){
	 var series_index= Integer.parseInt(code.substring(1, code.indexOf("N")))
	 
	 var chapter= series.get(series_index).getChapter(code)
	 
	 return chapter
	}
	
	
	def giveStarsToAChapter( Integer stars, Chapter chap){
		
		series.forEach[ it | 
			if (it.hasChapter(chap.code)){
				it.receive_punctuation(chap.code, stars)
			}
		]
	}
	
	def getStarsOfAChapterOfASerie( Chapter ch){
		var _cod = ch.code
		var chapter= lookUpChapterOfASerie(_cod)
		return chapter.stars
		
	}
	
	def numberOfSeasonsOfASerie(Series serie){
		var _cod = serie.code
		var series_index= Integer.parseInt(_cod.substring(1, _cod.length))
		var ser= series.get(series_index)
		
		return ser.numberOfSeasons()
		
	}
	
	def getAllChapters(Series _series){
		var series_index= Integer.parseInt(_series.code.substring(1, _series.code.length))
		var series_res= series.get(series_index)
		return series_res.getChapters() 	
		
	}
	
	def starsOfSerie(Series s){
		s.giveStars()
		return s.stars
	}
	/////////////////////////7777faltan puntos g y hy n
	
/*	----------------------------------------------------
 * |													|
 * |					USERS                           |
 * |													|
   ------------------------------------------------------*/
	
	def addUser(User us){
		us.setUniqueCode(users.length)
		users.add(us)
		
	}
	
	def addFriend( User requesting_user, User receiving_user){
		try{
			if (!receiving_user.hasInAwaitingList(requesting_user)){
				receiving_user.addToWaitingList(requesting_user)
			}
			else
				{
					throw new IllegalArgumentException("Request already sent")
				}
			}
			catch(RuntimeException e)
			{
				System.out.println(e.message)
			}
		
	}
	
	def acceptFriendsRequest(User requesting_user, User receiving_user){
		try{
			if (receiving_user.hasInAwaitingList(requesting_user)){
				receiving_user.accept(requesting_user)
			}
			else
				{
					throw new IllegalArgumentException("Opss, you hasn't got a request of this user")
				}
			}
			catch(RuntimeException e)
			{
				System.out.println(e.message)
			}
	}
	
	def friendsOf(String userName){
		val user= users.findFirst[it | it.user_name==userName]
		return user.friends
	}
	
	def watch(User us, Content content){
		us.watchContent(content)
	}
	
	def hasSeenMovie( User us, Film film){
		var film_code= film.code
		return us.hasSeen(film_code)
	}
	
	def hasSeenAllSeries(User us, Series srs){
		var series_code= srs.code
		var chapters_Seen= us.getAllChaptersSeenOf( series_code)
		var chapters_of_series= getAllChapters(srs)
		return chapters_Seen.length == chapters_of_series.length
	}
	
	def recommendContent(User us, User friend, Content cont){
		try
		{
			if(us.hasAsAFriend(friend) && (films.contains(cont)|| series.contains(cont)))
			{
				friend.reciveRecommendation(cont)
			}
			else
			{
				throw new IllegalArgumentException("Add this friend/content to send a recommendation")
			}
		}
			catch(RuntimeException e)
			{
				System.out.println(e.message)
			}
	}
	
	def addContentToFavouriteList(User us, Content cont){
		us.addToFavourite(cont)
	}
	
	def chaptersSeenOfASason( User us, Series srs, int season){
		return us.chaptersSeen(srs, season)
		
	}
	
	def contentMoreRecommendedFor( User us){
		return us.contentMoreRecommended()
	}
}





















