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
public class WordNoun {//ワード・ナウン(名詞)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String word;
    
    public WordNoun(Integer id, String word) {
        this.id = id;
        this.word = word;
    }
}
