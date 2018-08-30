import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class User {
  private String code;
  
  private String user_name;
  
  private String full_name;
  
  private String registration_date;
  
  private String birthday;
  
  private List<User> friends = new ArrayList<User>();
  
  private List<User> awaiting_request = new ArrayList<User>();
  
  private List<Content> view_content = new ArrayList<Content>();
  
  private List<Content> favourite_content = new ArrayList<Content>();
  
  private List<Content> suggested_content = new ArrayList<Content>();
  
  public User(final String us_name) {
    this.user_name = us_name;
  }
  
  public String setUniqueCode(final int _number) {
    return this.code = (this.user_name + Integer.valueOf(_number));
  }
  
  public boolean addToWaitingList(final User user) {
    return this.awaiting_request.add(user);
  }
  
  public boolean hasInAwaitingList(final User user) {
    return this.awaiting_request.contains(user);
  }
  
  public boolean accept(final User user) {
    boolean _xblockexpression = false;
    {
      this.awaiting_request.remove(user);
      this.friends.add(user);
      _xblockexpression = user.friends.add(this);
    }
    return _xblockexpression;
  }
  
  public boolean watchContent(final Content content) {
    boolean _xifexpression = false;
    boolean _contains = this.view_content.contains(content);
    boolean _not = (!_contains);
    if (_not) {
      _xifexpression = this.view_content.add(content);
    }
    return _xifexpression;
  }
  
  public boolean hasSeen(final String _code) {
    final Function1<Content, Boolean> _function = (Content it) -> {
      String _code_1 = it.getCode();
      return Boolean.valueOf(Objects.equal(_code_1, _code));
    };
    Content has_seen = IterableExtensions.<Content>findFirst(this.view_content, _function);
    return (has_seen != null);
  }
  
  public ArrayList<Content> getAllChaptersSeenOf(final String series_code) {
    ArrayList<Content> listOfChapters = new ArrayList<Content>();
    for (int i = 0; (i < ((Object[])Conversions.unwrapArray(this.view_content, Object.class)).length); i++) {
      {
        Content cont = this.view_content.get(i);
        boolean _startsWith = cont.getCode().startsWith(series_code);
        if (_startsWith) {
          listOfChapters.add(cont);
        }
      }
    }
    return listOfChapters;
  }
  
  public boolean hasAsAFriend(final User user) {
    return this.friends.contains(user);
  }
  
  public boolean reciveRecommendation(final Content content) {
    return this.suggested_content.add(content);
  }
  
  public boolean addToFavourite(final Content content) {
    boolean _xifexpression = false;
    boolean _contains = this.favourite_content.contains(content);
    boolean _not = (!_contains);
    if (_not) {
      _xifexpression = this.favourite_content.add(content);
    }
    return _xifexpression;
  }
  
  public int chaptersSeen(final Series series, final int season) {
    String _code = series.getCode();
    String _plus = (_code + "N");
    String searched_code = (_plus + Integer.valueOf(season));
    int seen_chapters = 0;
    for (int i = 0; (i > ((Object[])Conversions.unwrapArray(this.view_content, Object.class)).length); i++) {
      {
        Content cont = this.view_content.get(i);
        boolean _startsWith = cont.getCode().startsWith(searched_code);
        if (_startsWith) {
          seen_chapters++;
        }
      }
    }
    return seen_chapters;
  }
  
  public HashMap<Content, Integer> contentMoreRecommended() {
    HashMap<Content, Integer> top_five = new HashMap<Content, Integer>();
    for (int i = 0; (i < this.suggested_content.size()); i++) {
      {
        Content current_cont = this.suggested_content.get(i);
        boolean _containsKey = top_five.containsKey(current_cont);
        boolean _not = (!_containsKey);
        if (_not) {
          top_five.put(current_cont, Integer.valueOf(0));
        } else {
          Integer _get = top_five.get(current_cont);
          int appearences = ((_get).intValue() + 1);
          top_five.replace(current_cont, Integer.valueOf(appearences));
        }
      }
    }
    return top_five;
  }
  
  @Pure
  public String getCode() {
    return this.code;
  }
  
  public void setCode(final String code) {
    this.code = code;
  }
  
  @Pure
  public String getUser_name() {
    return this.user_name;
  }
  
  public void setUser_name(final String user_name) {
    this.user_name = user_name;
  }
  
  @Pure
  public String getFull_name() {
    return this.full_name;
  }
  
  public void setFull_name(final String full_name) {
    this.full_name = full_name;
  }
  
  @Pure
  public String getRegistration_date() {
    return this.registration_date;
  }
  
  public void setRegistration_date(final String registration_date) {
    this.registration_date = registration_date;
  }
  
  @Pure
  public String getBirthday() {
    return this.birthday;
  }
  
  public void setBirthday(final String birthday) {
    this.birthday = birthday;
  }
  
  @Pure
  public List<User> getFriends() {
    return this.friends;
  }
  
  public void setFriends(final List<User> friends) {
    this.friends = friends;
  }
  
  @Pure
  public List<User> getAwaiting_request() {
    return this.awaiting_request;
  }
  
  public void setAwaiting_request(final List<User> awaiting_request) {
    this.awaiting_request = awaiting_request;
  }
  
  @Pure
  public List<Content> getView_content() {
    return this.view_content;
  }
  
  public void setView_content(final List<Content> view_content) {
    this.view_content = view_content;
  }
  
  @Pure
  public List<Content> getFavourite_content() {
    return this.favourite_content;
  }
  
  public void setFavourite_content(final List<Content> favourite_content) {
    this.favourite_content = favourite_content;
  }
  
  @Pure
  public List<Content> getSuggested_content() {
    return this.suggested_content;
  }
  
  public void setSuggested_content(final List<Content> suggested_content) {
    this.suggested_content = suggested_content;
  }
}
