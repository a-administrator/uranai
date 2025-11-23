
package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WordNounRepository extends JpaRepository
<WordNoun, Integer> {
	@Query(value = "SELECT * FROM word_noun ORDER BY RAND() LIMIT 1", nativeQuery = true)
	WordNoun findRandom();

}
//ワード・ナウン(名詞)