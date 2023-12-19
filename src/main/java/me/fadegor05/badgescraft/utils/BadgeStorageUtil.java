package me.fadegor05.badgescraft.utils;

import me.fadegor05.badgescraft.models.Badge;
import me.fadegor05.badgescraft.models.Color;
import me.fadegor05.badgescraft.models.Template;

import java.util.ArrayList;

public class BadgeStorageUtil {
    private static ArrayList<Badge> badges = new ArrayList<>();

    public static Badge createBadge(String name, String id, Color color, Template template){

        Badge badge = new Badge(name, id, color, template);
        badges.add(badge);

        //TODO: save badges

        return badge;
    }

    public static Badge findBadge(String id){
        for(Badge badge : badges){
            if(badge.getId().equals(id)){
                return badge;
            }
        }
        return null;
    }

    public static ArrayList<Badge> getAllBadge() { return badges; }

    public static void deleteBadge(String id){
        for(Badge badge : badges){
            if(badge.getId().equals(id)){
                badges.remove(badge);
                //TODO: save badges
                break;
            }
        }
    }

    public static Badge updateBadge(String id, Badge newBadge){
        for(Badge badge : badges){
            if(badge.getId().equals(id)){
                badge.setColor(newBadge.getColor());
                badge.setTemplate(newBadge.getTemplate());
                badge.setId(badge.getId());
                badge.setName(badge.getName());
                //TODO: save badges
            }
        }
        return null;
    }
}
