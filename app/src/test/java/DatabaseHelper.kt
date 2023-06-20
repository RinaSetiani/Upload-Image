import android.database.sqlite.SQLiteDatabase
import java.io.ByteArrayOutputStream

class DatabaseHelper {
    private val TABLE_MENU = "menu"
    private val COLUMN_ID_MENU = "idmenu"
    private val COLUMN_NAMA_MENU = "menuName"
    private val COLUMN_PRICE_MENU = "price"
    private val COLUMN_IMAGE = "photo"

    private val CREATE_MENU_TABLE = "CREATE TABLE " + TABLE_MENU " "("
    + COLUMN_ID_MENU + " INT PRIMARY KEY, "+ COLUMN_NAMA_MENU +" TEXT, "
    +COLUMN_PRICE_MENU +" INT, "+COLUMN_IMAGE+" BLOB")

    private val DROP_MENU_TABLE = "DROP TABEL IF EXIST $TABLE_MENU"
}

override fun OnCreate(p0: SQLiteDatabase){
    p0?execSQL(CREATE_ACCOUNT_TABLE)
    p0?execSQL(CREATE_MENU_TABLE)
    p0?execSQL(INSERT_ACCOUNT_TABLE)
}

override fun OnUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int){
    p0?execSQL(DROP_ACCOUNT_TABLE)
    p0?execSQL(INSERT_MENU_TABLE)
}

fun addMenu(menu:MenuModel){
    val db = this.writableDatabase
    val values = ContextValues()
    values.put(COLUMN_TO_MENU, menu.id)
    values.put(COLUMN_NAMA_MENU, menu.name)
    values.put(COLUMN_PRICE_MENU, menu.price)

    val byteOutputStream = ByteArrayOutputStream()
    val image.compress(Bitmap.CompressFormat.JPEG, quality: 100, byteOutputStream)
    imageInByte = byteOutputStream.toByteArray()
    values.put(COLUMN_NAME, ImageInByte)

    val result = db.insert(TABLE_MENU, nullColumnHack: null, values)

    if result==(0).toLong(){
        Toast.makeText(context, text"Add menu failed", Toast.LENGHT_SHORT).show()
    }
    else {
        Toast.makeText(context, text"Add menu fsuccess", Toast.LENGHT_SHORT).show()
    }
    db.close()
}
