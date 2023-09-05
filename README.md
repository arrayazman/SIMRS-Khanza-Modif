[![Watch the video](https://img.youtube.com/vi/wq8CjBx1LJY/hqdefault.jpg)](https://www.youtube.com/embed/wq8CjBx1LJY)
 

## Pembuatan Bot dan Grup Telegram
Buat BOT di ***BotFather*** 
/newbot

kemudian cek token
/mybots

### Buat Grup Telegram dan tambahkan bot nya
kemudian cek ID grup telegram dengan cara 
```
https://api.telegram.org/bot<PasteTokenBot>/getUpdates
```
ambil token yang sudah dibuat di botfather


Tambahkan Fungsi Berikut pada akhir ***src/fungsi/koneksiDB.java***
tujuannya yaitu untuk enkripsi bot telegram

```
    public static String UrlAutoUpdate(){
        try {
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            var = prop.getProperty("URLUPDATESISTEM");
        } catch (Exception ex) {
            var=""; 
        }
        return var;
    }
    
    public static String versi(){
        try{
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            var=prop.getProperty("VERSION");
        }catch(Exception e){
            var=""; 
        }
        return var;
    }

     public static String USEREMAIL(){
        try{
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            var=EnkripsiAES.decrypt(prop.getProperty("USEREMAIL"));
        }catch(Exception e){
            var=""; 
        }
        return var;
    }
     public static String PASSWORDDEMAIL(){
        try{
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            var=EnkripsiAES.decrypt(prop.getProperty("PASSWORDDEMAIL"));
        }catch(Exception e){
            var=""; 
        }
        return var;
    }
 
     public static String TOKENBOTTELE(){
        try{
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            var=prop.getProperty("TOKENBOTTELE");
        }catch(Exception e){
            var=""; 
        }
        return var;
    }
     public static String TELERAD(){
        try{
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            var=EnkripsiAES.decrypt(prop.getProperty("TELERAD"));
        }catch(Exception e){
            var=""; 
        }
        return var;
    }
    
     public static String TELERADHASIL(){
        try{
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            var=EnkripsiAES.decrypt(prop.getProperty("TELERAD"));
        }catch(Exception e){
            var=""; 
        }
        return var;
    }
     
     public static String TELELAB(){
        try{
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            var=EnkripsiAES.decrypt(prop.getProperty("TELELAB"));
        }catch(Exception e){
            var=""; 
        }
        return var;
    }
     
     public static String TELEFARMASI(){
        try{
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            var=EnkripsiAES.decrypt(prop.getProperty("TELEFARMASI"));
        }catch(Exception e){
            var=""; 
        }
        return var;
    }
     

```

di folder ***setting/database.xml***
Tambahkan 
```
    <entry key="TOKENBOTTELE">5369768831:AAHVUuYjF8ni84ZqkfbstNxDaTdbUsGn06s</entry>
    <entry key="TELERAD">rAryY5fqc14lRvHW2zKbZA==</entry>
    <entry key="TELERADHASIL">rAryY5fqc14lRvHW2zKbZA==</entry>
    <entry key="TELELAB">F60Lkx08hZuQZDC7r2VhMA==</entry>
    <entry key="TELEFARMASI">aoTK2Y/UU+voRJs1NeiFyQ==</entry>
```


### NOTIFIKASI TELEGRAM BOT PERMINTAAN RADIOLOGI
di file ***src/permintaan/DlgPermintaanRadiologi.java***
cari code berikut
```
koneksi.setAutoCommit(true);                    
                JOptionPane.showMessageDialog(null,"Proses simpan selesai...!");
```
letaknya ada pada line **1405**

pastekan code berikut
```
 //START CODE TELEGRAM
                    String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s&parse_mode=HTML";
                    //token bot telegram
                    String apiToken = koneksiDB.TOKENBOTTELE();
                    //chat id grup telegram
                    String chatId = koneksiDB.TELERAD();
                    String PermintaanTx=TNoPermintaan.getText();
                    String PasienTx=TPasien.getText();
                    String NoRMTx=TNoRM.getText();
                    String DokterTx=NmPerujuk.getText();
                    String Diagnosa=DiagnosisKlinis.getText();
                    String InfoTambahan=InformasiTambahan.getText();
                    String InfoTanggal=Valid.SetTgl(Tanggal.getSelectedItem()+"");
                    String InfoJam=CmbJam.getSelectedItem()+":"+CmbMenit.getSelectedItem();
                    String Prgraf = "<b><u>PERMINTAAN RADIOLOGI</u></b>"+
                            "%0ANomor Permintaan : <b>"+PermintaanTx+"</b>"+
                            "%0APasien : <b>"+PasienTx+" || "+NoRMTx+"</b>"+
                            "%0ADokter Perujuk : <b>"+DokterTx+"</b>"+
                            "%0AIndikasi/Diagnosa: <b>"+Diagnosa+"</b>"+
                            "%0AInfo Tambahan: <b>"+InfoTambahan+"</b>"+
                            "%0A%0A=============: JADWAL PERIKSA :============="+
                            "%0ATanggal : <b>"+InfoTanggal+"</b>"+
                            "%0AJam : <b>"+InfoJam+" WIB</b>"+
                            "%0ALakukan Validasi di menu Permintaan RADIOLOGI";
                    String text = Prgraf;
                    String isiText = text.replace(" ", "%20");       
                    urlString = String.format(urlString, apiToken, chatId, isiText );
                      try {
                        URL url = new URL(urlString);
                        URLConnection conn = url.openConnection();
                        InputStream is = new BufferedInputStream(conn.getInputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                //END CODE TELEGRAM    
```
sesuaikan dengan kebutuhan

---
### NOTIFIKASI TELEGRAM BOT HASIL RADIOLOGI

ubah file ***src/simrskhanza/DlgPeriksaRadiologi.java***

letakkan dibawah ***Proses Simpan Selesai***

```
 //START CODE TELEGRAM
                    String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s&parse_mode=HTML";
                    //token bot telegram
                    String apiToken = koneksiDB.TOKENBOTTELE();
                    //chat id grup telegram
                    String chatId = koneksiDB.TELERADHASIL();
                    String NoRawatTx=TNoRw.getText();
                    String PasienTx=TPasien.getText();
                    String NoRMTx=TNoRM.getText();
                    String DokterTx=NmDokterPj.getText();
                    String Petugas=NmPtg.getText(); 
                    String InfoTanggal=Valid.SetTgl(Tanggal.getSelectedItem()+"");
                    String InfoJam=CmbJam.getSelectedItem()+":"+CmbMenit.getSelectedItem();
                    String Prgraf = "<b><u>INFO HASIL RADIOLOGI</u></b>"+
                            "%0ANomor Rawat : <b>"+NoRawatTx+"</b>"+
                            "%0APasien : <b>"+PasienTx+" || "+NoRMTx+"</b>"+
                            "%0ADokter PJ : <b>"+DokterTx+"</b>"+
                            "%0APetugas: <b>"+Petugas+"</b>"+
                            "%0A%0A=============: WAKTU PERIKSA :============="+
                            "%0ATanggal : <b>"+InfoTanggal+"</b>"+
                            "%0AJam : <b>"+InfoJam+" WIB</b>"+
                            "%0ASilahkan Cek di Riwayat Pasien";
                    String text = Prgraf;
                    String isiText = text.replace(" ", "%20");       
                    urlString = String.format(urlString, apiToken, chatId, isiText );
                      try {
                        URL url = new URL(urlString);
                        URLConnection conn = url.openConnection();
                        InputStream is = new BufferedInputStream(conn.getInputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                //END CODE TELEGRAM  
```

---

### NOTIFIKASI TELEGRAM BOT PERMINTAAN LAB
di file ***src/permintaan/DlgPermintaanLaboratorium.java***
cari code berikut
```
                  
                JOptionPane.showMessageDialog(null,"Proses simpan selesai...!");
```
letaknya ada pada line **2778**
paste kode berikut tepat dibawahnya

```
//START CODE TELEGRAM
                    String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s&parse_mode=HTML";
                    //token bot telegram
                    String apiToken = koneksiDB.TOKENBOTTELE();
                    //chat id grup telegram
                    String chatId = koneksiDB.TELELAB();
//                    String PermintaanTx=TNoPermintaanPA.getText()+TNoPermintaanPK.getText();
                    String PasienTx=TPasien.getText();
                    String NoRMTx=TNoRM.getText();
                    String DokterTx=NmPerujuk.getText();
                    String Diagnosa=DiagnosisKlinis.getText();
                    String InfoTambahan=InformasiTambahan.getText();
                    String InfoTanggal=Valid.SetTgl(Tanggal.getSelectedItem()+"");
                    String InfoJam=CmbJam.getSelectedItem()+":"+CmbMenit.getSelectedItem();
                    String Prgraf = "<b><u>PERMINTAAN LAB</u></b>"+
//                            "%0ANomor Permintaan : <b>"+PermintaanTx+"</b>"+
                            "%0APasien : <b>"+PasienTx+" ||"+NoRMTx+"</b>"+
                            "%0ADokter Perujuk : <b>"+DokterTx+"</b>"+
                            "%0AIndikasi/Diagnosa: <b>"+Diagnosa+"</b>"+
                            "%0AInfo Tambahan: <b>"+InfoTambahan+"</b>"+
                            "%0A%0A=============: JADWAL PERIKSA :============="+
                            "%0ATanggal : <b>"+InfoTanggal+"</b>"+
                            "%0AJam : <b>"+InfoJam+" WIB</b>"+
                            "%0ALakukan Validasi di menu Permintaan LABORATORIUM";
                    String text = Prgraf;
                    String isiText = text.replace(" ", "%20");       
                    urlString = String.format(urlString, apiToken, chatId, isiText );
                      try {
                        URL url = new URL(urlString);
                        URLConnection conn = url.openConnection();
                        InputStream is = new BufferedInputStream(conn.getInputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                //END CODE TELEGRAM  
```

---
### NOTIFIKASI TELEGRAM BOT E-Resep
di file ***src/inventory/DlgPeresepanDokter.java***
cari code berikut di line **3820**

```
} catch (Exception e) {
            System.out.println("Notif : "+e);
        }
```
pastekan kode berikut ini tepat diatasnya

```

             if(sukses==true){
                 //START CODE TELEGRAM
                    String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s&parse_mode=HTML";
                    //token bot telegram
                    String apiToken = koneksiDB.TOKENBOTTELE();
                    //chat id grup telegram
                    String chatId = koneksiDB.TELEFARMASI();
                    String PermintaanTx=NoResep.getText();
                    String PasienTx=TPasien.getText();
                    String NoRMTx=TNoRw.getText();
                    String DokterTx=NmDokter.getText();
                    String InfoTanggal=Valid.SetTgl(DTPBeri.getSelectedItem()+"");
                    String InfoJam=cmbJam.getSelectedItem()+":"+cmbMnt.getSelectedItem();
                    String Prgraf = "<b><u>E-RESEP DOKTER</u></b>"+
//                            "%0ANomor Permintaan : <b>"+PermintaanTx+"</b>"+
                            "%0APasien : <b>"+PasienTx+" ||"+NoRMTx+"</b>"+
                            "%0ADokter Peresep : <b>"+DokterTx+"</b>"+
                            "%0A%0A=============: WAKTU RESEP :============="+
                            "%0ATanggal : <b>"+InfoTanggal+"</b>"+
                            "%0AJam : <b>"+InfoJam+" WIB</b>"+
                            "%0ALakukan Validasi di menu FARMASI";
                    String text = Prgraf;
                    String isiText = text.replace(" ", "%20");       
                    urlString = String.format(urlString, apiToken, chatId, isiText );
                      try {
                        URL url = new URL(urlString);
                        URLConnection conn = url.openConnection();
                        InputStream is = new BufferedInputStream(conn.getInputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                //END CODE TELEGRAM  
            }
```
