package com.tejpratapsingh.pdfcreator.views

import android.content.Context
import android.view.LayoutInflater
import com.tejpratapsingh.pdfcreator.R
import com.tejpratapsingh.pdfcreator.views.basic.PDFView
import kotlinx.android.synthetic.main.item_table_footer.view.*
import java.io.Serializable

/**
 *
 */
class TableFooterView//Avoid pass null in the root it ignores spaces in the child layout
(context: Context?) : PDFView(),Serializable {

    var name: String? = null
        set(value) {
            field = value
            view.name.text = value

        }
    var details: String? = null
        set(value) {
            field = value
            view.details.text = value

        }
    var paid: String? = null
        set(value) {
            field = value
            view.paid.text = value

        }
    var received: String? = null
        set(value) {
            field = value
            view.received.text = value

        }
    var createAt: String? = null
        set(value) {
            field = value
            view.createAt.text = value

        }



    init {

        val inflater = LayoutInflater.from(context)

//to get the MainLayout
        view = inflater.inflate(R.layout.item_table_footer, null);


    }

}