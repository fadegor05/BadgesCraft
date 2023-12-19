package me.fadegor05.badgescraft.utils;

import me.fadegor05.badgescraft.models.Badge;
import me.fadegor05.badgescraft.models.Color;
import me.fadegor05.badgescraft.models.Template;
import me.fadegor05.badgescraft.models.User;

import java.util.ArrayList;

public class UserStorageUtil {
    private static ArrayList<User> users = new ArrayList<>();

    public static User createUser(String playerName, ArrayList<String> templates, ArrayList<String> colors, ArrayList<String> badges){

        User user = new User(playerName, templates, colors, badges);
        users.add(user);

        //TODO: save users

        return user;
    }

    public static User findUser(String playerName){
        for (User user : users){
            if(user.getPlayerName().equals(playerName)){
                return user;
            }
        }
        return null;
    }

    public static ArrayList<User> getAllUser() { return users; }

    public static void deleteUser(String playerName){
        for (User user : users){
            if(user.getPlayerName().equals(playerName)){
                users.remove(user);
                //TODO: save users
                break;
            }
        }
    }

    public static User updateUser(String playerName, User newUser){
        for (User user : users){
            if(user.getPlayerName().equals(playerName)){
                user.setBadges(newUser.getBadges());
                user.setColors(newUser.getColors());
                user.setTemplates(newUser.getTemplates());
                user.setPlayerName(newUser.getPlayerName());

                //TODO: save users

                return user;
            }
        }
        return null;
    }
}
