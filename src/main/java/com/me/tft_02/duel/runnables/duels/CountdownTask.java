package com.me.tft_02.duel.runnables.duels;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.me.tft_02.duel.locale.LocaleLoader;

public class CountdownTask extends BukkitRunnable {
    private Player player;
    private Player target;
    private Location location;
    private int number;

    public CountdownTask(Player player, Player target, int number) {
        this.player = player;
        this.target = target;
        this.location = player.getLocation();
        this.number = number;
    }

    @Override
    public void run() {
        countdown();
    }

    private void countdown() {
        if (number > 0) {
            player.sendMessage(LocaleLoader.getString("Duel.Countdown", number));
            target.sendMessage(LocaleLoader.getString("Duel.Countdown", number));
            location.getWorld().playSound(location, Sound.NOTE_PLING, 1F, 0F);

            if (number <= 1) {
                this.cancel();
            }

            number--;
        }
    }
}
