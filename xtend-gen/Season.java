import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Season {
  private int number_of_season;
  
  private List<Chapter> chapters = new ArrayList<Chapter>();
  
  public Season(final int n_season) {
    this.number_of_season = n_season;
  }
  
  public boolean addChapter(final Chapter ch) {
    return this.chapters.add(ch);
  }
  
  public void setUniqueCodeAtAll(final String _code) {
    final Consumer<Chapter> _function = (Chapter it) -> {
      it.setUniqueCode(_code, this.number_of_season, this.chapters.indexOf(it));
    };
    this.chapters.forEach(_function);
  }
  
  public int getPointsOfChapters() {
    int _points = 0;
    for (int i = 0; (i < ((Object[])Conversions.unwrapArray(this.chapters, Object.class)).length); i++) {
      int __points = _points;
      int _points_1 = this.chapters.get(i).getPoints();
      _points = (__points + _points_1);
    }
    return _points;
  }
  
  public int getTimes() {
    int _times = 0;
    for (int i = 0; (i < ((Object[])Conversions.unwrapArray(this.chapters, Object.class)).length); i++) {
      int __times = _times;
      int _times_1 = this.chapters.get(i).getTimes();
      _times = (__times + _times_1);
    }
    if ((_times > 0)) {
      return _times;
    } else {
      return (_times + 1);
    }
  }
  
  public Chapter getChapt(final String code) {
    int _indexOf = code.indexOf("C");
    int _plus = (_indexOf + 1);
    int chapter_index = Integer.parseInt(code.substring(_plus, code.length()));
    return this.chapters.get(chapter_index);
  }
  
  @Pure
  public int getNumber_of_season() {
    return this.number_of_season;
  }
  
  public void setNumber_of_season(final int number_of_season) {
    this.number_of_season = number_of_season;
  }
  
  @Pure
  public List<Chapter> getChapters() {
    return this.chapters;
  }
  
  public void setChapters(final List<Chapter> chapters) {
    this.chapters = chapters;
  }
}
