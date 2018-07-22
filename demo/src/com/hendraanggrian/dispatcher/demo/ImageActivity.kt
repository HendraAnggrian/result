package com.hendraanggrian.dispatcher.demo

import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.hendraanggrian.bundler.Bundler
import com.hendraanggrian.bundler.Extra
import com.hendraanggrian.dispatcher.R
import kotlinx.android.synthetic.main.activity_image.*
import java.io.File
import java.io.Serializable

class ImageActivity : AppCompatActivity() {

    @Extra @JvmField var file: Serializable? = null
    @Extra @JvmField var uri: Parcelable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        Bundler.bindExtras(this)
        if (file != null) {
            photoView!!.setImageURI(Uri.fromFile(file as File?))
        } else if (uri != null) {
            photoView!!.setImageURI(uri as Uri?)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}