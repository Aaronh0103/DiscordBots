package de.maxkroner.implementation;
import sx.blah.discord.api.events.Event;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.DisconnectedEvent;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.impl.obj.Message;
import sx.blah.discord.handle.impl.obj.User;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.Image;
import sx.blah.discord.util.MessageBuilder;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;


public class JokeBot extends BaseBot{
	private static final String bot_name = "JokeBot";
	private static final String bot_status = "Lachflash";
	private static final String profile_image_url = "https://s-media-cache-ak0.pinimg.com/736x/b6/cc/b0/b6ccb09b0cc1de2b2d491798f870ab6d.jpg";
	private static final String profile_image_imageType = "jpeg";
	
	public JokeBot(String token){
		super(token, bot_name, bot_status, profile_image_url, profile_image_imageType);
	}
	
	private void tellHitlerjoke(IChannel channel){
		User user = (User) client.getOurUser();
		IGuild guild = channel.getGuild();
		try {
			if (!user.getNicknameForGuild(guild).equals("Hitler")){
				user.addNick(guild.getID(), "Hitler");
			}
			new MessageBuilder(this.client).withChannel(channel).withContent("Wie hei�t Hitlers Lieblingschokolade? Nazipan.").build();
		} catch (DiscordException | RateLimitException | MissingPermissionsException e) {
			e.printStackTrace();
		}	
	}
	

	@EventSubscriber
	public void onReady(ReadyEvent event) {
		super.onReady(event);
		//TODO: Leute der Joke-Master ist online! Seit ihr ready f�r freshe Jokes?
	}
	
	@EventSubscriber
	public void onMessageReceivedEvent(MessageReceivedEvent event) {
		String message = event.getMessage().getContent();
		IChannel channel = event.getMessage().getChannel();
		
		if(message.equals("!joke hitler")){
			tellHitlerjoke(channel);
		} else if (message.equals("!change nick")){
			//TODO Change name to what follows
		}
		
	}

}
