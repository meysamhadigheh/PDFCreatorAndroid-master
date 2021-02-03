package com.tejpratapsingh.pdfcreatorandroid

import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.Toast
import com.tejpratapsingh.pdfcreator.activity.PDFCreatorActivity
import com.tejpratapsingh.pdfcreator.utils.PDFUtil.PDFUtilListener
import com.tejpratapsingh.pdfcreator.views.HeaderView
import com.tejpratapsingh.pdfcreator.views.PDFBody
import com.tejpratapsingh.pdfcreator.views.PDFHeaderView
import com.tejpratapsingh.pdfcreator.views.basic.PDFTextView
import java.io.File

class PdfCreatorTestActivity : PDFCreatorActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        createPDF("test", object : PDFUtilListener {
            override fun pdfGenerationSuccess(savedPDFFile: File) {
                Toast.makeText(this@PdfCreatorTestActivity, "PDF Created", Toast.LENGTH_SHORT).show()
            }

            override fun pdfGenerationFailure(exception: Exception) {
                Toast.makeText(this@PdfCreatorTestActivity, "PDF NOT Created", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun getHeaderView(pageIndex: Int): PDFHeaderView {
        val headerView = PDFHeaderView(applicationContext)
        val customHeader = HeaderView(applicationContext)
        customHeader.companyName="رقم"
        customHeader.userName="میثم"
        customHeader.icon=R.drawable.ic_focus
        headerView.addView(customHeader)

        return headerView
    }

    override fun getBodyViews(): PDFBody {
        val pdfBody = PDFBody()

        val title = PDFTextView(applicationContext, PDFTextView.PDF_TEXT_SIZE.HEADER)
        title.setText("گزارش لیست مشتریان")
        title.setLayout(LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT))
        title.view.gravity = Gravity.CENTER_HORIZONTAL
        title.view.setTypeface(title.view.typeface, Typeface.BOLD)
        title.setPadding(0,30,0,0)

        pdfBody.addView(title)

        val date = PDFTextView(applicationContext, PDFTextView.PDF_TEXT_SIZE.HEADER)
        date.setText("( از امروز تا تاریخ ۱۳۹۹/۱۱/۱۵ )")
        date.setPadding(0,10,0,0)
        date.setLayout(LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT))
        date.view.gravity = Gravity.CENTER_HORIZONTAL
        pdfBody.addView(date)

        return pdfBody
    }

    override fun onNextClicked(savedPDFFile: File) {
        val pdfUri = Uri.fromFile(savedPDFFile)
        val intentPdfViewer = Intent(this@PdfCreatorTestActivity, PdfViewerActivity::class.java)
        intentPdfViewer.putExtra(PdfViewerActivity.PDF_FILE_URI, pdfUri)
        startActivity(intentPdfViewer)
    }
}