package sigaa.bot.main;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import sigaa.bot.events.MainEvent;
import sigaa.bot.events.MainMessageEvent;

public class SigaaBot {
    public static void main(String[] args) {
        String lToken = "OTY2MDg5NTAzNTIzNjI3MDE4.Yl8q9g.8oJGZqKucDsWqDkUfYDWdnxOzAc";
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
