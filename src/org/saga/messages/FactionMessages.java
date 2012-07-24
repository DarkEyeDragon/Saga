package org.saga.messages;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import org.bukkit.ChatColor;
import org.saga.commands.FactionCommands;
import org.saga.config.FactionConfiguration;
import org.saga.config.ProficiencyConfiguration;
import org.saga.factions.FactionManager;
import org.saga.factions.SagaFaction;
import org.saga.messages.PlayerMessages.ColorCircle;
import org.saga.player.Proficiency;
import org.saga.player.Proficiency.ProficiencyType;
import org.saga.player.ProficiencyDefinition;
import org.saga.player.SagaPlayer;
import org.saga.utility.text.StringTable;
import org.saga.utility.text.TextUtil;


public class FactionMessages {

public static ChatColor positiveHighlightColor = ChatColor.GREEN;
	


	// Colors:
	public static ChatColor veryPositive = ChatColor.DARK_GREEN; // DO NOT OVERUSE.

	public static ChatColor positive = ChatColor.GREEN;

	public static ChatColor negative = ChatColor.RED;

	public static ChatColor veryNegative = ChatColor.DARK_RED; // DO NOT OVERUSE.

	public static ChatColor unavailable = ChatColor.DARK_GRAY;

	public static ChatColor anouncment = ChatColor.AQUA;

	public static ChatColor normal1 = ChatColor.GOLD;

	public static ChatColor normal2 = ChatColor.YELLOW;

	public static ChatColor frame = ChatColor.DARK_GREEN;

	

	// General restriction:
	public static String noPermission(SagaFaction faction){
		return faction.getColour2() + "You dont have permission from " + faction(faction, faction.getColour2()) + " to do that.";
	}

	public static String noFaction() {
		return negative + "You don't have a faction.";
	}
	
	public static String noFaction(String factionName) {
		return negative + "Faction " + factionName + " doesn't exist.";
	}
	
	public static String notFormed(SagaFaction faction) {

		return negative + "The faction isnt formed yet.";
		
	}
	
	public static String notFormedInfo(SagaFaction faction) {

		return normal1 + "The faction requires " + (FactionConfiguration.config().formationAmount-faction.getMemberCount()) + " more members.";
		
	}

	
	
	// Leveling:
	public static String factionLevelBcast(SagaFaction faction) {
		return anouncment + "Faction " + faction.getColour1() + faction.getName() + anouncment + " is now level " + faction.getLevel() + ".";
	}
	
	
	
	// Faction restriction:
	public static String mustSelectOneFaction() {
		return "You must have one faction selected.";
	}

	public static String oneFactionAllowed() {

		return negative + "You can only have one faction.";
		
	}
	
	public static String nonExistentFaction(String factionName) {
		return negative + factionName + " faction doesn't exist.";
	}
	
	public static String nonExistantFaction() {
		return negative + "Faction doesn't exist.";
	}

	public static String alreadyInFaction(SagaPlayer sagaPlayer) {
		return negative + sagaPlayer.getName() + " is already in a faction.";
	}
	
	public static String haveFaction() {
		return negative + "You are already in a faction.";
	}
	
	
	
	// Specific stats:
	public static String colour1Set(SagaFaction faction) {

		return faction.getColour2() + "Factions colour I set to " + faction.getColour1() + TextUtil.colour(faction.getColour1()) + faction.getColour2() + ".";
		
	}
	
	public static String colour2Set(SagaFaction faction) {

		return faction.getColour2() + "Factions colour II set to " + faction.getColour2() + TextUtil.colour(faction.getColour2()) + faction.getColour2() + ".";
		
	}
	

	
	// Create delete:
	public static String created(SagaFaction faction) {

		return faction.getColour2() + "Created " + faction(faction, faction.getColour2()) + " faction.";
		
	}
	
	public static String deleted(SagaFaction faction) {

		return faction.getColour2() + "Deleted " + faction(faction, faction.getColour2()) + " faction.";
		
	}
	
