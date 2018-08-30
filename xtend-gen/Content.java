import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Content {
  private String code;
  
  private String title;
  
  private List<String> genres = new ArrayList<String>();
  
  private String calification;
  
  private String realase_date;
  
  private int duration;
  
  private double stars;
  
  private String youtube_link;
  
  @Pure
  public String getCode() {
    return this.code;
  }
  
  public void setCode(final String code) {
    this.code = code;
  }
  
  @Pure
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(final String title) {
    this.title = title;
  }
  
  @Pure
  public List<String> getGenres() {
    return this.genres;
  }
  
  public void setGenres(final List<String> genres) {
    this.genres = genres;
  }
  
  @Pure
  public String getCalification() {
    return this.calification;
  }
  
  public void setCalification(final String calification) {
    this.calification = calification;
  }
  
  @Pure
  public String getRealase_date() {
    return this.realase_date;
  }
  
  public void setRealase_date(final String realase_date) {
    this.realase_date = realase_date;
  }
  
  @Pure
  public int getDuration() {
    return this.duration;
  }
  
  public void setDuration(final int duration) {
    this.duration = duration;
  }
  
  @Pure
  public double getStars() {
    return this.stars;
  }
  
  public void setStars(final double stars) {
    this.stars = stars;
  }
  
  @Pure
  public String getYoutube_link() {
    return this.youtube_link;
  }
  
  public void setYoutube_link(final String youtube_link) {
    this.youtube_link = youtube_link;
  }
}
