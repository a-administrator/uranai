
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

       // 形容詞データ
        adjectiveRepo.save(new WordAdjective(null, "ラーメン大好きな"));
        adjectiveRepo.save(new WordAdjective(null, "屈強な"));
        adjectiveRepo.save(new WordAdjective(null, "うどんっぽい"));
        adjectiveRepo.save(new WordAdjective(null, "麻雀で安上がりな"));
        adjectiveRepo.save(new WordAdjective(null, "ドケチな"));
        adjectiveRepo.save(new WordAdjective(null, "気弱な"));
        adjectiveRepo.save(new WordAdjective(null, "すぐ走り出す"));
        adjectiveRepo.save(new WordAdjective(null, "有形文化財的な"));
        adjectiveRepo.save(new WordAdjective(null, "足し算と引き算ができない"));
        adjectiveRepo.save(new WordAdjective(null, "賞味期限が長い"));
        adjectiveRepo.save(new WordAdjective(null, "地面に潜りがちな"));
        adjectiveRepo.save(new WordAdjective(null, "片足立ちが上手な"));

        // 名詞データ
        nounRepo.save(new WordNoun(null, "マヌルネコ"));
        nounRepo.save(new WordNoun(null, "さっき細胞分裂したアメーバ"));
        nounRepo.save(new WordNoun(null, "チベットスナギツネ"));
        nounRepo.save(new WordNoun(null, "傘"));
        nounRepo.save(new WordNoun(null, "マウンテンゴリラ"));
        nounRepo.save(new WordNoun(null, "洗濯板"));
        nounRepo.save(new WordNoun(null, "クリオネ"));
        nounRepo.save(new WordNoun(null, "ドラム式洗濯機"));
        nounRepo.save(new WordNoun(null, "テレビのリモコン"));
        nounRepo.save(new WordNoun(null, "歯の治療"));
        nounRepo.save(new WordNoun(null, "心斎橋駅"));
        nounRepo.save(new WordNoun(null, "笹"));
        nounRepo.save(new WordNoun(null, "アルパカのひづめ"));
    }
}
