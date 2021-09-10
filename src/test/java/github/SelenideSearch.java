package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSearch {
    @Test
    void shouldFindSelenideRepositorePage() { //слово Test необязательно при испо-ии gradle, в maven обязательно
        //открыть страницу гитхаб
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        // $$(".repo-list li").first().$("a").click(); //ищем коллекцию элементов, берем из нее первый внутри него ищем еще
        var ListOfRepos = $$(".repo-list li");
        //Нажимаем на линк от первого результата поиска
        ListOfRepos.first().$("a").click();
        //check: в заголовке встречается selenide/selenide
        $("h1").should(text("selenide / selenide"));

    }
}
