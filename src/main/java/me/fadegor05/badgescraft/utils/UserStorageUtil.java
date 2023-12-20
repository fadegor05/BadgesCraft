package me.fadegor05.badgescraft.utils;

import com.google.gson.Gson;
import me.fadegor05.badgescraft.BadgesCraft;
import me.fadegor05.badgescraft.models.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

public class UserStorageUtil {
    private static ArrayList<User> users = new ArrayList<>();

    public static User createUser(String playerName, ArrayList<String> templates, ArrayList<String> colors, ArrayList<String> badges){

        User user = new User(playerName, templates, colors, badges);
        users.add(user);

        saveUsers();
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
                saveUsers();
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

                saveUsers();

                return user;
            }
        }
        return null;
    }

    public static void loadUsers() {
        Gson gson = new Gson();
        String path = BadgesCraft.getPlugin().getDataFolder().getAbsolutePath() + "/users.json";
        File file = new File(path);
        if (file.exists()){
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF8"));
                StringBuilder out = new StringBuilder();
                String str;

                while ((str = in.readLine()) != null) {
                    System.out.println(str);
                    out.append(str);
                }

                User[] n = gson.fromJson(String.valueOf(out), User[].class);
                users = new ArrayList<>(Arrays.asList(n));
            }
            catch (IOException e){
                e.printStackTrace();
            }

        }

    }


    public static void saveUsers(){
        try {
            Gson gson = new Gson();
            File file = new File(BadgesCraft.getPlugin().getDataFolder().getAbsolutePath() + "/users.json");
            file.createNewFile();
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    Files.newOutputStream(file.toPath()), StandardCharsets.UTF_8));
            try {
                gson.toJson(users, writer);
                writer.flush();
            } finally {
                writer.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
