package com.tejpratapsingh.pdfcreator.views

import android.content.Context
import android.view.LayoutInflater
import com.tejpratapsingh.pdfcreator.R
import com.tejpratapsingh.pdfcreator.views.basic.PDFView
import kotlinx.android.synthetic.main.custom_header_view.view.*
import java.io.Serializable

/**
 *
 */
class HeaderView//Avoid pass null in the root it ignores spaces in the child layout
(context: Context?) : PDFView(),Serializable {

    var companyName: String? = null
        set(value) {
            field = value
            view.companyName.text = value

        }
    var userName: String? = null
        set(value) {

            field = value
            view.userName.text = value
            
        }
    var icon: Int? = null
        set(value) {

            field = value
            if (value != null) {
                view.icon.setImageResource(value)
            }

        }


    init {

        val inflater = LayoutInflater.from(context)

//to get the MainLayout
        view = inflater.inflate(R.layout.item_header_view, null);


    }

}