package me.fadegor05.badgescraft.models;

import java.util.ArrayList;

public class User {
    private String playerName;
    private ArrayList<String> templates;
    private ArrayList<String> colors;
    private ArrayList<String> badges;

    public User(String playerName, ArrayList<String> templates, ArrayList<String> colors, ArrayList<String> badges) {
        this.playerName = playerName;
        this.templates = templates;
        this.colors = colors;
        this.badges = badges;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public ArrayList<String> getTemplates() {
        return templates;
    }

    public void setTemplates(ArrayList<String> templates) {
        this.templates = templates;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public ArrayList<String> getBadges() {
        return badges;
    }

    public void setBadges(ArrayList<String> badges) {
        this.badges = badges;
    }
}