	public static String formed(SagaFaction faction) {

		
		StringBuffer rString = new StringBuffer();
		ArrayList<String> members = faction.getActiveMembers();
		
		for (int i = 0; i < members.size(); i++) {
			
			if(i != 0) rString.append(", ");
			
			rString.append(members.get(i));
			
		}
		
		if(members.size() == 0){
			rString.append("nobody formed");
		}else if(members.size() == 1){
			rString.append(" formed");
		}else{
			rString.append(" formed");
		}
		
		rString.append(" "+faction(faction, anouncment) + " faction.");
		
		
		return anouncment + rString.toString();
		
		
	}

	public static String disbanded(SagaFaction faction) {

		return anouncment + faction(faction, anouncment) + " faction was disbanded.";
		
	}
	

	
	// Invite join leave broadcasts:
	public static String beenInvited(SagaPlayer sagaPlayer, SagaFaction faction) {
		return faction.getColour2() + "You have been invited to " + faction.getColour1() + faction.getName() + faction.getColour2() + " faction.";
	}
	
	public static String invitedPlayer(SagaPlayer sagaPlayer, SagaFaction faction) {
		return faction.getColour2() + "" + sagaPlayer.getName() + " was invited to the faction.";
	}
	
	
	public static String joinedFaction(SagaPlayer sagaPlayer, SagaFaction faction) {
		return faction.getColour2() + "You joined " + faction.getColour1() + faction.getName() + faction.getColour2() + " faction.";
	}
	
	public static String playerJoined(SagaPlayer sagaPlayer, SagaFaction faction) {
		return faction.getColour2() + sagaPlayer.getName() + " has joined the faction.";
	}
	
	
	public static String quitFaction(SagaPlayer sagaPlayer, SagaFaction sagaFaction) {
		return sagaFaction.getColour2() + "You have quit your faction.";
	}
	
	public static String playerQuit(SagaPlayer sagaPlayer, SagaFaction sagaFaction) {
		return sagaFaction.getColour2() + sagaPlayer.getName() + " has quit the faction.";
	}

	
	public static String kickedFromFaction(SagaPlayer sagaPlayer, SagaFaction sagaFaction) {
		return sagaFaction.getColour2() + "You have been kicked out of your faction.";
	}
	
	public static String playerKicked(SagaPlayer sagaPlayer, SagaFaction sagaFaction) {
		return sagaFaction.getColour2() + sagaPlayer.getName() + " has been kicked from the faction.";
	}
	
	
	public static String cantKickYourself(SagaPlayer sagaPlayer, SagaFaction faction) {
		return negative + "Can't kick yourself from the faction.";
	}
	
	public static String cantKickOwner(SagaFaction faction) {
		return negative + "Can't kick the owner.";
	}
	
	
	public static String notFactionMember(SagaPlayer sagaPlayer, SagaFaction faction) {
		return negative + sagaPlayer.getName() + " isn't part of the faction.";
	}
	
	public static String notFactionMember(SagaFaction faction) {
		return negative + "You aren't part of the " + faction(faction, negative) + "faction.";
	}
	
	
	
	// Invite join leave:
	public static String noInvites() {
		return negative + "You don't have a faction invitation.";
	}
	
	public static String noInvites(String factionName) {
		return negative + "You don't have an invitation to " + factionName + " faction.";
	}
	
	public static String cantAcceptInvitations() {

		return negative + "You can't accept faction invitations.";
		
	}
	
	public static String declinedInvites() {
		return normal1 + "Declined all faction invitations.";
	}

	public static String pendingInvitations(SagaPlayer sagaPlayer, ArrayList<SagaFaction> factions) {
		
		
		StringBuffer rString = new StringBuffer();
		ChatColor messageColor = positiveHighlightColor;
		
		if(factions.size() == 0){
			return messageColor + "You don't have a pending faction invitation.";
		}
		
		rString.append(messageColor);
		
		rString.append("You have");
		
		if(factions.size() == 1){
			rString.append(" a pending invitation from ");
		}else{
			rString.append(" pending invitations from ");
		}
		
		for (int i = 0; i < factions.size(); i++) {
			if( i != 0 ) rString.append(", ");
			rString.append(factions.get(i).getColour1() + factions.get(i).getName() + messageColor);
		}
		
		if(factions.size() == 1){
			rString.append(" faction.");
		}else{
			rString.append(" factions.");
		}
		
		return rString.toString();
		
		
	}
	
