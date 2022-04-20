package sigaa.bot.events;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class MainEvent implements EventListener {

    public void onEvent(GenericEvent event) {
        if (event instanceof ReadyEvent)
            System.out.println("Bot iniciado com sucesso!");
    }

}
