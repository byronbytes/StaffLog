package byron.StaffLog;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class Chat implements Listener {

    public StaffLog plugin;

    public Chat(StaffLog pl) {

        this.plugin = pl;

    }


    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        Player p = e.getPlayer();


        String Prefix = ChatColor.translateAlternateColorCodes('&', "&b[STAFF] ");
        String msg = e.getMessage();

        if(Commands.Insc.contains(p)) {

            e.setCancelled(true);

                for(Player staff : Bukkit.getServer().getOnlinePlayers()) {

                    if(staff.hasPermission("stafflog.chat")) {
                        staff.sendMessage(Prefix +" " + p.getDisplayName() + ChatColor.WHITE + msg);

                }
            }
        }
    }
}
