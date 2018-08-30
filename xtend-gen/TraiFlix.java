import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class TraiFlix {
  private List<User> users = new ArrayList<User>();
  
  private List<Film> films = new ArrayList<Film>();
  
  private List<Series> series = new ArrayList<Series>();
  
  /**
   * ----------------------------------------------------
   * |													|
   * |					FILMS                           |
   * |													|
   * ------------------------------------------------------
   */
  public boolean addFilm(final Film film) {
    boolean _xblockexpression = false;
    {
      int _length = ((Object[])Conversions.unwrapArray(this.films, Object.class)).length;
      int _plus = (_length + 1);
      film.setUniqueCode(_plus);
      _xblockexpression = this.films.add(film);
    }
    return _xblockexpression;
  }
  
  public Object lookUpFilmBy(final String field, final String value) {
    Object _switchResult = null;
    boolean _matched = false;
    if (Objects.equal(field, "code")) {
      _matched=true;
      _switchResult = this.films.get(Integer.parseInt(value.substring(1, value.length())));
    }
    if (!_matched) {
      _matched=true;
      if (!_matched) {
        if (Objects.equal(field, "title")) {
          _matched=true;
        }
      }
      if (_matched) {
        final Function1<Film, Boolean> _function = (Film it) -> {
          String _title = it.getTitle();
          return Boolean.valueOf(Objects.equal(_title, value));
        };
        _switchResult = IterableExtensions.<Film>findFirst(this.films, _function);
      }
    }
    if (!_matched) {
      _switchResult = "Incorrect field";
    }
    return _switchResult;
  }
  
  public void giveStars(final int stars, final String code) {
    final Consumer<Film> _function = (Film it) -> {
      String _code = it.getCode();
      boolean _equals = Objects.equal(_code, code);
      if (_equals) {
        it.receive_punctuation(Integer.valueOf(stars));
      }
    };
    this.films.forEach(_function);
  }
  
  public double getFilmsRatin(final String title) {
    final Function1<Film, Boolean> _function = (Film it) -> {
      String _title = it.getTitle();
      return Boolean.valueOf(Objects.equal(_title, title));
    };
    final Film film = IterableExtensions.<Film>findFirst(this.films, _function);
    return film.getStars();
  }
  
  /**
   * ----------------------------------------------------
   * |													|
   * |					SERIES                          |
   * |													|
   * ------------------------------------------------------
   */
  public boolean addSerie(final Series _series) {
    boolean _xblockexpression = false;
    {
      _series.setUniqueCode(((Object[])Conversions.unwrapArray(this.series, Object.class)).length);
      _xblockexpression = this.series.add(_series);
    }
    return _xblockexpression;
  }
  
  public Chapter lookUpChapterOfASerie(final String code) {
    int series_index = Integer.parseInt(code.substring(1, code.indexOf("N")));
    Chapter chapter = this.series.get(series_index).getChapter(code);
    return chapter;
  }
  
  public void giveStarsToAChapter(final Integer stars, final Chapter chap) {
    final Consumer<Series> _function = (Series it) -> {
      boolean _hasChapter = it.hasChapter(chap.getCode());
      if (_hasChapter) {
        it.receive_punctuation(chap.getCode(), stars);
      }
    };
    this.series.forEach(_function);
  }
  
  public double getStarsOfAChapterOfASerie(final Chapter ch) {
    String _cod = ch.getCode();
    Chapter chapter = this.lookUpChapterOfASerie(_cod);
    return chapter.getStars();
  }
  
  public int numberOfSeasonsOfASerie(final Series serie) {
    String _cod = serie.getCode();
    int series_index = Integer.parseInt(_cod.substring(1, _cod.length()));
    Series ser = this.series.get(series_index);
    return ser.numberOfSeasons();
  }
  
  public ArrayList<Chapter> getAllChapters(final Series _series) {
    int series_index = Integer.parseInt(_series.getCode().substring(1, _series.getCode().length()));
    Series series_res = this.series.get(series_index);
    return series_res.getChapters();
  }
  
  public double starsOfSerie(final Series s) {
    s.giveStars();
    return s.getStars();
  }
  
  /**
   * ----------------------------------------------------
   * |													|
   * |					USERS                           |
   * |													|
   * ------------------------------------------------------
   */
  public boolean addUser(final User us) {
    boolean _xblockexpression = false;
    {
      us.setUniqueCode(((Object[])Conversions.unwrapArray(this.users, Object.class)).length);
      _xblockexpression = this.users.add(us);
    }
    return _xblockexpression;
  }
  
  public Boolean addFriend(final User requesting_user, final User receiving_user) {
    boolean _xtrycatchfinallyexpression = false;
    try {
      boolean _xifexpression = false;
      boolean _hasInAwaitingList = receiving_user.hasInAwaitingList(requesting_user);
      boolean _not = (!_hasInAwaitingList);
      if (_not) {
        _xifexpression = receiving_user.addToWaitingList(requesting_user);
      } else {
        throw new IllegalArgumentException("Request already sent");
      }
      _xtrycatchfinallyexpression = _xifexpression;
    } catch (final Throwable _t) {
      if (_t instanceof RuntimeException) {
        final RuntimeException e = (RuntimeException)_t;
        System.out.println(e.getMessage());
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return Boolean.valueOf(_xtrycatchfinallyexpression);
  }
  
  public Boolean acceptFriendsRequest(final User requesting_user, final User receiving_user) {
    boolean _xtrycatchfinallyexpression = false;
    try {
      boolean _xifexpression = false;
      boolean _hasInAwaitingList = receiving_user.hasInAwaitingList(requesting_user);
      if (_hasInAwaitingList) {
        _xifexpression = receiving_user.accept(requesting_user);
      } else {
        throw new IllegalArgumentException("Opss, you hasn\'t got a request of this user");
      }
      _xtrycatchfinallyexpression = _xifexpression;
    } catch (final Throwable _t) {
      if (_t instanceof RuntimeException) {
        final RuntimeException e = (RuntimeException)_t;
        System.out.println(e.getMessage());
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return Boolean.valueOf(_xtrycatchfinallyexpression);
  }
  
  public List<User> friendsOf(final String userName) {
    final Function1<User, Boolean> _function = (User it) -> {
      String _user_name = it.getUser_name();
      return Boolean.valueOf(Objects.equal(_user_name, userName));
    };
    final User user = IterableExtensions.<User>findFirst(this.users, _function);
    return user.getFriends();
  }
  
  public boolean watch(final User us, final Content content) {
    return us.watchContent(content);
  }
  
  public boolean hasSeenMovie(final User us, final Film film) {
    String film_code = film.getCode();
    return us.hasSeen(film_code);
  }
  
  public boolean hasSeenAllSeries(final User us, final Series srs) {
    String series_code = srs.getCode();
    ArrayList<Content> chapters_Seen = us.getAllChaptersSeenOf(series_code);
    ArrayList<Chapter> chapters_of_series = this.getAllChapters(srs);
    final ArrayList<Content> _converted_chapters_Seen = (ArrayList<Content>)chapters_Seen;
    int _length = ((Object[])Conversions.unwrapArray(_converted_chapters_Seen, Object.class)).length;
    final ArrayList<Chapter> _converted_chapters_of_series = (ArrayList<Chapter>)chapters_of_series;
    int _length_1 = ((Object[])Conversions.unwrapArray(_converted_chapters_of_series, Object.class)).length;
    return (_length == _length_1);
  }
  
  public Boolean recommendContent(final User us, final User friend, final Content cont) {
    boolean _xtrycatchfinallyexpression = false;
    try {
      boolean _xifexpression = false;
      if ((us.hasAsAFriend(friend) && (this.films.contains(cont) || this.series.contains(cont)))) {
        _xifexpression = friend.reciveRecommendation(cont);
      } else {
        throw new IllegalArgumentException("Add this friend/content to send a recommendation");
      }
      _xtrycatchfinallyexpression = _xifexpression;
    } catch (final Throwable _t) {
      if (_t instanceof RuntimeException) {
        final RuntimeException e = (RuntimeException)_t;
        System.out.println(e.getMessage());
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return Boolean.valueOf(_xtrycatchfinallyexpression);
  }
  
  public boolean addContentToFavouriteList(final User us, final Content cont) {
    return us.addToFavourite(cont);
  }
  
  public int chaptersSeenOfASason(final User us, final Series srs, final int season) {
    return us.chaptersSeen(srs, season);
  }
  
  public HashMap<Content, Integer> contentMoreRecommendedFor(final User us) {
    return us.contentMoreRecommended();
  }
  
  @Pure
  public List<User> getUsers() {
    return this.users;
  }
  
  public void setUsers(final List<User> users) {
    this.users = users;
  }
  
  @Pure
  public List<Film> getFilms() {
    return this.films;
  }
  
  public void setFilms(final List<Film> films) {
    this.films = films;
  }
  
  @Pure
  public List<Series> getSeries() {
    return this.series;
  }
  
  public void setSeries(final List<Series> series) {
    this.series = series;
  }
}
