package sigaa.bot.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import net.dv8tion.jda.api.JDABuilder;
import sigaa.bot.events.MainEvent;
import sigaa.bot.events.MainMessageEvent;

public class SigaaBot {
    public static void main(String[] args) {
        File lFile = new File("/discord/bot/token.txt");
        if (!lFile.exists()) {
            lFile.mkdirs();
            lFile.delete();
            try {
                lFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Coloque o token no arquivo: " + lFile.getAbsolutePath());
            return;
        }
        try {
            BufferedReader lBufferedReader = new BufferedReader(new FileReader(lFile));
            String lToken = lBufferedReader.readLine();
            JDABuilder lBuilder = JDABuilder.createDefault(lToken);
            MainEvent lMainEvent = new MainEvent();
            MainMessageEvent lMainMessageEvent = new MainMessageEvent("!");
            lBuilder.addEventListeners(lMainEvent);
            lBuilder.addEventListeners(lMainMessageEvent);

            lBuilder.build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
