import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors 
class Season {
	int number_of_season
	List<Chapter> chapters= new ArrayList
	
	new(int n_season){
		number_of_season= n_season
	}
	
	def addChapter( Chapter ch){
		chapters.add(ch)
	}
	
	def setUniqueCodeAtAll(String _code){
		chapters.forEach[ it | it.setUniqueCode(_code, number_of_season ,chapters.indexOf(it))]
	}
	
	def getPointsOfChapters() {
		var _points = 0
		for (var i = 0; i < chapters.length; i++){
			_points+= chapters.get(i).points
		}
		return _points
	
	}
	
	def getTimes() {
		var _times= 0
		for (var i = 0; i < chapters.length; i++){
			_times+= chapters.get(i).times
		}
		if( _times >0){
			return _times
		}
		else{
			return _times+1	
		}
				
	}
	
	def getChapt(String code) {
		var chapter_index= Integer.parseInt(code.substring(code.indexOf("C")+1, code.length))
		return chapters.get(chapter_index)
	}
	
}