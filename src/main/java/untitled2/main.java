package untitled2;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import io.github.cdimascio.dotenv.Dotenv;

public class main {
    public static void main(final String[] args){
        //System.out.println("Hello, Java!");
        Dotenv dotenv = Dotenv.load();
        final   String token = dotenv.get("DISCORD_TOKEN");
        //final String token = "ODg1ODA4NTgxMTU5NTc5NjU4.YTsbhw.m0HCGiTwH5XBKLRDrR0RyPY78rg";
        final DiscordClient client = DiscordClient.create(token);
        final GatewayDiscordClient gateway = client.login().block();

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            final Message message = event.getMessage();
            if ("!ping".equals(message.getContent())){
                final MessageChannel channel = message.getChannel().block();
                channel.createMessage("Pong!").block();
            }
        });

        gateway.onDisconnect().block();
    }
}
