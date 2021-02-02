package com.tejpratapsingh.pdfcreator.views

import android.content.Context
import android.view.LayoutInflater
import com.tejpratapsingh.pdfcreator.R
import com.tejpratapsingh.pdfcreator.views.basic.PDFView
import kotlinx.android.synthetic.main.custom_reminder_card.view.*
import java.io.Serializable

/**
 *
 */
class ReminderCardView//Avoid pass null in the root it ignores spaces in the child layout
(context: Context?) : PDFView(),Serializable {

    var title: String? = null
        set(value) {
            field = value
            view.titleTxt.text = value

        }
    var price: String? = null
        set(value) {

            field = value
            view.priceTxt.text = value
            
        }
    var date: String? = null
        set(value) {

            field = value
            view.dateTxt.text = value

        }
    var from: String? = null
        set(value) {

            field = value
            view.fromTxt.text = value

        }
    var phone: String? = null
        set(value) {

            field = value
            view.phoneTxt.text = value
         
        }
    var currency: String? = null
        set(value) {

            field = value
            view.currencyTxt.text = value
           
        }

    init {

        val inflater = LayoutInflater.from(context)

//to get the MainLayout
        view = inflater.inflate(R.layout.custom_reminder_card, null);


    }

}