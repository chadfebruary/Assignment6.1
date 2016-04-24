package app.milleniuminfinity.com.milleniuminfinity.repository.employee.Impl;

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
import app.milleniuminfinity.com.milleniuminfinity.domain.employee.Employee;
import app.milleniuminfinity.com.milleniuminfinity.repository.employee.EmployeeRepository;


/**
 * Created by Chad on 4/21/2016.
 */
public class EmployeeRepositoryImpl extends SQLiteOpenHelper implements EmployeeRepository {
    public static final String TABLE_EMPLOYEE = "employee";
    private SQLiteDatabase database;

    public static final String COLUMN_EMPLOYEEID = "employeeid";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SURNAME = "surname";
    public static final String COLUMN_DATEOFBIRTH = "dateofbirth";

    //Database table creation
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_EMPLOYEE + "("
            + COLUMN_EMPLOYEEID + " TEXT PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT NOT NULL, "
            + COLUMN_SURNAME + " TEXT NOT NULL, "
            + COLUMN_DATEOFBIRTH + "TEXT NOT NULL);";

    public EmployeeRepositoryImpl(Context context)
    {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException
    {
        database = this.getWritableDatabase();
    }

    public void close()
    {
        this.close();
    }

    @Override
    public Employee findById(String employeeID)
    {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(
                TABLE_EMPLOYEE,
                new String[]{
                        COLUMN_EMPLOYEEID,
                        COLUMN_NAME,
                        COLUMN_SURNAME,
                        COLUMN_DATEOFBIRTH},
                COLUMN_EMPLOYEEID + " =? ",
                new String[]{String.valueOf(employeeID)},
                null,
                null,
                null,
                null);

        if(cursor.moveToFirst())
        {
            final Employee employee = new Employee().Builder()
                    .employeeID(cursor.getString(0))
                    .name(cursor.getString(1))
                    .surname(cursor.getString(2))
                    .dateOfBirth(cursor.getString(3))
                    .build();

            return employee;
        }
        else
        {
            return null;
        }
    }

    @Override
    public Employee save(Employee employee) throws Exception
    {
        open();
        ContentValues values = new ContentValues();

        values.put(COLUMN_EMPLOYEEID, employee.getEmployeeID());
        values.put(COLUMN_NAME, employee.getName());
        values.put(COLUMN_SURNAME, employee.getSurname());
        values.put(COLUMN_DATEOFBIRTH, employee.getDateOfBirth());

        Long employeeID = database.insertOrThrow(TABLE_EMPLOYEE, null, values);

        Employee insertedEntity = new Employee.Builder()
                .copy(employee)
                .employeeID(new String(employeeID))
                .build();

        return insertedEntity;
    }

    @Override
    public Employee update(Employee employee) throws Exception
    {
        open();
        ContentValues values = new ContentValues();

        values.put(COLUMN_EMPLOYEEID, employee.getEmployeeID());
        values.put(COLUMN_NAME, employee.getName());
        values.put(COLUMN_SURNAME, employee.getSurname());
        values.put(COLUMN_DATEOFBIRTH, employee.getDateOfBirth());
        database.update(
                TABLE_EMPLOYEE,
                values,
                COLUMN_EMPLOYEEID + " =? ",
                new String[]{String.valueOf(employee.getEmployeeID())}
        );

        return employee;
    }

    @Override
    public Employee delete(Employee employee) throws Exception
    {
        open();
        database.delete(
                TABLE_EMPLOYEE,
                COLUMN_EMPLOYEEID + " =? ",
                new String[]{String.valueOf(employee.getEmployeeID())}
        );
        
        return employee;
    }

    @Override
    public Set<Employee> findAll() throws Exception
    {
        SQLiteDatabase database = this.getReadableDatabase();
        String selectAll = " SELECT * FROM " + TABLE_EMPLOYEE;
        Set<Employee> employees = new HashSet<>();
        open();
        Cursor cursor = database.rawQuery(selectAll, null);

        if(cursor.moveToFirst())
        {
            do {
                final Employee employee = new Employee().Builder()
                        .employeeID(cursor.getString(0))
                        .name(cursor.getString(1))
                        .surname(cursor.getString(2))
                        .dateOfBirth(cursor.getString(3))
                        .build();
                employees.add(employee);
            }while(cursor.moveToNext());
        }

        return employees;
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
        onCreate(db);

    }
}
