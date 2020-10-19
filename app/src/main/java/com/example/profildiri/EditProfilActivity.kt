package com.example.profildiri

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_profil.*

class EditProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil)

        val intentData = intent.extras
        val namaUser = intentData?.getString("nama")
        //set edittext dengan data yang dikirimkan tadi
        edtProfilName.setText(namaUser)
        val emailUser = intentData?.getString("email")
        edtProfilEmail.setText(emailUser)
        val telpUser = intentData?.getString("telp")
        edtProfilTelp.setText(telpUser)
        val addressUser = intentData?.getString("alamat")
        edtProfilAddress.setText(addressUser)
        //memberikan action click ke tombol Simpan
        btnEditSave.setOnClickListener { saveData() }
    }

    //mengirimkan kembali ke ProfilActivity.kt
    private fun saveData(){
        val namaEdit = edtProfilName.text.toString()
        val emailEdit = edtProfilEmail.text.toString()
        val telpEdit = edtProfilTelp.text.toString()
        val addressEdit = edtProfilAddress.text.toString()
        if (!namaEdit.isEmpty()) {
    //jika editText namaEdit tidak kosong, maka kirimkan value nya ke ProfilActivity, dan beri tanda RESULT_OK
            val result = Intent()
            result.putExtra("nama", namaEdit)
            result.putExtra("email", emailEdit)
            result.putExtra("telp", telpEdit)
            result.putExtra("alamat", addressEdit)
            setResult(Activity.RESULT_OK, result)
        } else {
    //jika editText namaEdit kosong, maka kirimkan tanda RESULT_CANCELED
            setResult(Activity.RESULT_CANCELED)
        }
        finish()
    }

}