	public static String cantInviteYourself(SagaPlayer sagaPlayer, SagaFaction faction) {
		return negative + "Yo dawg. I herd you like " + faction.getName() + ". So we invited you to your own faction, so you can be in your faction, while you are in your faction.";
	}

	public static String alreadyOwner() {
		return negative + "You already own the faction.";
	}
	
	public static String newOwner(SagaFaction faction, String name) {
		return faction.getColour2() + name + " is the new owner of the faction.";
	}
	
	public static String informAccept() {
		return normal1 + "Use /faccept to accept a faction invitation.";
	}
	
	
	
	// Other:
	public static String invalidName() {
		
		return negative + "Name must be " + FactionCommands.minimumNameLenght + "-" + FactionCommands.maximumNameLength + ". Letters and numbers only.";
		
	}

	public static String inUse(String name) {
		return negative + name + " is already in use.";
	}
	
	public static String invalidColor(String colourName) {
		
		return negative + colourName +" isn't a valid colour.";
		
	}
	
	public static String possibleColors(ChatColor[] colours, SagaFaction faction) {
		
		
		StringBuffer rString = new StringBuffer();
		
		if(colours.length == 0){
			rString.append("Possible colours: none");
		}else if(colours.length == 1){
			rString.append("Possible colour: ");
		}else{
			rString.append("Possible colours: ");
		}
		
		for (int i = 0; i < colours.length; i++) {
			
			if( i!= 0) rString.append(", ");
			
			rString.append(colours[i].name().toLowerCase().replace("_", " "));
			
		}
		
		
		rString.insert(0, faction.getColour2());
		
		return rString.toString();
		
		
	}
	

	
	// Stats:
	public static String stats(SagaFaction faction, Integer page) {
		
		
		StringBuffer result = new StringBuffer();
		
		switch (page) {

			// Ranks:	
			case 1:
				
				result.append(listMembers(faction));
				
				break;
				
			// Main stats:
			default:
				
				page = 0;
				
				// Levels and claims:
				result.append(main(faction).createTable());
				
				result.append("\n");
				result.append("\n");
				
				// Allies:
				result.append(allies(faction));
				
				break;
				
		}
		
		return TextUtil.frame(faction.getName() + " stats " + (page + 1) + "/" + 2, result.toString(), faction.getColour2());

		
	}
	
	private static StringTable main(SagaFaction faction){
		
		
		ColorCircle colours = new ColorCircle().addColor(faction.getColour2());
		StringTable table = new StringTable(colours);
		
		// Colours:
		table.addLine("colour I", faction.getColour1() + TextUtil.colour(faction.getColour1()), 0);
		
		// Building points:
		table.addLine("colour II", faction.getColour2() + TextUtil.colour(faction.getColour2()), 0);
		
		// Owner:
		if(faction.hasOwner()){
			table.addLine("owner", faction.getOwner(), 0);
		}else{
			table.addLine("owner", veryNegative + "none", 0);
		}
		
		// Level:
		table.addLine("level", faction.getLevel() + "/" + faction.getDefinition().getMaxLevel(), 2);

		// Next exp:
		table.addLine("next EXP", faction.getRemainingExp().intValue() + "", 2);

		table.collapse();
		
		return table;
		
		
	}
	
	private static String allies(SagaFaction faction){
		
		
		StringBuffer result = new StringBuffer();

		ArrayList<String> allies = FactionManager.manager().getFactionNames(faction.getAllies());
		ArrayList<String> allyInvites = FactionManager.manager().getFactionNames(faction.getAllyInvites());
		
		// Allies:
		result.append("allies: ");
		if(allies.size() > 0){
			result.append(TextUtil.flatten(allies));
		}else{
			result.append("none");
		}

		// Ally invites:
		if(allyInvites.size() > 0){
			
			result.append("\n");
			result.append("ally invites: " + TextUtil.flatten(allyInvites));
			
		}
		
		return result.toString();
		
		
	}
	
