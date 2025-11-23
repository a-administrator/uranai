
package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UranaiController {

	@Autowired
	private WordAdjectiveRepository adjectiveRepo;

	@Autowired
	private WordNounRepository nounRepo;

    @GetMapping("/")
    public String showForm() {
        return "uranai";  // templates/uranai.html を表示
    }
    
    @PostMapping("/uranai")
    @ResponseBody
    public String getUranaiResult(@RequestBody Map<String, Object> data) {

        String name = (String) data.get("name");
        String year = data.get("birthYear").toString();
        String month = data.get("birthMonth").toString();
        String day = data.get("birthDay").toString();

        String adj1 = adjectiveRepo.findRandom().getWord();
        String adj2 = adjectiveRepo.findRandom().getWord();

        String noun1 = nounRepo.findRandom().getWord();
        String noun2 = nounRepo.findRandom().getWord();
        String noun3 = nounRepo.findRandom().getWord();
        String noun4 = nounRepo.findRandom().getWord();
        String noun5 = nounRepo.findRandom().getWord();

        // ✅ 本番の占い文章
        String result = "<div>"+ year + "年" + month + "月" + day + "日生まれの<strong>"
        + name + "</strong>さんは、<br>"
                + adj1 + "ところと" + adj2 + "ところがあり、<br>"
                + noun1 + "に憧れていて" + noun2 + "が好き。<br>"
                + "油断してると" + noun3 + "になりかねないので、"
                + noun4 + "を心がけていれば<br>" + noun5 + "になれるでしょう。"
                + "</div>";

        return result;
    }


}
