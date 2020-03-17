package com.example.sewamotor;

public class API {
    //all
    public static final String API_LOGIN = "http://192.168.43.69/sewamotor/android/login.php";
    public static final String API_REGIS = "http://192.168.43.69/sewamotor/android/register.php";
    public static final String API_SHELTER = "http://192.168.43.69/Shelter/Android/show_shelter.php";
    public static final String API_FOTO_SHELTER = "http://192.168.43.69/Shelter/Android/show_shelter_foto.php?id_shelter=";
    public static final String API_LOKASI_FOTO = "http://192.168.43.69/Shelter/Android/Image/";
    public static final String API_SHELTER_DETAIL = "http://192.168.43.69/Shelter/Android/show_shelter_detail.php?id_shelter=";
    public static final String API_HEWAN_SHELTER_SLIDE = "http://192.168.43.69/Shelter/Android/show_hewan_shelter_slide.php?id_shelter=";
    public static final String API_HEWAN_SHELTER = "http://192.168.43.69/Shelter/Android/show_hewan_shelter.php?id_shelter=";
    public static final String API_FOTO_HEWAN = "http://192.168.43.69/Shelter/Android/show_hewan_foto.php?id_hewan=";
    public static final String API_HEWAN_DETAIL = "http://192.168.43.69/Shelter/Android/show_hewan_detail.php?id_hewan=";
    public static final String API_ADD_DONASI = "http://192.168.43.69/Shelter/Android/add_donasi.php";
    public static final String API_ADD_ADOPSI = "http://192.168.43.69/Shelter/Android/add_adopsi.php";
    public static final String API_DONASI = "http://192.168.43.69/Shelter/Android/show_donasi.php";
    public static final String API_ADOPSI = "http://192.168.43.69/Shelter/Android/show_adopsi.php";
    public static final String API_SAYA = "http://192.168.43.69/Shelter/Android/show_saya.php?id_user=";
    public static final String API_MY_ADOPSI = "http://192.168.43.69/Shelter/Android/show_my_adopsi.php?id_user=";
    public static final String API_MY_DONASI = "http://192.168.43.69/Shelter/Android/show_my_donasi.php?id_user=";


    public static final String TAG_JSON_ARRAY="result";

    //USER
    public static final String API_ID_USER = "id_user";
    public static final String API_NAMA = "nama";
    public static final String API_USERNAME = "username";
    public static final String API_EMAIL = "email";

    //SHELTER
    public static final String API_ID_SHELTER = "id_shelter";
    public static final String API_NM_SHELTER = "nm_shelter";
    public static final String API_KABUPATEN = "kabupaten";
    public static final String API_LAT = "latitude";
    public static final String API_LNG = "longitude";
    public static final String API_ALAMAT = "alamat";
    public static final String API_TOTAL_HEWAN = "total_hewan";
    public static final String API_TOTAL_ADOPSI = "total_adopsi";
    public static final String API_TOTAL_DONASI = "total_donasi";
    public static final String API_NO_HP = "no_hp";


    //HEWAN
    public static final String API_ID_HEWAN = "id_hewan";
    public static final String API_NM_HEWAN = "nm_hewan";
    public static final String API_KAT_HEWAN = "kat_hewan";
    public static final String API_JENIS_HEWAN = "jenis_hewan";
    public static final String API_WARNA_HEWAN = "warna_hewan";
    public static final String API_UMUR_HEWAN = "umur_hewan";
    public static final String API_KONDISI_HEWAN = "kondisi_hewan";
    public static final String API_STATUS_ADOPSI = "status_adopsi";
    public static final String API_KETERANGAN = "keterangan";


    public static final String REVIEW_ID = "review_id";
    public static final String SOUND_ID = "sound_id";
}