	private static String listMembers(SagaFaction faction){
		
		
		StringBuffer result = new StringBuffer();
		
		ChatColor general = normal1;
		ChatColor normal = normal2;
		
		int hMin = faction.getDefinition().getHierarchyMin();
		int hMax = faction.getDefinition().getHierarchyMax();
		
		// Hierarchy levels:
		for (int hierarchy = hMax; hierarchy >= hMin; hierarchy--) {
			
			if(result.length() > 0){
				result.append("\n");
				result.append("\n");
			}
			
			// Group name:
			String groupName = faction.getDefinition().getHierarchyName(hierarchy);
			if(groupName.length() == 0) groupName = "-";
			result.append(GeneralMessages.tableTitle(general + groupName));
			
			// Rank amounts:
			if(hierarchy != faction.getDefinition().getHierarchyMin()){
				
				String amounts = faction.getUsedRanks(hierarchy) + "/" + faction.getAvailableRanks(hierarchy);
				
				if(faction.isRankAvailable(hierarchy)){
					amounts = positive + amounts;
				}else{
					amounts = negative + amounts;
				}
				
				result.append(" " + amounts);
				
			}else{
				
				String amounts = faction.getUsedRanks(hierarchy) + "/-";
				result.append(" " + amounts);
				
			}
			
			// All ranks:
			StringBuffer resultRanks = new StringBuffer();
			
			ArrayList<ProficiencyDefinition> ranks = ProficiencyConfiguration.config().getDefinitions(ProficiencyType.RANK, hierarchy);
			
			for (ProficiencyDefinition definition : ranks) {
				
				// Members:
				if(resultRanks.length() > 0) resultRanks.append("\n");
				
				String roleName = definition.getName();
				ArrayList<String> members = faction.getMembersForRanks(roleName);
				
				// Colour members:
				colourMembers(members, faction);
				
				// Add members:
				resultRanks.append(normal);
				
				resultRanks.append(roleName + ": ");
				
				if(members.size() != 0){
					resultRanks.append(TextUtil.flatten(members));
				}else{
					resultRanks.append("none");
				}
				
			}
			
			result.append("\n");
			
			// Add roles:
			result.append(resultRanks);
			
		}
		
		return result.toString();
		
		
	}

	private static void colourMembers(ArrayList<String> members, SagaFaction faction){
		
		for (int i = 0; i < members.size(); i++) {
			members.set(i, member(members.get(i), faction));
		}
		
	}
	
	private static String member(String name, SagaFaction faction){
		
		
		// Active:
		if(!faction.isMemberActive(name)){
			return unavailable + "" + ChatColor.STRIKETHROUGH + name + normal1;
		}
		
		// Offline:
		else if(!faction.isRegisteredMember(name)){
			return unavailable + name + normal1;
		}
		
		// Normal:
		else{
			return normal1 + name;
		}
		
		
	}

	
	
	// Rename:
	public static String renamedAnnounce(String oldName, String oldPrefix, SagaFaction faction) {

		return anouncment + oldName + "(" + oldPrefix + ")" + " faction was renamed to " + faction(faction, anouncment) + ".";
		
	}
	
	public static String renamed(SagaFaction faction) {

		return faction.getColour2() + "Faction was renamed to " + faction(faction, faction.getColour2()) + ".";
		
	}
	
	
	
	// Spawn:
	public static String noSpawn(SagaFaction faction) {
		
		return negative + "The faction spawn point hasn't been set.";
		
	}
	
	public static String newSpawn(SagaFaction faction) {
		
		return faction.getColour2() + "New faction spawn point has been set.";
		
	}

	
	
	// Ally:
	public static String sentAlliance(SagaFaction faction, SagaFaction target) {
		
		return faction.getColour2() + "An alliance request was sent to " + faction(target, faction.getColour2()) + " faction.";
		
	}
	
