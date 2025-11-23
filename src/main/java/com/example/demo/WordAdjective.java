package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Entity
@Data
public class WordAdjective {//ワード・アドジェクティブ(形容詞)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String word;
    
    public WordAdjective(Integer id, String word) {
        this.id = id;
        this.word = word;
    }
}

