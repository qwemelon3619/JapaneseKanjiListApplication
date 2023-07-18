package com.example.sampleprojecct.database
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.math.BigInteger

@Entity(tableName = "KanjiList.db")
data class KanjiWord(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "Kanji")
    val kanji: String,
    @ColumnInfo(name = "Korean")
    val mean: String?,
    @ColumnInfo(name = "Level")
    val level: String?,
)