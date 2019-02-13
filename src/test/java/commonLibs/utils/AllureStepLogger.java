package commonLibs.utils;
import io.qameta.allure.Step;


public final class AllureStepLogger {

    private AllureStepLogger() {}

    @Step("DEBUG: {0}")
    public static void log(final String message){
        //Should be empty, only step annotation will be used.
    }
}

