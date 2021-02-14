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
        		.createDefault("ODEwNDY2NTg3Njg0ODk2Nzkw.YCkD1A.W5xqwfShVpw0H3LS_gL_Rdc72mk");
        JDA jda = builder
        		.addEventListeners(new Bot())
        		.build();
    }
}
