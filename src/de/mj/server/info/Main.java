package de.mj.server.info;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	ArrayList<String> plnames = new ArrayList<String>();

	String prefix = "§8[§9ServerInfo§8] ";

	public void onEnable() {
		System.out.println("§8§m---------------§8[§9ServerInfo§8]§8§m---------------§r");
		System.out.println(prefix + "§e§lis starting...");
		System.out.println(prefix + "§eload Commands...");
		this.getCommand("serverinfo").setExecutor(this);
		System.out.println(prefix + "§aSuccsess!");
		System.out.println(prefix + "§eget plugins...");
		for (Plugin all : Bukkit.getPluginManager().getPlugins()) {
			plnames.add(all.getName());
		}
		System.out.println(prefix + "§aSuccess!");
		System.out.println(prefix + "§a§linitialized successfully!");
		System.out.println(prefix + "§eload information...");
		System.out.println(prefix + "§aSuccess!");
		System.out.println("§8§m---------------§8[§9ServerInfo§8]§8§m---------------§r");
		long cram = Runtime.getRuntime().freeMemory() / 0x100000L;
		long mram = Runtime.getRuntime().maxMemory() / 0x100000L;
		ArrayList<String> names = new ArrayList<String>();
		for (Player all : Bukkit.getOnlinePlayers()) {
			names.add(all.getName());
		}
		System.out.println("§9Current RAM-Usage: §a" + cram + " MB §9 of §3" + mram + " MB");
		if (!names.isEmpty()) {
			System.out.println("§6Online Players: §a" + names);
		}
		System.out.println("§5Version: §b" + Bukkit.getBukkitVersion());
		System.out.println("§aPlugins: §3" + plnames);
		System.out.println("§1MOTD: §9" + Bukkit.getMotd());
		System.out.println("§8§m--------------------------------------------§r");
		System.out.println("§8§m--------------------------------------------§r");
	}

	public void onDisable() {
		System.out.println("§eShutdown Server...");
		Bukkit.getPluginManager().disablePlugins();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("Server.Info")) {
			if (cmd.getName().equalsIgnoreCase("serverinfo")) {
				sender.sendMessage("§8§m---------------§8[§9ServerInfo§8]§8§m---------------§r");
				long cram = Runtime.getRuntime().freeMemory() / 0x100000L;
				long mram = Runtime.getRuntime().maxMemory() / 0x100000L;
				ArrayList<String> names = new ArrayList<String>();
				for (Player all : Bukkit.getOnlinePlayers()) {
					names.add(all.getName());
				}
				sender.sendMessage("§9Current RAM-Usage: §a" + cram + " MB §9 of §3" + mram + " MB");
				if (!names.isEmpty()) {
					sender.sendMessage("§6Online Players: §a" + names);
				}
				sender.sendMessage("§5Version: §b" + Bukkit.getBukkitVersion());
				sender.sendMessage("§aPlugins: §3" + plnames);
				sender.sendMessage("§1MOTD: §9" + Bukkit.getMotd());
				sender.sendMessage("§8§m--------------------------------------------§r");
			}
		} else {
			sender.sendMessage("You don't have the permission to use this command!");
		}
		return false;
	}
}
