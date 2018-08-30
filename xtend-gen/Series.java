import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Series extends Content {
  private String creator;
  
  private List<Season> seasons = new ArrayList<Season>();
  
  private List<Content> related_content = new ArrayList<Content>();
  
  public Series(final String tit, final List<String> cat, final String r_date, final int dur, final String calif, final String link, final String name_of_creator) {
    this.setTitle(tit);
    this.setGenres(cat);
    this.setCalification(calif);
    this.setRealase_date(r_date);
    this.setDuration(dur);
    this.setYoutube_link(link);
    this.creator = name_of_creator;
  }
  
  public boolean addSeason(final Season season) {
    return this.seasons.add(season);
  }
  
  public double giveStars() {
    int _points = 0;
    int _times = 0;
    for (int i = 0; (i < ((Object[])Conversions.unwrapArray(this.seasons, Object.class)).length); i++) {
      {
        int __points = _points;
        int _pointsOfChapters = this.seasons.get(i).getPointsOfChapters();
        _points = (__points + _pointsOfChapters);
        int __times = _times;
        int _times_1 = this.seasons.get(i).getTimes();
        _times = (__times + _times_1);
      }
    }
    this.setStars((_points / _times));
    return this.getStars();
  }
  
  public void setUniqueCode(final int _code) {
    this.setCode(("S" + Integer.valueOf(_code)));
    final Consumer<Season> _function = (Season it) -> {
      it.setUniqueCodeAtAll(this.getCode());
    };
    this.seasons.forEach(_function);
  }
  
  public ArrayList<Chapter> getChapters() {
    ArrayList<Chapter> _chapters = new ArrayList<Chapter>();
    for (int i = 0; (i < ((Object[])Conversions.unwrapArray(this.seasons, Object.class)).length); i++) {
      {
        Season current_season = this.seasons.get(i);
        _chapters.addAll(current_season.getChapters());
      }
    }
    return _chapters;
  }
  
  public Chapter getChapter(final String code) {
    int _indexOf = code.indexOf("N");
    int start_index = (_indexOf + 1);
    int finish_index = code.indexOf("C");
    int season_index = Integer.parseInt(code.substring(start_index, finish_index));
    Season season = this.seasons.get((season_index - 1));
    return season.getChapt(code);
  }
  
  public boolean hasChapter(final String _code) {
    Chapter _chapter = this.getChapter(_code);
    return (_chapter != null);
  }
  
  public void receive_punctuation(final String _code, final Integer stars) {
    Chapter chapter = this.getChapter(_code);
    chapter.receive_punctuation(stars);
  }
  
  public int numberOfSeasons() {
    return ((Object[])Conversions.unwrapArray(this.seasons, Object.class)).length;
  }
  
  @Pure
  public String getCreator() {
    return this.creator;
  }
  
  public void setCreator(final String creator) {
    this.creator = creator;
  }
  
  @Pure
  public List<Season> getSeasons() {
    return this.seasons;
  }
  
  public void setSeasons(final List<Season> seasons) {
    this.seasons = seasons;
  }
  
  @Pure
  public List<Content> getRelated_content() {
    return this.related_content;
  }
  
  public void setRelated_content(final List<Content> related_content) {
    this.related_content = related_content;
  }
}
