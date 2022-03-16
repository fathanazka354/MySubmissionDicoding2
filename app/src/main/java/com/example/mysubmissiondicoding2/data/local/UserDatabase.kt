package com.example.mysubmissiondicoding2.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//abstract class UserDatabase:RoomDatabase() {
//    companion object{
//        var INSTANCE : UserDatabase? = null
//
//        fun getDatabase(context: Context):UserDatabase?{
//            if (INSTANCE == null){
//                synchronized(UserDatabase::class){
//                    INSTANCE = Room.databaseBuilder(context.applicationContext,UserDatabase::class.java,"user_database").build()
//                }
//            }
//            return INSTANCE
//        }
//    }
//    abstract fun favoriteUserDao():FavoriteUserDao
//}
@Database(entities = [FavoriteUser::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): UserDatabase {
            if (INSTANCE == null) {
                synchronized(UserDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        UserDatabase::class.java, "user_database")
                        .build()
                }
            }
            return INSTANCE as UserDatabase
        }
    }
    abstract fun favoriteUserDao(): FavoriteUserDao
}