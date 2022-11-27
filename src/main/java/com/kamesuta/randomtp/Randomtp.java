package com.kamesuta.randomtp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public final class Randomtp extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!command.getName().equals("randomtp")) {
            return true;
        }
        if (args.length != 7) {
            sender.sendMessage("Usage: /randomtp <target> <x1> <z1> <x2> <z2> <y1> <y2>");
            return true;
        }

        @NotNull List<Entity> entities = Bukkit.selectEntities(sender, args[0]);
        int x1 = Integer.parseInt(args[1]);
        int y1 = Integer.parseInt(args[2]);
        int z1 = Integer.parseInt(args[3]);
        int x2 = Integer.parseInt(args[4]);
        int y2 = Integer.parseInt(args[5]);
        int z2 = Integer.parseInt(args[6]);
        int minX = Math.min(x1, x2);
        int maxX = Math.max(x1, x2);
        int minY = Math.min(y1, y2);
        int maxY = Math.max(y1, y2);
        int minZ = Math.min(z1, z2);
        int maxZ = Math.max(z1, z2);
        Random random = new Random();
        for (Entity entity : entities) {
            int x = random.nextInt(maxX - minX + 1) + minX;
            int y = random.nextInt(maxY - minY + 1) + minY;
            int z = random.nextInt(maxZ - minZ + 1) + minZ;
            entity.teleport(new Location(entity.getWorld(), x, y, z));
        }
        return true;
    }
}