	public static String recievedAlliance(SagaFaction faction, SagaFaction source) {
		
		return faction.getColour2() + "Recieved an alliance request from " + faction(source, faction.getColour2()) + " faction.";
		
	}
	
	public static String recievedAllianceInfo(SagaFaction faction, SagaFaction target) {
		
		return normal1 + "Use /fallyaccept to accept and /fallydecline to decline the alliance request.";
		
	}

	public static String declinedAllianceRequest(SagaFaction faction, SagaFaction target) {
		
		return faction.getColour2() + "Alliance request from " + faction(target, faction.getColour2()) + " faction was declined.";
		
	}
	
	public static String formedAllianceBroadcast(SagaFaction faction, SagaFaction target) {
		
		return anouncment + "An alliance was formed between " + faction(faction, anouncment) + " and " + faction(target, anouncment) + " factions.";
		
	}
	
	public static String brokeAllianceBroadcast(SagaFaction faction, SagaFaction target) {
		
		return anouncment + "An alliance was broken between " + faction(faction, anouncment) + " and " + faction(target, anouncment) + " factions.";
		
	}

	public static String selfAlliance(SagaFaction faction) {
		
		return negative + "Can't request an alliance from your own faction.";
		
	}
	
	public static String alreadyAlliance(SagaFaction faction, SagaFaction targetFaction) {
		
		return negative + "An alliance with " + faction(targetFaction, negative) + " is already formed.";
		
	}

	public static String noAllianceRequest(SagaFaction faction, String souceFaction) {
		
		return negative + "The faction doesn't have an alliance request from " + souceFaction + " faction.";
		
	}
	
	public static String noAlliance(SagaFaction faction, SagaFaction targetFaction) {
		
		return negative + "No alliance formed with " + faction(targetFaction, negative) + " faction.";
		
	}
	
	public static String noAllianceRequest(SagaFaction faction) {
		
		return negative + "The faction doesn't have alliance requests.";
		
	}

	
	
	// List:
	public static String list(SagaFaction faction) {
		
		
		StringBuffer rString = new StringBuffer();
		
		// Online total inactive:
		if(faction.getMemberCount() > 0){
			
			if(rString.length() > 0) rString.append("\n");
			
			rString.append(faction.getColour2() + "Online: " + faction.getRegisteredMemberCount() + "/" + faction.getMemberCount());

			int inactiveCount = faction.getInactiveMemberCount();
			if(inactiveCount != 0){
				rString.append(" Inactive: " + inactiveCount);
			}
			
		}
		
		// Players:
		if(faction.getMemberCount() > 0){
			
			if(rString.length() > 0) rString.append("\n");
			
			rString.append( listPlayersElement(faction, faction.getColour2()) );

		}
		
		return TextUtil.frame(faction(faction, faction.getColour2()) + " members", rString.toString(), faction.getColour2());
		
		
	}
	
