package me.fadegor05.badgescraft;

import me.fadegor05.badgescraft.models.User;
import me.fadegor05.badgescraft.utils.UserStorageUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;

import static me.fadegor05.badgescraft.utils.UserStorageUtil.findUser;

public class NewUserHandler implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(UserStorageUtil.findUser(player.getName()) == null){
            ArrayList<String> colors = new ArrayList<>();
            ArrayList<String> templates = new ArrayList<>();
            ArrayList<String> badges = new ArrayList<>();
            UserStorageUtil.createUser(player.getName(), templates, colors, badges);
        }
    }
}
