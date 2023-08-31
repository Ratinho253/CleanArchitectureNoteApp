package com.plcoding.cleanarchitecturenoteapp.feature_note.data.data_source

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun get(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id = :id ")
    suspend fun  getNoteById(id: Int) : Note?

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun  insertNote(note: com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note)

    @Delete
    suspend fun deleteNote(note: com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note)

}