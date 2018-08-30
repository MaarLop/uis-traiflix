import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Series extends Content{
	
	String creator
	List<Season> seasons= new ArrayList
	List<Content> related_content= new ArrayList
	
	new (String tit, List<String> cat, String r_date, int dur, String calif, String link,
		String name_of_creator){
			title= tit
		 	genres= cat
			calification= calif
			realase_date= r_date
			duration= dur
			youtube_link= link
			creator= name_of_creator
	}
	
	def addSeason(Season season){
		seasons.add(season)
	}
	
	def giveStars(){
		var _points = 0
		var _times= 0
		for (var i = 0; i < seasons.length; i++){
			_points+= seasons.get(i).getPointsOfChapters()
			_times+= seasons.get(i).getTimes()
		}
		stars=_points/_times
		return stars
	}
	
	def setUniqueCode(int _code) {
		code= "S"+_code
		seasons.forEach[ it | it.setUniqueCodeAtAll(code)]
	}
	
	def getChapters(){
		var _chapters= new ArrayList
		for (var i = 0; i < seasons.length; i++){
			var current_season= seasons.get(i)
			_chapters.addAll(current_season.chapters)
		}
		return _chapters
	}
	
	def getChapter(String code) {
		var start_index= code.indexOf("N")+1
		var finish_index= code.indexOf("C")
		var season_index= Integer.parseInt(code.substring(start_index,finish_index))
		var season= seasons.get(season_index-1)
	 	return season.getChapt(code)
	}
	
	def hasChapter(String _code) {		
		return getChapter(_code)!== null
	}
	
	def receive_punctuation(String _code, Integer stars) {
		var chapter= getChapter(_code)
		chapter.receive_punctuation(stars)
	}
	
	def numberOfSeasons() {
		return seasons.length
	}
	
	
	
}