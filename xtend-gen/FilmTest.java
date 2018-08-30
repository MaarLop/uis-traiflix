import java.util.Collections;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class FilmTest {
  @Test
  public void given_a_new_film_its_stars_are_zero() {
    final Film film = new Film("toy story", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("clasic,childrens")), "otro string", 120, "kkk", "222", "333", "44");
    double _stars = film.getStars();
    boolean _equals = (_stars == 0);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void given_a_new_film_if_we_gave_a_star_it_has_one_star() {
    final Film film = new Film("toy story", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("clasic,childrens")), "otro string", 120, "kkk", "222", "333", "44");
    film.receive_punctuation(Integer.valueOf(1));
    double _stars = film.getStars();
    boolean _equals = (_stars == 1);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void given_a_new_film_if_it_recives_two_qualification_we_have_the_() {
    final Film film = new Film("toy story", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("clasic,childrens")), "otro string", 120, "kkk", "222", "333", "44");
    film.receive_punctuation(Integer.valueOf(1));
    film.receive_punctuation(Integer.valueOf(5));
    double _stars = film.getStars();
    boolean _equals = (_stars == 3);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void given_a_film_if_we_gave_nine_star_it_throws_an_exception() {
    final Film film = new Film("toy story", Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("clasic,childrens")), "otro string", 120, "kkk", "222", "333", "44");
    film.receive_punctuation(Integer.valueOf(9));
    double _stars = film.getStars();
    boolean _equals = (_stars == 0);
    Assert.assertTrue(_equals);
  }
}
