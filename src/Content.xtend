
import java.util.List
import java.util.ArrayList
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Content {
	String code
	String title
	List<String> genres= new ArrayList
	String calification
	String realase_date
	int duration
	double stars
	String youtube_link
}