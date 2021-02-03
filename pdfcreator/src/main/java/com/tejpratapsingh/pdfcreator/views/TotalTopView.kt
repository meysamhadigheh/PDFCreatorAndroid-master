package com.tejpratapsingh.pdfcreator.views

import android.content.Context
import android.view.LayoutInflater
import com.tejpratapsingh.pdfcreator.R
import com.tejpratapsingh.pdfcreator.views.basic.PDFView
import kotlinx.android.synthetic.main.item_total_top_view.view.*
import java.io.Serializable

/**
 *
 */
class TotalTopView//Avoid pass null in the root it ignores spaces in the child layout
(context: Context?) : PDFView(),Serializable {

    var totalPrice: String? = null
        set(value) {
            field = value
            view.totalPrice.text = value

        }
    var paidPrice: String? = null
        set(value) {

            field = value
            view.paidPrice.text = value
            
        }
    var receivedPrice: String? = null
        set(value) {

            field = value
            view.receivedPrice.text = value

        }



    init {

        val inflater = LayoutInflater.from(context)

//to get the MainLayout
        view = inflater.inflate(R.layout.item_total_top_view, null);


    }

}