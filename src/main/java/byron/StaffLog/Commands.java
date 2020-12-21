package byron.StaffLog;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;


public class Commands implements CommandExecutor {

    public StaffLog plugin;

    public Commands(StaffLog pl) {
        this.plugin = pl;
    }
        public static ArrayList<Player> Insc = new ArrayList<Player>();

    String Prefix = ChatColor.translateAlternateColorCodes('&', "&b[STAFF] ");
    String Enabled = ChatColor.translateAlternateColorCodes('&', Prefix + "&aStaffchat has been toggled on.");
    String Disabled = ChatColor.translateAlternateColorCodes('&', Prefix + "&cStaffchat has been toggled off");
    String NoPerm = ChatColor.translateAlternateColorCodes('&', "&cYou must be staff or higher to use this command!");
    @Override
    public boolean onCommand(CommandSender sender , Command cmd, String arg2, String[] args) {
        if(cmd.getName().equalsIgnoreCase("s")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(("You cannot use this command via console."));
                return true;
            }

            Player p = (Player) sender;
            if(args.length == 0) {

                if(!(p.hasPermission("stafflog.chat"))) {
                    p.sendMessage(NoPerm);
                    return true;
                }
                if(Insc.contains(p)){
                    Insc.remove(p);
                    p.sendMessage(Disabled);

                    return true;
                } else
                    Insc.add(p);
                p.sendMessage((Enabled));

                return true;
            }
            if(args.length >= 1) {

                p.sendMessage(Prefix + ChatColor.GRAY + "Usage: /s");

                return true;
            }
        }
    return false;

    }
}