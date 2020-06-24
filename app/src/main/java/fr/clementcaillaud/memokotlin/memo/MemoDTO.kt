package fr.clementcaillaud.memokotlin.memo

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.parceler.Parcel

@Parcel
@Entity(tableName="memo")
class MemoDTO(
    @PrimaryKey(autoGenerate = true)
    var memoID: Long = 0,
    var contenu: String = "")
{
    constructor(contenu: String) : this()
    {
        this.contenu = contenu
    }
}