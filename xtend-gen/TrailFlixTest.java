import java.util.Collections;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TrailFlixTest {
  @Test
  public void given_a_new_system_it_empty() {
    final TraiFlix tf = new TraiFlix();
    int _length = ((Object[])Conversions.unwrapArray(tf.getFilms(), Object.class)).length;
    boolean _equals = (_length == 0);
    Assert.assertTrue(_equals);
    int _length_1 = ((Object[])Conversions.unwrapArray(tf.getSeries(), Object.class)).length;
    boolean _equals_1 = (_length_1 == 0);
    Assert.assertTrue(_equals_1);
    int _length_2 = ((Object[])Conversions.unwrapArray(tf.getUsers(), Object.class)).length;
    boolean _equals_2 = (_length_2 == 0);
    Assert.assertTrue(_equals_2);
  }
  
  @Test
  public void ola_testfallido() {
    final Film film = new Film("toy story", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("clasic,childrens")), "otro string", 120, "kkk", "222", "333", "44");
    final TraiFlix tf = new TraiFlix();
    tf.addFilm(film);
    int _length = ((Object[])Conversions.unwrapArray(tf.getFilms(), Object.class)).length;
    boolean _equals = (_length == 1);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void test2() {
    final Film film = new Film("toy story", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("clasic,childrens")), "otro string", 120, "kkk", "222", "333", "44");
    final TraiFlix tf = new TraiFlix();
    tf.addFilm(film);
    tf.giveStars(3, film.getCode());
    double _filmsRatin = tf.getFilmsRatin(film.getTitle());
    boolean _equals = (_filmsRatin == 3);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void test4() {
    final Series serie = new Series("Rick & Morthy", Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("cat2", "cat1")), "22/02/2015", 30, "P13", "youyube.com/R&M", "creador");
    final TraiFlix tf = new TraiFlix();
    tf.addSerie(serie);
    int _length = ((Object[])Conversions.unwrapArray(tf.getSeries(), Object.class)).length;
    boolean _equals = (_length == 1);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void test5() {
    final Series serie = new Series("Rick & Morthy", Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("cat2", "cat1")), "22/02/2015", 30, "P13", "youyube.com/R&M", "creador");
    final TraiFlix tf = new TraiFlix();
    final Season temp = new Season(1);
    Chapter cap = new Chapter("cap 1", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("cat2", "cat1")), "22/02/2015", 30, "P13", " ", 
      1, "DIrector", "Rick y motthy");
    temp.addChapter(cap);
    serie.addSeason(temp);
    tf.addSerie(serie);
    tf.giveStarsToAChapter(Integer.valueOf(5), cap);
    tf.giveStarsToAChapter(Integer.valueOf(1), cap);
    double _starsOfAChapterOfASerie = tf.getStarsOfAChapterOfASerie(cap);
    boolean _equals = (_starsOfAChapterOfASerie == 3);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void test6() {
    final Series serie = new Series("Rick & Morthy", Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("cat2", "cat1")), "22/02/2015", 30, "P13", "youyube.com/R&M", "creador");
    final TraiFlix tf = new TraiFlix();
    final Season temp1 = new Season(1);
    final Season temp2 = new Season(2);
    final Season temp3 = new Season(3);
    serie.addSeason(temp1);
    serie.addSeason(temp2);
    serie.addSeason(temp3);
    tf.addSerie(serie);
    int _numberOfSeasonsOfASerie = tf.numberOfSeasonsOfASerie(serie);
    boolean _equals = (_numberOfSeasonsOfASerie == 3);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void test7() {
    final User user = new User("pepe_juan");
    final TraiFlix tf = new TraiFlix();
    tf.addUser(user);
  }
  
  @Test
  public void test8() {
    final User user1 = new User("pepe_juan");
    final User user2 = new User("juan");
    final User user3 = new User("pepe");
    final User user4 = new User("ni_pepe_ni_juan");
    final TraiFlix tf = new TraiFlix();
    tf.addUser(user1);
    tf.addUser(user2);
    tf.addUser(user3);
    tf.addUser(user4);
    tf.addFriend(user1, user2);
    tf.addFriend(user1, user3);
    tf.addFriend(user1, user4);
    tf.acceptFriendsRequest(user1, user2);
    tf.acceptFriendsRequest(user1, user3);
    int _length = ((Object[])Conversions.unwrapArray(user1.getFriends(), Object.class)).length;
    boolean _equals = (_length == 2);
    Assert.assertTrue(_equals);
    int _length_1 = ((Object[])Conversions.unwrapArray(user3.getFriends(), Object.class)).length;
    boolean _equals_1 = (_length_1 == 1);
    Assert.assertTrue(_equals_1);
    int _length_2 = ((Object[])Conversions.unwrapArray(user4.getAwaiting_request(), Object.class)).length;
    boolean _equals_2 = (_length_2 == 1);
    Assert.assertTrue(_equals_2);
    Assert.assertTrue(user1.getFriends().contains(user2));
  }
  
  @Test
  public void test9() {
    final User user = new User("pepe_juan");
    final Film film = new Film("toy story", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("clasic,childrens")), "otro string", 120, "kkk", "222", "333", "44");
    final TraiFlix tf = new TraiFlix();
    tf.addUser(user);
    tf.addFilm(film);
    tf.watch(user, film);
    Assert.assertTrue(tf.hasSeenMovie(user, film));
  }
  
  @Test
  public void test10() {
    final User user = new User("pepe_juan");
    final Series serie = new Series("Rick & Morthy", Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("cat2", "cat1")), "22/02/2015", 30, "P13", "youyube.com/R&M", "creador");
    final TraiFlix tf = new TraiFlix();
    final Season temp1 = new Season(1);
    Chapter cap1_1 = new Chapter("cap 1", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("cat2", "cat1")), "22/02/2015", 30, "P13", " ", 
      1, "DIrector", "Rick y motthy");
    final Season temp2 = new Season(2);
    Chapter cap2_1 = new Chapter("cap 1", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("cat2", "cat1")), "22/02/2015", 30, "P13", " ", 
      1, "DIrector", "Rick y motthy");
    Chapter cap2_2 = new Chapter("cap 2", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("cat2", "cat1")), "22/02/2015", 30, "P13", " ", 
      1, "DIrector", "Rick y motthy");
    final Season temp3 = new Season(3);
    Chapter cap3_1 = new Chapter("cap 1", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("cat2", "cat1")), "22/02/2015", 30, "P13", " ", 
      1, "DIrector", "Rick y motthy");
    Chapter cap3_2 = new Chapter("cap 2", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("cat2", "cat1")), "22/02/2015", 30, "P13", " ", 
      1, "DIrector", "Rick y motthy");
    Chapter cap3_3 = new Chapter("cap 3", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("cat2", "cat1")), "22/02/2015", 30, "P13", " ", 
      1, "DIrector", "Rick y motthy");
    temp1.addChapter(cap1_1);
    temp2.addChapter(cap2_1);
    temp2.addChapter(cap2_2);
    temp3.addChapter(cap3_1);
    temp3.addChapter(cap3_2);
    temp3.addChapter(cap3_3);
    serie.addSeason(temp1);
    serie.addSeason(temp2);
    serie.addSeason(temp3);
    tf.addSerie(serie);
    tf.addUser(user);
    tf.watch(user, cap1_1);
    tf.watch(user, cap2_1);
    tf.watch(user, cap2_2);
    tf.watch(user, cap3_1);
    tf.watch(user, cap3_2);
    tf.watch(user, cap3_3);
    Assert.assertTrue(tf.hasSeenAllSeries(user, serie));
  }
  
  @Test
  public void test11() {
    final User user1 = new User("pepe_juan");
    final User user4 = new User("ni_pepe_ni_juan");
    final Series serie = new Series("Rick & Morthy", Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("cat2", "cat1")), "22/02/2015", 30, "P13", "youyube.com/R&M", "creador");
    final TraiFlix tf = new TraiFlix();
    tf.addUser(user1);
    tf.addUser(user4);
    tf.addSerie(serie);
    tf.addFriend(user1, user4);
    tf.acceptFriendsRequest(user1, user4);
    tf.recommendContent(user1, user4, serie);
    System.out.println(user4.getSuggested_content());
    Assert.assertTrue(user4.getSuggested_content().contains(serie));
  }
  
  @Test
  public void test12() {
    final Series serie = new Series("Rick & Morthy", Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("cat2", "cat1")), "22/02/2015", 30, "P13", "youyube.com/R&M", "creador");
    final TraiFlix tf = new TraiFlix();
    final Season temp1 = new Season(1);
    Chapter cap1_1 = new Chapter("cap 1", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("cat2", "cat1")), "22/02/2015", 30, "P13", " ", 
      1, "DIrector", "Rick y motthy");
    final Season temp2 = new Season(2);
    Chapter cap2_1 = new Chapter("cap 1", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("cat2", "cat1")), "22/02/2015", 30, "P13", " ", 
      1, "DIrector", "Rick y motthy");
    Chapter cap2_2 = new Chapter("cap 2", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("cat2", "cat1")), "22/02/2015", 30, "P13", " ", 
      1, "DIrector", "Rick y motthy");
    final Season temp3 = new Season(3);
    Chapter cap3_1 = new Chapter("cap 1", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("cat2", "cat1")), "22/02/2015", 30, "P13", " ", 
      1, "DIrector", "Rick y motthy");
    Chapter cap3_2 = new Chapter("cap 2", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("cat2", "cat1")), "22/02/2015", 30, "P13", " ", 
      1, "DIrector", "Rick y motthy");
    Chapter cap3_3 = new Chapter("cap 3", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("cat2", "cat1")), "22/02/2015", 30, "P13", " ", 
      1, "DIrector", "Rick y motthy");
    temp1.addChapter(cap1_1);
    temp2.addChapter(cap2_1);
    temp2.addChapter(cap2_2);
    temp3.addChapter(cap3_1);
    temp3.addChapter(cap3_2);
    temp3.addChapter(cap3_3);
    serie.addSeason(temp1);
    serie.addSeason(temp2);
    serie.addSeason(temp3);
    tf.addSerie(serie);
    tf.giveStarsToAChapter(Integer.valueOf(5), cap1_1);
    tf.giveStarsToAChapter(Integer.valueOf(1), cap1_1);
    tf.giveStarsToAChapter(Integer.valueOf(5), cap2_1);
    tf.giveStarsToAChapter(Integer.valueOf(3), cap2_2);
    tf.giveStarsToAChapter(Integer.valueOf(4), cap3_1);
    tf.giveStarsToAChapter(Integer.valueOf(1), cap3_1);
    tf.giveStarsToAChapter(Integer.valueOf(2), cap2_1);
    tf.giveStarsToAChapter(Integer.valueOf(5), cap1_1);
    tf.giveStarsToAChapter(Integer.valueOf(5), cap3_3);
    tf.giveStarsToAChapter(Integer.valueOf(2), cap3_3);
    tf.giveStarsToAChapter(Integer.valueOf(4), cap3_3);
    tf.giveStarsToAChapter(Integer.valueOf(1), cap3_3);
    tf.starsOfSerie(serie);
    double _starsOfSerie = tf.starsOfSerie(serie);
    boolean _equals = (_starsOfSerie == 3.0);
    Assert.assertTrue(_equals);
  }
}
