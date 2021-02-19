package vinimusbot.app;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Bot extends ListenerAdapter
{
    public static void main( String[] args ) throws LoginException
    {
        JDABuilder builder = JDABuilder
        		.createDefault("TOKEN"); //need to change to private repo to show token, will be in bot channel
        JDA jda = builder
        		.addEventListeners(new Bot())
        		.build();
    }
}
