package byron.StaffLog;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class StaffLog extends JavaPlugin {



    @Override
    public void onEnable() {
        getLogger().info("StaffLog has been loaded.");
        this.getCommand("stafflogdebug").setExecutor(new StaffLog());
        registerCommands();
        registerEvents();

        for(Player p : Bukkit.getOnlinePlayers()){

            if(p.hasPermission("stafflog.debug")){
                p.sendMessage("[SL] StaffLog has been loaded.");
            }

        }
    }

    @Override
    public void onDisable() {
        getLogger().info("StaffLog has unloaded.");


        for(Player p : Bukkit.getOnlinePlayers()){

            if(p.hasPermission("stafflog.debug")){
                p.sendMessage("[SL] StaffLog has been unloaded.");
            }

        }

    }



    public void registerCommands() {


        getCommand("s").setExecutor(new Commands(this));

    }

    public void registerEvents() {

        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new Chat(this),(this));
    }
}
