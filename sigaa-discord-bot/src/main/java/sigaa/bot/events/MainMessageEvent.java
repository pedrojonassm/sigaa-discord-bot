package sigaa.bot.events;

import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MainMessageEvent extends ListenerAdapter {
    private String aActivator;

    public MainMessageEvent(String prActivator) {
        aActivator = prActivator;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent prEvent) {
        /*
         * // [PM] Pedrojonassm: oi if (event.isFromType(ChannelType.PRIVATE)) System.out.printf("[PM] %s: %s\n",
         * event.getAuthor().getName(), event.getMessage().getContentDisplay()); // [Passa o Link Discord][『💬』chat] Pedrojonassm: teste
         * else System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(), event.getTextChannel().getName(),
         * event.getMember().getEffectiveName(), event.getMessage().getContentDisplay());
         */
        Message lMessage = prEvent.getMessage();
        if (!lMessage.getContentRaw().startsWith(aActivator))
            return;
        String lContent = lMessage.getContentRaw().substring(1);
        if (lContent.equals("ola")) {
            MessageChannel lMessageChannel = prEvent.getChannel();
            lMessageChannel.sendMessage("Hello World!").queue();
        } else if (lContent.equals("delete")) {
            MessageChannel lMessageChannel = prEvent.getChannel();
            lMessageChannel.sendMessage("Essa mensagem vai se auto-destruir").delay(10, TimeUnit.SECONDS)
                    .flatMap((it) -> it.editMessage("2 segundos")).delay(2, TimeUnit.SECONDS).flatMap(Message::delete).queue();
        }
    }

}
