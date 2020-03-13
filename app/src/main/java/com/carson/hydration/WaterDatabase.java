package com.carson.hydration;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {WaterRecord.class}, version = 1, exportSchema = false)
public class WaterDatabase extends RoomDatabase {

    private static volatile WaterDatabase INSTANCE;

    public abstract WaterDAO waterDAO();

    static WaterDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (WaterDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WaterDatabase.class, "Water").build();
                }
            }
        }
    }
}
