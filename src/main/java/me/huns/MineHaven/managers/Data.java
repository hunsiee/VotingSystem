package me.huns.MineHaven.managers;

import org.bukkit.Location;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;

public class Data implements Serializable {
    private static transient final long serialVersionUID = -1681012206529286330L;

    public boolean saveData(String filePath) {
        try {
            BukkitObjectOutputStream out = new BukkitObjectOutputStream(new GZIPOutputStream(new FileOutputStream(filePath)));
            out.writeObject(this);
            out.close();
            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
}
