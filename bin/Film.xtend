

import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Film extends Content{
	String directors
	String actors
	List<Content> related_content= new ArrayList
	private int total_score
	private int much_scores
	
	new (String tit, List cat, String r_date, int dur, String calif, String link, 
		 String dirs, String act){
		 	title= tit
		 	genres= cat
			calification= calif
			realase_date= r_date
			duration= dur
			youtube_link= link
			directors= dirs
			actors= act			
			
		}
		
		def receive_punctuation(Integer puntuation){
			try
			{
				if(puntuation>0 && puntuation <=5)
				{
					total_score+= puntuation
					much_scores++
					stars= total_score/much_scores 
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
	
	def setUniqueCode(int code) {
		code= "P"+code
	}
	
}