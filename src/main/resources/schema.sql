-- render.com用

-- WordAdjective テーブルの定義　既に存在する場合に備えて一旦削除（初期化を確実にするため）
DROP TABLE IF EXISTS word_adjective;

CREATE TABLE word_adjective (
    -- id: 主キー、自動採番（H2の標準的な自動採番方法）
    id INT PRIMARY KEY AUTO_INCREMENT, 
    
    -- word: 形容詞の文字列。空欄を許さない (NOT NULL)
    word VARCHAR(255) NOT NULL 
);

-- WordNoun テーブルの定義 既に存在する場合に備えて一旦削除
DROP TABLE IF EXISTS word_noun;

CREATE TABLE word_noun (
    -- id: 主キー、自動採番
    id INT PRIMARY KEY AUTO_INCREMENT, 
    
    -- word: 名詞の文字列。空欄を許さない
    word VARCHAR(255) NOT NULL 
);