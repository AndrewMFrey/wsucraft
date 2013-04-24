package org.wsucraft;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class WSUCraft extends JavaPlugin {
	private ArrayList<PotionEffect> pe;
	public void onEnable(){
		//Sets up all the effects needed for applying
		this.pe = new ArrayList<PotionEffect>();
		this.pe.add(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 1, true));
		this.pe.add(new PotionEffect(PotionEffectType.CONFUSION, Integer.MAX_VALUE, 1, true));
		this.pe.add(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 1, true));
		this.pe.add(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 1, true));
		this.pe.add(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1, true));
		this.pe.add(new PotionEffect(PotionEffectType.HUNGER, Integer.MAX_VALUE, 1, true));
		this.pe.add(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1, true));
		this.pe.add(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, true));
		this.pe.add(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1, true));
		this.pe.add(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1, true));
		this.pe.add(new PotionEffect(PotionEffectType.POISON, Integer.MAX_VALUE, 1, true));
		this.pe.add(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 1, true));
		this.pe.add(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 1, true));
		this.pe.add(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE, 1, true));
		this.pe.add(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, true));
		this.pe.add(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 1, true));
		this.pe.add(new PotionEffect(PotionEffectType.WEAKNESS, Integer.MAX_VALUE, 1, true));
		this.pe.add(new PotionEffect(PotionEffectType.WITHER, Integer.MAX_VALUE, 1, true));
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("wsucraft") || label.equalsIgnoreCase("wsu")){
			if (args.length == 0){
				sender.sendMessage("A plugin to handle any extra needs that WSUCraft has.\nAt this point, it is used to apply potion effects to users.\nSee '/wsucraft help' for assistance.");
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("help")) {
					//calls for help
					sender.sendMessage(ChatColor.DARK_GRAY + "/wsucraft" + ChatColor.RED + " <POTIONEFFECT> <TRUE|FALSE|T|F> [PLAYER]" + ChatColor.RESET + "\nPossible potion effects:\nblind - confuse - prot - dig - fireprot - hunger - strength\ninvis - jump - poison - night - regen - slow - slowdig\nspeed - underwater - weakness - wither");
					return true;
				} else {
					sender.sendMessage("See /WSUCraft help");
				}
			}
			//Checks argument length
			if (args.length > 1 && args.length < 4) {
				//If we have no player name offered, assume sender.
				Player player = null;
				if (args.length < 3) {
					//Checks for Console sender that lacks a player name.
					if (sender instanceof ConsoleCommandSender) {
						sender.sendMessage("This command must be run by a player, or on a player.");
						return true;
					}
					player = (Player) sender;
				} else {
					//If we do have a player name, check to see if the player is online. If they are, use the name.
					player = Bukkit.getPlayer(args[2]);
					if (player == null){
						sender.sendMessage("That player is not online");
						return true;
					}
				}
				if (args[1].equalsIgnoreCase("true") || args[1].equalsIgnoreCase("t")){
					// adding the potion effects
					switch (args[0].toLowerCase()){
						case "blind":
							//Checks to see if sender either has the permission, or is the console, which doesn't need perms
							if (sender.hasPermission("wsucraft.blind") || sender instanceof ConsoleCommandSender) {
								this.pe.get(0).apply(player);
								player.sendMessage(ChatColor.GREEN + "Your vision has become clouded.");
								break;
							} else {
								sender.sendMessage("Sorry. You don't have permission for this.");
							}
						case "confuse":
							if (sender.hasPermission("wsucraft.confuse") || sender instanceof ConsoleCommandSender) {
								this.pe.get(1).apply(player);
								player.sendMessage(ChatColor.GREEN + "Your thoughts are now muddled.");
								break;
							} else {
								sender.sendMessage("Sorry. You don't have permission for this.");
							}
						case "prot":
							if (sender.hasPermission("wsucraft.prot") || sender instanceof ConsoleCommandSender) {
								this.pe.get(2).apply(player);
								player.sendMessage(ChatColor.GREEN + "Your skin hardens.");
								break;
							} else {
								sender.sendMessage("Sorry. You don't have permission for this.");
							}
						case "dig":
							if (sender.hasPermission("wsucraft.dig") || sender instanceof ConsoleCommandSender) {
								this.pe.get(3).apply(player);
								player.sendMessage(ChatColor.GREEN + "Your tools feel lighter.");
								break;
							} else {
								sender.sendMessage("Sorry. You don't have permission for this.");
							}
						case "fireprot":
							if (sender.hasPermission("wsucraft.fireprot") || sender instanceof ConsoleCommandSender) {
								this.pe.get(4).apply(player);
								player.sendMessage(ChatColor.GREEN + "You no longer fear lava.");
								break;
							} else {
								sender.sendMessage("Sorry. You don't have permission for this.");
							}
						case "hunger":
							if (sender.hasPermission("wsucraft.hunger") || sender instanceof ConsoleCommandSender) {
								this.pe.get(5).apply(player);
								player.sendMessage(ChatColor.GREEN + "Nothing will sate your hunger.");
								break;
							} else {
								sender.sendMessage("Sorry. You don't have permission for this.");
							}
						case "strength":
							if (sender.hasPermission("wsucraft.strength") || sender instanceof ConsoleCommandSender) {
								this.pe.get(6).apply(player);
								player.sendMessage(ChatColor.GREEN + "Your weapons feel lighter.");
								break;
							} else {
								sender.sendMessage("Sorry. You don't have permission for this.");
							}
						case "invis":
							if (sender.hasPermission("wsucraft.invis") || sender instanceof ConsoleCommandSender) {
								this.pe.get(7).apply(player);
								player.sendMessage(ChatColor.GREEN + "Light bends around you.");
								break;
							} else {
								sender.sendMessage("Sorry. You don't have permission for this.");
							}
						case "jump":
							if (sender.hasPermission("wsucraft.jump") || sender instanceof ConsoleCommandSender) {
								this.pe.get(8).apply(player);
								player.sendMessage(ChatColor.GREEN + "Nothing can hold you down.");
								break;
							} else {
								sender.sendMessage("Sorry. You don't have permission for this.");
							}
						case "night":
							if (sender.hasPermission("wsucraft.night") || sender instanceof ConsoleCommandSender) {
								this.pe.get(9).apply(player);
								player.sendMessage(ChatColor.GREEN + "You have been granted sight beyond sight.");
								break;
							} else {
								sender.sendMessage("Sorry. You don't have permission for this.");
							}
						case "poison":
							if (sender.hasPermission("wsucraft.poison") || sender instanceof ConsoleCommandSender) {
								this.pe.get(10).apply(player);
								player.sendMessage(ChatColor.GREEN + "A  mysterious sickness has appeared.");
								break;
							} else {
								sender.sendMessage("Sorry. You don't have permission for this.");
							}
						case "regen":
							if (sender.hasPermission("wsucraft.regen") || sender instanceof ConsoleCommandSender) {
								this.pe.get(11).apply(player);
								player.sendMessage(ChatColor.GREEN + "No injury can bring you down.");
								break;
							} else {
								sender.sendMessage("Sorry. You don't have permission for this.");
							}
						case "slow":
							if (sender.hasPermission("wsucraft.slow") || sender instanceof ConsoleCommandSender) {
								this.pe.get(12).apply(player);
								player.sendMessage(ChatColor.GREEN + "Lethargy consumes you.");
								break;
							} else {
								sender.sendMessage("Sorry. You don't have permission for this.");
							}
						case "slowdig":
							if (sender.hasPermission("wsucraft.slowdig") || sender instanceof ConsoleCommandSender) {
								this.pe.get(13).apply(player);
								player.sendMessage(ChatColor.GREEN + "Your tools feel heavier.");
								break;
							} else {
								sender.sendMessage("Sorry. You don't have permission for this.");
							}
						case "speed":
							if (sender.hasPermission("wsucraft.speed") || sender instanceof ConsoleCommandSender) {
								this.pe.get(14).apply(player);
								player.sendMessage(ChatColor.GREEN + "You feel energized.");
								break;
							} else {
								sender.sendMessage("Sorry. You don't have permission for this.");
							}
						case "underwater":
							if (sender.hasPermission("wsucraft.underwater") || sender instanceof ConsoleCommandSender) {
								this.pe.get(15).apply(player);
								player.sendMessage(ChatColor.GREEN + "You grow gills.");
								break;
							} else {
								sender.sendMessage("Sorry. You don't have permission for this.");
							}
						case "weakness":
							if (sender.hasPermission("wsucraft.weakness") || sender instanceof ConsoleCommandSender) {
								this.pe.get(16).apply(player);
								player.sendMessage(ChatColor.GREEN + "Your weapons feel heavier.");
								break;
							} else {
								sender.sendMessage("Sorry. You don't have permission for this.");
							}
						case "wither":
							if (sender.hasPermission("wsucraft.wither") || sender instanceof ConsoleCommandSender) {
								this.pe.get(17).apply(player);
								player.sendMessage(ChatColor.GREEN + "You begin to decay.");
								break;
							} else {
								sender.sendMessage("Sorry. You don't have permission for this.");
							}
						default:
							sender.sendMessage("See /WSUCraft help");
							return true;
					}
					if (!(sender instanceof ConsoleCommandSender) && !((Player)sender).equals(player)) {
						sender.sendMessage("You used " + ChatColor.AQUA + args[0] + " " + args[1] + ChatColor.RESET + " on " + player.getName());
					}
				} else if (args[1].equalsIgnoreCase("false") || args[1].equalsIgnoreCase("f")) {
					// removing the potion effects
					switch (args[0].toLowerCase()){
						case "blind":
							if (sender.hasPermission("wsucraft.blind") || sender instanceof ConsoleCommandSender) {
								player.removePotionEffect(PotionEffectType.BLINDNESS);
								player.sendMessage(ChatColor.GREEN + "Your vision has returned to normal.");
								break;
							}
						case "confuse":
							if (sender.hasPermission("wsucraft.confuse") || sender instanceof ConsoleCommandSender) {
								player.removePotionEffect(PotionEffectType.CONFUSION);
								player.sendMessage(ChatColor.GREEN + "You can think clearly again.");
								break;
							}
						case "prot":
							if (sender.hasPermission("wsucraft.prot") || sender instanceof ConsoleCommandSender) {
								player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
								player.sendMessage(ChatColor.GREEN + "You skin returns to normal.");
								break;
							}
						case "dig":
							if (sender.hasPermission("wsucraft.dig") || sender instanceof ConsoleCommandSender) {
								player.removePotionEffect(PotionEffectType.FAST_DIGGING);
								player.sendMessage(ChatColor.GREEN + "Your tools are back to normal.");
								break;
							}
						case "fireprot":
							if (sender.hasPermission("wsucraft.fireprot") || sender instanceof ConsoleCommandSender) {
								player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
								player.sendMessage(ChatColor.GREEN + "Lava can harm you again.");
								break;
							}
						case "hunger":
							if (sender.hasPermission("wsucraft.hunger") || sender instanceof ConsoleCommandSender) {
								player.removePotionEffect(PotionEffectType.HUNGER);
								player.sendMessage(ChatColor.GREEN + "Your hunger has finally stopped.");
								break;
							}
						case "strength":
							if (sender.hasPermission("wsucraft.strength") || sender instanceof ConsoleCommandSender) {
								player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
								player.sendMessage(ChatColor.GREEN + "Your weapons are back to normal.");
								break;
							}
						case "invis":
							if (sender.hasPermission("wsucraft.invis") || sender instanceof ConsoleCommandSender) {
								player.removePotionEffect(PotionEffectType.INVISIBILITY);
								player.sendMessage(ChatColor.GREEN + "You fade back into reality.");
								break;
							}
						case "jump":
							if (sender.hasPermission("wsucraft.jump") || sender instanceof ConsoleCommandSender) {
								player.removePotionEffect(PotionEffectType.JUMP);
								player.sendMessage(ChatColor.GREEN + "Gravity returns to normal.");
								break;
							}
						case "night":
							if (sender.hasPermission("wsucraft.night") || sender instanceof ConsoleCommandSender) {
								player.removePotionEffect(PotionEffectType.NIGHT_VISION);
								player.sendMessage(ChatColor.GREEN + "Your eyes have returned to normal.");
								break;
							}
						case "poison":
							if (sender.hasPermission("wsucraft.poison") || sender instanceof ConsoleCommandSender) {
								player.removePotionEffect(PotionEffectType.POISON);
								player.sendMessage(ChatColor.GREEN + "Your disease has left.");
								break;
							}
						case "regen":
							if (sender.hasPermission("wsucraft.regen") || sender instanceof ConsoleCommandSender) {
								player.removePotionEffect(PotionEffectType.REGENERATION);
								player.sendMessage(ChatColor.GREEN + "Be careful, a scratch can kill.");
								break;
							}
						case "slow":
							if (sender.hasPermission("wsucraft.slow") || sender instanceof ConsoleCommandSender) {
								player.removePotionEffect(PotionEffectType.SLOW);
								player.sendMessage(ChatColor.GREEN + "Your legs move freely.");
								break;
							}
						case "slowdig":
							if (sender.hasPermission("wsucraft.slowdig") || sender instanceof ConsoleCommandSender) {
								player.removePotionEffect(PotionEffectType.SLOW_DIGGING);
								player.sendMessage(ChatColor.GREEN + "Your tools are back to normal.");
								break;
							}
						case "speed":
							if (sender.hasPermission("wsucraft.speed") || sender instanceof ConsoleCommandSender) {
								player.removePotionEffect(PotionEffectType.SPEED);
								player.sendMessage(ChatColor.GREEN + "Your excess energy has worn off.");
								break;
							}
						case "underwater":
							if (sender.hasPermission("wsucraft.underwater") || sender instanceof ConsoleCommandSender) {
								player.removePotionEffect(PotionEffectType.WATER_BREATHING);
								player.sendMessage(ChatColor.GREEN + "Your gills shrink into your skin.");
								break;
							}
						case "weakness":
							if (sender.hasPermission("wsucraft.weakness") || sender instanceof ConsoleCommandSender) {
								player.removePotionEffect(PotionEffectType.WEAKNESS);
								player.sendMessage(ChatColor.GREEN + "Your weapons are back to normal.");
								break;
							}
						case "wither":
							if (sender.hasPermission("wsucraft.wither") || sender instanceof ConsoleCommandSender) {
								player.removePotionEffect(PotionEffectType.WITHER);
								player.sendMessage(ChatColor.GREEN + "Your disease has left.");
								break;
							}
						default:
							sender.sendMessage("See /WSUCraft help");
					}
					if (!(sender instanceof ConsoleCommandSender) && !((Player)sender).equals(player)) {
						sender.sendMessage("You used " + ChatColor.AQUA + args[0] + " " + args[1] + ChatColor.RESET + " on " + player.getName());
					}
				} else {
					sender.sendMessage("See /WSUCraft help");
				}
			}
			return true;
		}
		return false;
	}
}