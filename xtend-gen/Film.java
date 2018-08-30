import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Film extends Content {
  private String directors;
  
  private String actors;
  
  private List<Content> related_content = new ArrayList<Content>();
  
  private int total_score;
  
  private int much_scores;
  
  public Film(final String tit, final List cat, final String r_date, final int dur, final String calif, final String link, final String dirs, final String act) {
    this.setTitle(tit);
    this.setGenres(cat);
    this.setCalification(calif);
    this.setRealase_date(r_date);
    this.setDuration(dur);
    this.setYoutube_link(link);
    this.directors = dirs;
    this.actors = act;
  }
  
  public void receive_punctuation(final Integer puntuation) {
    try {
      if ((((puntuation).intValue() > 0) && ((puntuation).intValue() <= 5))) {
        int _tal_score = this.total_score;
        this.total_score = (_tal_score + (puntuation).intValue());
        this.much_scores++;
        this.setStars((this.total_score / this.much_scores));
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
  
  public void setUniqueCode(final int code) {
    this.setCode(("P" + Integer.valueOf(code)));
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
  public List<Content> getRelated_content() {
    return this.related_content;
  }
  
  public void setRelated_content(final List<Content> related_content) {
    this.related_content = related_content;
  }
  
  @Pure
  public int getTotal_score() {
    return this.total_score;
  }
  
  public void setTotal_score(final int total_score) {
    this.total_score = total_score;
  }
  
  @Pure
  public int getMuch_scores() {
    return this.much_scores;
  }
  
  public void setMuch_scores(final int much_scores) {
    this.much_scores = much_scores;
  }
}
