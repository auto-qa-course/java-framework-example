package commonLibs.utils;
import io.qameta.allure.Link;
import io.qameta.allure.Story;

@Story("Story 123 'As a system admin I want to be able create users using REST API'" )
@Link(value = "123", type = "backlog_tracker")
public @interface StoryLink{
    String value() default "";
}