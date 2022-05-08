package com.example.qrcode

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Color.BLACK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter

class generating : AppCompatActivity() {
    private lateinit var ivQRcode:ImageView
    private  lateinit var etData:EditText
    private lateinit var btnGeneratorQRcode:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generating)

        var ivQRcode=findViewById<ImageView>(R.id.ivQRCode)
        var etData=findViewById<EditText>(R.id.etData)
        var btnGeneratorQRcode=findViewById<Button>(R.id.btnGenerateQRcode)

        btnGeneratorQRcode.setOnClickListener {

            val data =etData.text.toString().trim()
            if (data.isEmpty()){
                Toast.makeText(this,"enter some data",Toast.LENGTH_SHORT).show()
            }else{

                val writer =QRCodeWriter()
                try {

                    val bitMatrix=writer.encode(data ,BarcodeFormat.QR_CODE ,512 , 512)
                    val width=bitMatrix.width
                    val height=bitMatrix.height
                    val bmp =Bitmap.createBitmap(width , height , Bitmap.Config.RGB_565)
                    for (x in 0 until width){
                        for (y in 0 until  height){
                            bmp.setPixel(x,y,if (bitMatrix[x,y]) Color.BLACK else Color.WHITE)
                        }
                    }
                    ivQRcode.setImageBitmap(bmp)
                }catch (e :WriterException){

                    e.printStackTrace()

                }

            }
        }
    }
}