package com.api.trabalhofinal;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.api.trabalhofinal.objetos.Eventos;
import com.api.trabalhofinal.objetos.Usuarios;
import com.api.trabalhofinal.objetos.UsuariosEventos;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    SQLiteDatabase db =  this.getWritableDatabase();

    public DbHelper(Context context) {
        super(context,"roleJorge.db",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE USUARIOS (USU_CDIUSUARIO INTEGER PRIMARY KEY," +
                "USU_DSSUSUARIO String," +
                "USU_DSSSENHA String)");

        sqLiteDatabase.execSQL("CREATE TABLE EVENTOS (EVE_CDIEVENTO INTEGER PRIMARY KEY," +
                "EVE_DSSEVENTO String," +
                "EVE_DTDEVENTO String," +
                "EVE_NUMLATITUDE REAL," +
                "EVE_NUMLONGITUDE REAL," +
                "EVE_DSSDESCRITIVO)");

        sqLiteDatabase.execSQL("CREATE TABLE USUARIOSEVENTOS (UEV_CDIUSUARIOEVENTO INTEGER PRIMARY KEY," +
                "UEV_CDIUSUARIO INTEGER," +
                "UEV_CDIEVENTO INTEGER)");

        sqLiteDatabase.execSQL("CREATE TABLE USUARIOSEVENTOSCONVITES (UEC_CDIUSUARIOEVENTOCONVITE" +
                "UEC_CDISTATUS INTEGER," +
                "UEC_CDITIPOCONVITE INTEGER)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    private int getNextUserId(){
        Cursor cursor = db.rawQuery("SELECT MAX(USU_CDIUSUARIO)+1 FROM USUARIOS",null);
        if (cursor.moveToFirst()){
            return cursor.getInt(0);
        }else{
            cursor.close();
            return 1;
        }
    }

    public void createUser(String usuario, String senha){

        ContentValues cv = new ContentValues();
        int temp = getNextUserId();
        cv.put("USU_CDIUSUARIO",temp);
        cv.put("USU_DSSUSUARIO",usuario);
        cv.put("USU_DSSSENHA",senha);
        db.insertOrThrow("USUARIOS",null,cv);
    }

    @SuppressLint("Range")
    public Usuarios getUserByName(String name){

        Cursor cursor = db.rawQuery("SELECT USU_CDIUSUARIO, USU_DSSUSUARIO, USU_DSSSENHA FROM USUARIOS WHERE USU_DSSUSUARIO = ?",new String[]{name});

        if (cursor.moveToFirst()){
            return new Usuarios(
                    cursor.getInt(cursor.getColumnIndex("USU_CDIUSUARIO")),
                    cursor.getString(cursor.getColumnIndex("USU_DSSUSUARIO")),
                    cursor.getString(cursor.getColumnIndex("USU_DSSSENHA"))
                    );
        }else{
            cursor.close();
            return null;
        }

    }

    public Usuarios getUserById(int id){

        Cursor cursor = db.rawQuery("SELECT USU_CDIUSUARIO, USU_DSSUSUARIO, USU_DSSSENHA FROM USUARIOS WHERE USU_CDIUSUARIO = " + id,null);



        if (cursor.moveToFirst()){
            Usuarios usuarios = new Usuarios(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2));
            return usuarios;

        }else{
            cursor.close();
            return null;
        }

    }

    public int getNextEventId(){
        Cursor cursor = db.rawQuery("SELECT MAX(EVE_CDIEVENTO)+1 FROM EVENTOS",null);
        if (cursor.moveToFirst()){
            return cursor.getInt(0);
        }else{
            cursor.close();
            return 1;
        }
    }

    public void createEvent(Eventos eventos){

        ContentValues cv = new ContentValues();
        cv.put("EVE_CDIEVENTO",getNextEventId());
        cv.put("EVE_DSSEVENTO",eventos.getNome());
        cv.put("EVE_DTDEVENTO",eventos.getData());
        cv.put("EVE_NUMLATITUDE",eventos.getLatitude());
        cv.put("EVE_NUMLONGITUDE",eventos.getLongitude());
        cv.put("EVE_DSSDESCRITIVO",eventos.getDescricao());
        db.insertOrThrow("EVENTOS",null,cv);

    }

    public Eventos getEventById(int id){

        Cursor cursor = db.rawQuery("SELECT EVE_CDIEVENTO," +
                "EVE_DSSEVENTO," +
                "EVE_DTDEVENTO," +
                "EVE_NUMLATITUDE," +
                "EVE_NUMLONGITUDE," +
                "EVE_DSSDESCRITIVO " +
                "FROM EVENTOS where EVE_CDIEVENTO = " +id,null);

        if (cursor.moveToFirst()){
            Eventos eventos = new Eventos(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getFloat(3),
                    cursor.getFloat(4),
                    cursor.getString(5)
            );
            return eventos;
        }else{
            cursor.close();
            return null;
        }
    }

    private int getNexteUsuarioEventoId(){
        Cursor cursor = db.rawQuery("SELECT MAX(EVE_CDIEVENTO)+1 FROM EVENTOS",null);
        if (cursor.moveToFirst()){
            return cursor.getInt(0);
        }else{
            cursor.close();
            return 1;
        }
    }

    public void createUsuarioEvent(UsuariosEventos usuariosEventos){

        ContentValues cv = new ContentValues();
        cv.put("UEV_CDIUSUARIOEVENTO",getNextEventId());
        cv.put("UEV_CDIUSUARIO",usuariosEventos.getIdUsuario().getId());
        cv.put("UEV_CDIEVENTO",usuariosEventos.getIdEvento().getId());
        db.insertOrThrow("USUARIOSEVENTOS",null,cv);

    }

    public List<UsuariosEventos> getUsuariosEventos(Eventos eventos){
        Cursor cursor = db.rawQuery("SELECT UEV_CDIUSUARIOEVENTO," +
                "UEV_CDIUSUARIO," +
                "UEV_CDIEVENTO" +
                "FROM USUARIOSEVENTOS where UEV_CDIEVENTO = " +eventos.getId(),null);

        if (cursor.moveToFirst()){
        List<UsuariosEventos> usuariosEventosList = new ArrayList<UsuariosEventos>();
        do{
            UsuariosEventos usuariosEventos  = new UsuariosEventos(cursor.getInt(0),
                    getEventById(cursor.getInt(1)),
                    getUserById(cursor.getInt(2)));

            usuariosEventosList.add(usuariosEventos);

        }while (cursor.moveToNext());
        return usuariosEventosList;

    }else{
            cursor.close();
            return null;
        }
    }

    public List<UsuariosEventos> getUsuariosEventos(Usuarios usuarios){
        Cursor cursor = db.rawQuery("SELECT UEV_CDIUSUARIOEVENTO," +
                "UEV_CDIEVENTO," +
                "UEV_CDIUSUARIO" +
                " FROM USUARIOSEVENTOS where UEV_CDIUSUARIO = " +usuarios.getId(),null);

        List<UsuariosEventos> usuariosEventosList = new ArrayList<UsuariosEventos>();
        if (cursor.moveToFirst()){
            do{
                int usuarioEventID = cursor.getInt(0);
                int eventId = cursor.getInt(1);
                UsuariosEventos usuariosEventos  = new UsuariosEventos(usuarioEventID,
                        getEventById(eventId),
                        usuarios);

                usuariosEventosList.add(usuariosEventos);

            }while (cursor.moveToNext());

        }
        cursor.close();
        return usuariosEventosList;
    }



    private int getNexteUsuarioEventoConviteId(){
        Cursor cursor = db.rawQuery("SELECT MAX(EVE_CDIEVENTO)+1 FROM EVENTOS",null);
        if (cursor.moveToFirst()){
            return cursor.getInt(0);
        }else{
            cursor.close();
            return 1;
        }
    }

}
