package de.maxkroner.implementation;

import java.util.List;
import java.util.Scanner;

import de.maxkroner.ui.BotMenue;
import de.maxkroner.ui.UserInput;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.obj.IExtendedInvite;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IUser;

public class ScamBot extends Bot {

	public ScamBot(String token, Scanner scanner, UserInput userInput) {
		super(token, new BotMenue(scanner, userInput));

	}
	
	@EventSubscriber
	public void onReady(ReadyEvent event) {
		super.onReady(event);
		
		printConnectedGuilds();
		
		printUsers();
		
		printInvites();

	}


	private void printConnectedGuilds() {
		
		List<IGuild> guilds = client.getGuilds();
		
		for (IGuild guild : guilds) {
			System.out.println(guild.getName());
		}
	}


	private void printInvites() {
		for (IGuild guild : client.getGuilds()) {
			List<IExtendedInvite> extendedInvites = guild.getExtendedInvites();
			
			for (IExtendedInvite extendedInvite : extendedInvites) {
				System.out.println(extendedInvite.getCode());
			}
		}
	}
	
	private void printUsers(){
		for (IGuild guild : client.getGuilds()) {
			List<IUser> users = guild.getUsers();
			System.out.println("Connected Users for guild " + guild.getName() + ":");
			for (IUser user : users) {
				System.out.println(user.getName() + "#" + user.getDiscriminator());
			}
		}	
	}




}