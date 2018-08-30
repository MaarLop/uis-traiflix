import static org.junit.Assert.*
import org.junit.Test

class FilmTest {
	@Test 
		def void given_a_new_film_its_stars_are_zero() {
			val film= new Film ("toy story", #['clasic,childrens'],"otro string",120,"kkk", "222", "333","44")
			assertTrue( film.stars == 0)
		}
	
	@Test
		def void given_a_new_film_if_we_gave_a_star_it_has_one_star(){
			val film= new Film ("toy story", #['clasic,childrens'],"otro string",120,"kkk", "222", "333","44")
			film.receive_punctuation(1)
			
			assertTrue(film.stars== 1)
		}
		
	@Test
		def void given_a_new_film_if_it_recives_two_qualification_we_have_the_(){
			val film= new Film ("toy story", #['clasic,childrens'],"otro string",120,"kkk", "222", "333","44")
			film.receive_punctuation(1)
			film.receive_punctuation(5)
			
			assertTrue(film.stars== 3)
		}
		
			@Test
		def void given_a_film_if_we_gave_nine_star_it_throws_an_exception(){
			val film= new Film ("toy story", #['clasic,childrens'],"otro string",120,"kkk", "222", "333","44")
			film.receive_punctuation(9)
			
			assertTrue(film.stars== 0)
				
		}
		
}
