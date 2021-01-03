package byron.StaffLog;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

class CommandBlock implements CommandExecutor {

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Create a new ItemStack (type: diamond)
            ItemStack commandblock = new ItemStack(Material.COMMAND);

            // Create a new ItemStack (type: brick)
            ItemStack barrier = new ItemStack(Material.BARRIER);

            // Set the amount of the ItemStack
            barrier.setAmount(64);

            // Give the player our items (comma-seperated list of all ItemStack)
            player.getInventory().addItem(commandblock, barrier);
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
