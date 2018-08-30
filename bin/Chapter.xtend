import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List

@Accessors
class Chapter extends Content{
	int chapter_number
	String directors
	String actors
	private int points=0
	private int times=0
	
	new (String tit, List cat, String r_date, int dur, String calif, String link,
		int chapter, String dir, String act){
		 	title= tit
		 	genres= cat
			calification= calif
			realase_date= r_date
			duration= dur
			youtube_link= link
			chapter_number= chapter
			directors= dir
			actors= act
			
	}
	def receive_punctuation(Integer stars){
		try
			{
				if(stars>0 && stars <=5)
				{
					points+= stars
					times++
					stars= points/times
				}
				else
				{
					throw new IllegalArgumentException("Invalid qualification")
				}
			}
			catch(RuntimeException e)
			{
				System.out.println(e.message)
			}
	}
	def setUniqueCode(String _code, int season , int chapter_number) {
		code= _code + "N" + season +"C" + chapter_number 
	}
	
}