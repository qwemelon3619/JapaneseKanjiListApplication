package com.example.sampleprojecct.database
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Kanji_word_table")
data class KanjiWord(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name="index")
    val index: Int?=null,
    @ColumnInfo(name = "kanji")
    val kanji: String?,
    @ColumnInfo(name = "mean")
    val mean: String?,
    @ColumnInfo(name = "level")
    val level: String?,
)