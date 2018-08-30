import static org.junit.Assert.*
import org.junit.Test

class TrailFlixTest {
	@Test 
	def void given_a_new_system_it_empty() {
		val tf= new TraiFlix()
		
		assertTrue( tf.films.length  == 0 )
		assertTrue( tf.series.length == 0 )
		assertTrue( tf.users.length  == 0 )
	}
	
	@Test
	def void ola_testfallido(){
		val film = new Film ("toy story", #['clasic,childrens'],"otro string",120,"kkk", "222", "333","44")
		val tf= new TraiFlix()
		
		tf.addFilm(film)
		
		assertTrue( tf.films.length == 1)
	}
	
	@Test
	def void test2(){
		val film = new Film ("toy story", #['clasic,childrens'],"otro string",120,"kkk", "222", "333","44")
		val tf= new TraiFlix()
		
		tf.addFilm(film)
		tf.giveStars(3, film.code)
		
		assertTrue( tf.getFilmsRatin(film.title)== 3)
	}
	
	@Test
	def void test4(){
		val serie= new Series("Rick & Morthy", #["cat2","cat1"], "22/02/2015", 30, "P13", "youyube.com/R&M","creador")
		val tf= new TraiFlix()
		tf.addSerie(serie)
		
		assertTrue(tf.series.length == 1)
	}
	
	@Test
	def void test5(){
		val serie= new Series("Rick & Morthy", #["cat2","cat1"], "22/02/2015", 30, "P13", "youyube.com/R&M","creador")
		val tf= new TraiFlix()
		val temp= new Season(1)
		var cap= new Chapter("cap 1", #["cat2","cat1"], "22/02/2015", 30, "P13", " ",
		1,"DIrector", "Rick y motthy")
		
		temp.addChapter( cap)
		serie.addSeason(temp)
		
		tf.addSerie(serie)
		
		tf.giveStarsToAChapter(5,cap )		
		tf.giveStarsToAChapter(1,cap )	
		
		assertTrue(tf.getStarsOfAChapterOfASerie(cap)==3)
		
	}
	
	@Test
	def void test6(){
		val serie= new Series("Rick & Morthy", #["cat2","cat1"], "22/02/2015", 30, "P13", "youyube.com/R&M","creador")
		val tf= new TraiFlix()
		val temp1= new Season(1)
		val temp2= new Season(2)
		val temp3= new Season(3)
		
		serie.addSeason(temp1)
		serie.addSeason(temp2)
		serie.addSeason(temp3)
		
		tf.addSerie(serie)
		
		assertTrue(tf.numberOfSeasonsOfASerie(serie)==3)
		
	}
	
	@Test
	def void test7(){
		val user= new User("pepe_juan")
		val tf= new TraiFlix()		
		
		tf.addUser(user)
	}
	
	@Test
	def void test8(){
		val user1= new User("pepe_juan")
		val user2= new User("juan")
		val user3= new User("pepe")
		val user4= new User("ni_pepe_ni_juan")
		val tf= new TraiFlix()		
		
		tf.addUser(user1)
		tf.addUser(user2)
		tf.addUser(user3)
		tf.addUser(user4)

		tf.addFriend(user1, user2)
		tf.addFriend(user1, user3)
		tf.addFriend(user1, user4)
	
		tf.acceptFriendsRequest(user1, user2)
		tf.acceptFriendsRequest(user1, user3)

		assertTrue(user1.friends.length ==2)
		assertTrue(user3.friends.length ==1)
		assertTrue(user4.awaiting_request.length ==1)
		assertTrue(user1.friends.contains(user2))
	}
	
	@Test
	def void test9(){
		val user= new User("pepe_juan")
		val film = new Film ("toy story", #['clasic,childrens'],"otro string",120,"kkk", "222", "333","44")
		val tf= new TraiFlix()		
		
		tf.addUser(user)
		tf.addFilm(film)
		
		tf.watch(user, film)
		
		assertTrue(tf.hasSeenMovie(user,film))
	}
	
		@Test
	def void test10(){
		val user= new User("pepe_juan")
		val serie= new Series("Rick & Morthy", #["cat2","cat1"], "22/02/2015", 30, "P13", "youyube.com/R&M","creador")
		val tf= new TraiFlix()	
			
		val temp1= new Season(1)
		var cap1_1= new Chapter("cap 1", #["cat2","cat1"], "22/02/2015", 30, "P13", " ",
		1,"DIrector", "Rick y motthy")
		
		val temp2= new Season(2)
		var cap2_1= new Chapter("cap 1", #["cat2","cat1"], "22/02/2015", 30, "P13", " ",
		1,"DIrector", "Rick y motthy")
		var cap2_2= new Chapter("cap 2", #["cat2","cat1"], "22/02/2015", 30, "P13", " ",
		1,"DIrector", "Rick y motthy")
		
		val temp3= new Season(3)
		var cap3_1= new Chapter("cap 1", #["cat2","cat1"], "22/02/2015", 30, "P13", " ",
		1,"DIrector", "Rick y motthy")
		var cap3_2= new Chapter("cap 2", #["cat2","cat1"], "22/02/2015", 30, "P13", " ",
		1,"DIrector", "Rick y motthy")
		var cap3_3= new Chapter("cap 3", #["cat2","cat1"], "22/02/2015", 30, "P13", " ",
		1,"DIrector", "Rick y motthy")
		
		
		temp1.addChapter(cap1_1)
		temp2.addChapter(cap2_1)
		temp2.addChapter(cap2_2)
		temp3.addChapter(cap3_1)
		temp3.addChapter(cap3_2)
		temp3.addChapter(cap3_3)
		
		serie.addSeason(temp1)
		serie.addSeason(temp2)
		serie.addSeason(temp3)
		
		tf.addSerie(serie)
		tf.addUser(user)
		
		tf.watch(user, cap1_1)
		tf.watch(user, cap2_1)
		tf.watch(user, cap2_2)
		tf.watch(user, cap3_1)
		tf.watch(user, cap3_2)
		tf.watch(user, cap3_3)
		
		assertTrue(tf.hasSeenAllSeries(user,serie))
	}
	
		@Test
	def void test11(){
		val user1= new User("pepe_juan")
		val user4= new User("ni_pepe_ni_juan")
		val serie= new Series("Rick & Morthy", #["cat2","cat1"], "22/02/2015", 30, "P13", "youyube.com/R&M","creador")
		val tf= new TraiFlix()		
		
		tf.addUser(user1)
		tf.addUser(user4)
		tf.addSerie(serie)
	
		tf.addFriend(user1, user4)
	
		tf.acceptFriendsRequest(user1, user4)

		tf.recommendContent(user1, user4,serie)
		System.out.println(user4.suggested_content)
		
		assertTrue( user4.suggested_content.contains(serie))
	}
	
	@Test
	def void test12(){
		val serie= new Series("Rick & Morthy", #["cat2","cat1"], "22/02/2015", 30, "P13", "youyube.com/R&M","creador")
		val tf= new TraiFlix()	
			
		val temp1= new Season(1)
		var cap1_1= new Chapter("cap 1", #["cat2","cat1"], "22/02/2015", 30, "P13", " ",
		1,"DIrector", "Rick y motthy")
		
		val temp2= new Season(2)
		var cap2_1= new Chapter("cap 1", #["cat2","cat1"], "22/02/2015", 30, "P13", " ",
		1,"DIrector", "Rick y motthy")
		var cap2_2= new Chapter("cap 2", #["cat2","cat1"], "22/02/2015", 30, "P13", " ",
		1,"DIrector", "Rick y motthy")
		
		val temp3= new Season(3)
		var cap3_1= new Chapter("cap 1", #["cat2","cat1"], "22/02/2015", 30, "P13", " ",
		1,"DIrector", "Rick y motthy")
		var cap3_2= new Chapter("cap 2", #["cat2","cat1"], "22/02/2015", 30, "P13", " ",
		1,"DIrector", "Rick y motthy")
		var cap3_3= new Chapter("cap 3", #["cat2","cat1"], "22/02/2015", 30, "P13", " ",
		1,"DIrector", "Rick y motthy")
		
		
		temp1.addChapter(cap1_1)
		temp2.addChapter(cap2_1)
		temp2.addChapter(cap2_2)
		temp3.addChapter(cap3_1)
		temp3.addChapter(cap3_2)
		temp3.addChapter(cap3_3)
		
		serie.addSeason(temp1)
		serie.addSeason(temp2)
		serie.addSeason(temp3)
		
		tf.addSerie(serie)
		
		tf.giveStarsToAChapter(5,cap1_1)
		tf.giveStarsToAChapter(1,cap1_1)
		tf.giveStarsToAChapter(5,cap2_1)
		tf.giveStarsToAChapter(3,cap2_2)
		tf.giveStarsToAChapter(4,cap3_1)
		tf.giveStarsToAChapter(1,cap3_1)
		tf.giveStarsToAChapter(2,cap2_1)
		tf.giveStarsToAChapter(5,cap1_1)
		tf.giveStarsToAChapter(5,cap3_3)
		tf.giveStarsToAChapter(2,cap3_3)
		tf.giveStarsToAChapter(4,cap3_3)
		tf.giveStarsToAChapter(1,cap3_3)
		tf.starsOfSerie(serie)
		
		assertTrue(tf.starsOfSerie(serie)== 3.0)
	}
}











