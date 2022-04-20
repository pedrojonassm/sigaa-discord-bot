package sigaa.bot.main;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import sigaa.bot.events.MainEvent;
import sigaa.bot.events.MainMessageEvent;

public class SigaaBot {
    public static void main(String[] args) {
        String lToken = "";
        JDABuilder lBuilder = JDABuilder.createDefault(lToken);
        MainEvent lMainEvent = new MainEvent();
        MainMessageEvent lMainMessageEvent = new MainMessageEvent("!");
        lBuilder.addEventListeners(lMainEvent);
        lBuilder.addEventListeners(lMainMessageEvent);

        try {
            lBuilder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
