package com.tejpratapsingh.pdfcreator.views

import android.content.Context
import android.view.LayoutInflater
import com.tejpratapsingh.pdfcreator.R
import com.tejpratapsingh.pdfcreator.views.basic.PDFView
import kotlinx.android.synthetic.main.item_header_view.view.*
import java.io.Serializable

/**
 *
 */
class TableHeaderView//Avoid pass null in the root it ignores spaces in the child layout
(context: Context?) : PDFView(),Serializable {



    init {

        val inflater = LayoutInflater.from(context)

//to get the MainLayout
        view = inflater.inflate(R.layout.item_table_header, null);


    }

}