	private static String listPlayersElement(SagaFaction faction, ChatColor messageColor){
		

		// Fill roles table:
		Integer maxHierarchyLevel = 0;
		Hashtable<Integer, Hashtable<String, ArrayList<String>>> roleTable = new Hashtable<Integer, Hashtable<String,ArrayList<String>>>();
		ArrayList<String> zeroHighlMembers = new ArrayList<String>(faction.getMembers());
		for (int i = 0; i < zeroHighlMembers.size(); i++) {
			String name = zeroHighlMembers.get(i);
			Proficiency role = faction.getRank(name);
			if(role == null) continue;
			zeroHighlMembers.remove(i);
			i--;
			String roleName = role.getName();
			Integer hierarchyLevel = role.getHierarchy();
			
			// Hierarchy:
			if(hierarchyLevel > maxHierarchyLevel){
				maxHierarchyLevel = hierarchyLevel;
			}
			
			// Hierarchy level:
			Hashtable<String, ArrayList<String>> hierLevelRoles = roleTable.get(hierarchyLevel);
			if(hierLevelRoles == null){
				hierLevelRoles = new Hashtable<String, ArrayList<String>>();
				roleTable.put(hierarchyLevel, hierLevelRoles);
			}

			// Player names:
			ArrayList<String> playerNames = hierLevelRoles.get(roleName);
			if(playerNames == null){
				playerNames = new ArrayList<String>();
				hierLevelRoles.put(roleName, playerNames);
			}
			
			// Add:
			playerNames.add(name);
			
		}
		
		StringBuffer rString = new StringBuffer();
		
		// Add above zero highlight players:
		for (Integer i = maxHierarchyLevel ; i >= 0 ; i--) {
			
			// All roles for hierarchy level:
			Hashtable<String, ArrayList<String>> highlRoles = roleTable.get(i);
			if(highlRoles == null) continue;
			
			if(rString.length() != 0){
				rString.append("\n");
			}
			
			// All roles:
			Enumeration<String> roleNames = highlRoles.keys();
			StringBuffer eString = new StringBuffer();
			while(roleNames.hasMoreElements()){
				
				String roleName = roleNames.nextElement();
				ArrayList<String> playerNames = highlRoles.get(roleName);
				
				// Title:
				if(eString.length() != 0){
					eString.append(" ");
				}
				if(playerNames.size() == 1){
					eString.append(TextUtil.capitalize(roleName) + ": ");
				}else{
					eString.append(TextUtil.capitalize(roleName + "s") + ": ");
				}
				
				// Names:
				for (int j = 0; j < playerNames.size(); j++) {
					if( j != 0 ) eString.append(", ");
					eString.append( playerNameElement(playerNames.get(j), faction, messageColor, faction.isMemberActive(playerNames.get(j))) );
				}
				
			}
			rString.append(eString);
			
		}
		
		// Add zero highlight players:
		if(zeroHighlMembers.size() > 0){
			
			if(rString.length() > 0){
				rString.append("\n");
			}
			
			for (int i = 0; i < zeroHighlMembers.size(); i++) {
				if(i != 0) rString.append(", ");
				rString.append(playerNameElement(zeroHighlMembers.get(i), faction, messageColor, faction.isMemberActive(zeroHighlMembers.get(i))) );
			}
			
		}
		
		return messageColor + rString.toString();
		
		
	}

	private static String playerNameElement(String playerName, SagaFaction faction, ChatColor messageColor, boolean isActive){
		
		
		StringBuffer rString = new StringBuffer();
		ChatColor offlineColor = ChatColor.GRAY;
		ChatColor inactiveColor = ChatColor.DARK_GRAY;
		
		// Name:
		if(!isActive){
			
			rString.append(inactiveColor + playerName + messageColor);
			
		}
		else if(!faction.isRegisteredMember(playerName)){
			
			rString.append(offlineColor + playerName + messageColor);
			
		}
		else{
		
			rString.append(faction.getColour1() + playerName + messageColor);
			
		}
		
		return rString.toString();
		
		
	}

	
	
	// Info:
	public static String wrongQuit() {
		
		return negative + "Because /squit and /fquit are similar, this command isn't used. Please use /factionquit instead.";
		
	}
	
	
	
	// Rank:
	public static String newRank(SagaFaction faction, String rankName, SagaPlayer targetPlayer) {
		
		return faction.getColour2() + targetPlayer.getName() + " is now a " + rankName + ".";
		
	}
	
	public static String invalidRank(String rankName) {
		
		return negative + "Rank " + rankName + " is invalid.";
		
	}
	
	public static String rankUnavailable(SagaFaction faction, String rankName) {
		
		return negative + rankName + " rank isn't available.";
		
	}
	
	
	
	// Utility:
	public static String faction(SagaFaction faction, ChatColor messageColor) {
		
		return faction.getColour1() + faction.getName() + messageColor;
		
	}
	
	public static String rankedPlayer(SagaFaction faction, SagaPlayer sagaPlayer) {

		Proficiency rank = faction.getRank(sagaPlayer.getName());
		
		if(rank == null){
			return sagaPlayer.getName();
		}else{
			return rank.getName() + " " + sagaPlayer.getName();
		}
		
	}
	
	
}
