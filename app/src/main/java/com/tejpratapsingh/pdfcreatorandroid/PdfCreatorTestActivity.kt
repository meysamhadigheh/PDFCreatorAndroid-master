package com.tejpratapsingh.pdfcreatorandroid

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import com.tejpratapsingh.pdfcreator.activity.PDFCreatorActivity
import com.tejpratapsingh.pdfcreator.utils.PDFUtil.PDFUtilListener
import com.tejpratapsingh.pdfcreator.views.HeaderView
import com.tejpratapsingh.pdfcreator.views.PDFBody
import com.tejpratapsingh.pdfcreator.views.PDFHeaderView
import com.tejpratapsingh.pdfcreator.views.PDFTableView
import com.tejpratapsingh.pdfcreator.views.PDFTableView.PDFTableRowView
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

        return pdfBody
    }

    override fun onNextClicked(savedPDFFile: File) {
        val pdfUri = Uri.fromFile(savedPDFFile)
        val intentPdfViewer = Intent(this@PdfCreatorTestActivity, PdfViewerActivity::class.java)
        intentPdfViewer.putExtra(PdfViewerActivity.PDF_FILE_URI, pdfUri)
        startActivity(intentPdfViewer)
    }
}