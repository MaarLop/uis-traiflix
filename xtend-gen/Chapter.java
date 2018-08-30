import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Chapter extends Content {
  private int chapter_number;
  
  private String directors;
  
  private String actors;
  
  private int points = 0;
  
  private int times = 0;
  
  public Chapter(final String tit, final List cat, final String r_date, final int dur, final String calif, final String link, final int chapter, final String dir, final String act) {
    this.setTitle(tit);
    this.setGenres(cat);
    this.setCalification(calif);
    this.setRealase_date(r_date);
    this.setDuration(dur);
    this.setYoutube_link(link);
    this.chapter_number = chapter;
    this.directors = dir;
    this.actors = act;
  }
  
  public void receive_punctuation(final Integer stars) {
    try {
      if ((((stars).intValue() > 0) && ((stars).intValue() <= 5))) {
        int _points = this.points;
        this.points = (_points + (stars).intValue());
        this.times++;
        this.setStars((this.points / this.times));
      } else {
        throw new IllegalArgumentException("Invalid qualification");
      }
    } catch (final Throwable _t) {
      if (_t instanceof RuntimeException) {
        final RuntimeException e = (RuntimeException)_t;
        System.out.println(e.getMessage());
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void setUniqueCode(final String _code, final int season, final int chapter_number) {
    this.setCode(((((_code + "N") + Integer.valueOf(season)) + "C") + Integer.valueOf(chapter_number)));
  }
  
  @Pure
  public int getChapter_number() {
    return this.chapter_number;
  }
  
  public void setChapter_number(final int chapter_number) {
    this.chapter_number = chapter_number;
  }
  
  @Pure
  public String getDirectors() {
    return this.directors;
  }
  
  public void setDirectors(final String directors) {
    this.directors = directors;
  }
  
  @Pure
  public String getActors() {
    return this.actors;
  }
  
  public void setActors(final String actors) {
    this.actors = actors;
  }
  
  @Pure
  public int getPoints() {
    return this.points;
  }
  
  public void setPoints(final int points) {
    this.points = points;
  }
  
  @Pure
  public int getTimes() {
    return this.times;
  }
  
  public void setTimes(final int times) {
    this.times = times;
  }
}
