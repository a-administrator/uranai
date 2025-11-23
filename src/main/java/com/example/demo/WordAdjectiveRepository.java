
package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WordAdjectiveRepository extends JpaRepository
<WordAdjective, Integer> {
	@Query(value = "SELECT * FROM word_adjective ORDER BY RAND() LIMIT 1"
			, nativeQuery = true)
	WordAdjective findRandom();

}
//ワード・アドジェクティブ(形容詞)
