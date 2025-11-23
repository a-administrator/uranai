
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private WordAdjectiveRepository adjectiveRepo;

    @Autowired
    private WordNounRepository nounRepo;

    @Override
    public void run(String... args) throws Exception {

       /* // ✅ 形容詞データを仮で追加
        adjectiveRepo.save(new WordAdjective(null, "やさしい"));
        adjectiveRepo.save(new WordAdjective(null, "あざやかな"));
        adjectiveRepo.save(new WordAdjective(null, "つよめの"));
        adjectiveRepo.save(new WordAdjective(null, "ふしぎな"));

        // ✅ 名詞データを仮で追加
        nounRepo.save(new WordNoun(null, "ゴリラ"));
        nounRepo.save(new WordNoun(null, "アメーバ"));
        nounRepo.save(new WordNoun(null, "魔術師"));
        nounRepo.save(new WordNoun(null, "カッパ"));*/
    }
}
