package vinimusbot.app;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import vinimusbot.app.API.Schedule.Schedule;

public class Bot extends ListenerAdapter {

    public static void main(String[] args) throws LoginException, InterruptedException, IOException {
        if (args.length < 1) {
            System.out.println("You have to provide a token as first argument!" + args[0]);
            System.exit(1);
        }
        Schedule schedule = new Schedule();
        schedule.fetchRacesCurentSeason();
        JDABuilder builder = JDABuilder.createDefault(args[0]);
        builder.addEventListeners(new Bot());
        builder.setActivity(Activity.playing("Agony"));

        JDA jda = builder.build();
        jda.awaitReady();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        Long time = System.currentTimeMillis();
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        ChannelType type = event.getChannelType();

        if (event.getAuthor().isBot()) {
            return;
        } else if (type.equals(ChannelType.PRIVATE)) {
            channel.sendMessage("Why are you whispering me, you weirdo?").queue();
        } else if (message.getContentRaw().startsWith("!")) {
            channel.sendMessage("Fuck off " + event.getAuthor().getName()
                    + " I don't care about your shitty message... " + event.getMessage().getContentDisplay())
                    .queue(response -> {
                        response.editMessageFormat("Hello " + event.getAuthor().getAsMention())
                                .delay(10, TimeUnit.SECONDS).flatMap(Message::delete);
                    });
        } else {
            System.out.println("NOPERS");
        }
    }
}
