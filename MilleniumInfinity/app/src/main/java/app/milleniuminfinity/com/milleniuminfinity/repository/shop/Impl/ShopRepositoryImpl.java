package app.milleniuminfinity.com.milleniuminfinity.repository.shop.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import app.milleniuminfinity.com.milleniuminfinity.conf.databases.DBConstants;
import app.milleniuminfinity.com.milleniuminfinity.domain.shop.Shop;
import app.milleniuminfinity.com.milleniuminfinity.repository.shop.ShopRepository;


/**
 * Created by 208023429 on 4/21/2016.
 */
public class ShopRepositoryImpl extends SQLiteOpenHelper implements ShopRepository {

    public static final String TABLE_SHOP = "shop";
    private SQLiteDatabase database;

    public static final String COLUMN_NUMBER = "ShopNumber";
    public static final String COLUMN_NAME = "ShopName";
    public static final String COLUMN_OWNER = "ShopOwner";
    public static final String COLUMN_PHONENUMBER = "ShopPhoneNumber";

    //Database creation
    private static final String DATABASE_CREATE =
            " CREATE TABLE "
                    + TABLE_SHOP + " ("
                    + COLUMN_NUMBER + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_NAME + " TEXT NOT NULL, "
                    + COLUMN_OWNER + " TEXT NOT NULL, "
                    + COLUMN_PHONENUMBER + " TEXT NOT NULL );";

    public ShopRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        database = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Shop findById(String shopNumber) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(
                TABLE_SHOP, new String[]{
                        COLUMN_NUMBER,
                        COLUMN_NAME,
                        COLUMN_OWNER,
                        COLUMN_PHONENUMBER},
                COLUMN_NUMBER + " =? ",
                new String[]{String.valueOf(shopNumber)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Shop shop = new Shop.Builder()
                    .shopNumber(cursor.getString(0))
                    .shopName(cursor.getString(1))
                    .shopOwner(cursor.getString(2))
                    .shopPhoneNumber(cursor.getString(3))
                    .build();

            return shop;
        } else {
            return null;
        }
    }

    @Override
    public Shop save(Shop shop) throws Exception {

        open();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NUMBER, shop.getShopNumber());
        values.put(COLUMN_NAME, shop.getShopName());
        values.put(COLUMN_OWNER, shop.getShopOwner());
        values.put(COLUMN_PHONENUMBER, shop.getShopPhoneNumber());

        Long shopNumber = database.insertOrThrow(TABLE_SHOP, null, values);

        Shop insertedShop = new Shop.Builder()
                .copy(shop)
                .shopNumber(new String(shopNumber))
                .build();

        return insertedShop;
    }

    @Override
    public Shop update(Shop shop) throws Exception
    {
        open();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NUMBER, shop.getShopNumber());
        values.put(COLUMN_NAME, shop.getShopName());
        values.put(COLUMN_OWNER, shop.getShopOwner());
        values.put(COLUMN_PHONENUMBER, shop.getShopPhoneNumber());

        database.update(
                TABLE_SHOP,
                values,
                COLUMN_NUMBER + " =? ",
                new String[]{String.valueOf(shop.getShopNumber())}
        );

        return shop;
    }

    @Override
    public Shop delete(Shop shop) throws Exception
    {
        open();
        database.delete(
                TABLE_SHOP,
                COLUMN_NUMBER + " =? ",
                new String[]{String.valueOf((shop.getShopNumber()))}
        );

        return shop;
    }

    @Override
    public Set<Shop> findAll() throws Exception
    {
        SQLiteDatabase database = this.getReadableDatabase();
        String selectAll = " SELECT * FROM " + TABLE_SHOP;
        Set<Shop> shops = new HashSet<>();
        open();
        Cursor cursor = database.rawQuery(selectAll, null);

        if (cursor.moveToFirst()) 
        {
            do {
                final Shop shop = new Shop.Builder()
                        .shopNumber(cursor.getString(0))
                        .shopName(cursor.getString(1))
                        .shopOwner(cursor.getString(2))
                        .shopPhoneNumber(cursor.getString(3))
                        .build();

                shops.add(shop);
            } while (cursor.moveToNext());
        }

        return shops;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion)
    {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion
                        + " to " + newVersion + ", which will destroy all old data");

        database.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOP);
        onCreate(database);
    }
}
