package me.drkmatr1984.RealisticSwimmingCompat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.drkmatr1984.RealisticSwimmingCompat.AAC.AACCompatibilityFix;
import realisticSwimming.main.RSMain;

import net.md_5.bungee.api.ChatColor;

public class RealisticSwimmingCompat extends JavaPlugin
{
	private RealisticSwimmingCompat plugin;
	private RSMain swim;
	private boolean aac;
	
	public void onEnable(){
		plugin = this;
		if(!this.getServer().getPluginManager().isPluginEnabled("Realistic-Swimming")){
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[&bRealisticSwimmingCompat&r] Realistic-Swimming is &cnot enabled&r. &cDisabling&r..."));
			this.setEnabled(false);
			return;
		}
		swim = (RSMain) this.getServer().getPluginManager().getPlugin("Realistic-Swimming");
		aac = this.getServer().getPluginManager().isPluginEnabled("AAC");
		doDeps();
	}
	
	private void doDeps(){
		if(this.aac){
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[&bRealisticSwimmingCompat&r] &eAAC&r is &aenabled&r. &aEnabling&r Compatibility Fixes for &eAAC"));
			Bukkit.getServer().getPluginManager().registerEvents(new AACCompatibilityFix(), plugin);
		}
	}
	
	public RSMain getRSInstance()
	{
		return this.swim;
	}
	
	public RealisticSwimmingCompat getInstance()
	{
		return this.plugin;
	}
}