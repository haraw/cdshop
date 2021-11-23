package com.example.cdshop;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.cdshop.domain.Cd;
import com.example.cdshop.domain.CdRepository;
import com.example.cdshop.domain.GenreRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CdRepositoryTest {
	
	@Autowired
	private CdRepository cdrepository;
	
	@Autowired
	private GenreRepository genrerepository;
	
	@Test
	public void findByAlbumTest() {
		List<Cd> cds = cdrepository.findByAlbum("fragile");
		
		assertThat(cds).hasSize(1);
		assertThat(cds.get(0).getBand()).isEqualTo("Yes");
	}
	
	@Test
	public void createNewCd() {
		Cd cd = new Cd("Album", "Band", 1999, 20.20, genrerepository.findByName("Pop").get(0));
		cdrepository.save(cd);
		assertThat(cd.getId()).isNotNull();
	}
	
	@Test
	public void deleteNewCd() {
		List<Cd> cds = cdrepository.findByAlbum("Fragile");
		Cd cd = cds.get(0);
		cdrepository.delete(cd);
		List<Cd> newCd = cdrepository.findByAlbum("Fragile");
		assertThat(newCd).hasSize(0);
	}

}
