package byron.StaffLog;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class StaffLog extends JavaPlugin {



    @Override
    public void onEnable() {
        getLogger().info("StaffLog has been loaded.");
        this.getCommand("stafflogdebug").setExecutor(new StaffLog());


        for(Player p : Bukkit.getOnlinePlayers()){

            if(p.hasPermission("stafflog.admin")){
                p.sendMessage("[SL] StaffLog has been loaded.");
            }

        }
    }

    @Override
    public void onDisable() {
        getLogger().info("StaffLog has unloaded.");


        for(Player p : Bukkit.getOnlinePlayers()){

            if(p.hasPermission("stafflog.admin")){
                p.sendMessage("[SL] StaffLog has been unloaded.");
            }

        }

    }

}
