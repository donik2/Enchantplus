package slimefunaddon;

import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class HarvestEnchantment extends Enchantment {

    public HarvestEnchantment(int id) {
        super(id);
    }

    @Override
    public boolean canEnchantItem(ItemStack itemStack) {
        // Allow enchanting on pickaxes
        return itemStack.getType().name().endsWith("_PICKAXE");
    }

    @Override
    public boolean conflictsWith(Enchantment enchantment) {
        // Prevent conflicting with other enchantments
        return false;
    }

    @Override
    public int getMaxLevel() {
        // Set the maximum level for the enchantment
        return 3;
    }

    @Override
    public String getName() {
        // Set the name of the enchantment
        return "Harvest";
    }

    @Override
    public int getStartLevel() {
        // Set the starting level for the enchantment
        return 1;
    }

    @Override
    public boolean isTreasure() {
        // Set whether the enchantment is considered a treasure enchantment
        return false;
    }

    @Override
    public boolean getItemTarget() {
        // Set whether the enchantment can be applied to items
        return true;
    }

    @Override
    public boolean isCursed() {
        // Set whether the enchantment is considered a cursed enchantment
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        // Allow enchanting on pickaxes
        return item.getType().name().endsWith("_PICKAXE");
    }

    @Override
    public String getName() {
        // Set the name of the enchantment
        return "Harvest";
    }

    @Override
    public int getMaxLevel() {
        // Set the maximum level for the enchantment
        return 3;
    }

    @Override
    public int getStartLevel() {
        // Set the starting level for the enchantment
        return 1;
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        // Prevent conflicting with other enchantments
        return false;
    }

    @Override
    public boolean canApply(ItemStack item) {
        // Check if the enchantment can be applied to the item
        return item.getType().name().endsWith("_PICKAXE");
    }

    @Override
    public boolean isCursed() {
        // Set whether the enchantment is considered a cursed enchantment
        return false;
    }

    @Override
    public boolean isTreasure() {
        // Set whether the enchantment is considered a treasure enchantment
        return false;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getItemInHand();
        
        // Check if the player has the Harvest enchantment on their pickaxe
        if (item.containsEnchantment(this)) {
            Block block = event.getBlock();
            
            // Check if the player's inventory is full
            if (player.getInventory().firstEmpty() == -1) {
                // If the inventory is full, drop the block as an item at the player's location
                block.getWorld().dropItemNaturally(block.getLocation(), new CustomItem(block.getType(), 1));
            } else {
                // If the inventory has space, add the block to the player's inventory
                player.getInventory().addItem(new CustomItem(block.getType(), 1));
            }
            
            // Cancel the block break event to prevent the block from being dropped normally
            event.setCancelled(true);
        }
    }
}

