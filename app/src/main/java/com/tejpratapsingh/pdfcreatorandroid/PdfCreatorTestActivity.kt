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
import com.tejpratapsingh.pdfcreator.views.*
import com.tejpratapsingh.pdfcreator.views.basic.PDFTextView
import java.io.File

class PdfCreatorTestActivity : PDFCreatorActivity() {


    var fontLightEn: Typeface?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        fontLightEn = Typeface.createFromAsset(assets,
                "fonts/dana.ttf")

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

        val titleView = PDFTextView(applicationContext, PDFTextView.PDF_TEXT_SIZE.HEADER)
        titleView.setText("گزارش لیست مشتریان")
        titleView.setLayout(LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT))
        titleView.view.gravity = Gravity.CENTER_HORIZONTAL
        titleView.view.setTypeface(fontLightEn, Typeface.BOLD)
        titleView.setPadding(0, 20, 0, 0)

        pdfBody.addView(titleView)

        val dateView = PDFTextView(applicationContext, PDFTextView.PDF_TEXT_SIZE.H1)
        dateView.setText("( از امروز تا تاریخ ۱۳۹۹/۱۱/۱۵ )")
        dateView.setPadding(0, 10, 0, 0)
        dateView.setLayout(LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT))
        dateView.view.gravity = Gravity.CENTER_HORIZONTAL
        dateView.view.setTypeface(fontLightEn, Typeface.NORMAL)
        pdfBody.addView(dateView)

        val totalView=TotalTopView(applicationContext)
        val totalViewLayoutParam = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                80)
        totalViewLayoutParam.setMargins( 0, 20, 0, 0)
        totalView.setLayout(totalViewLayoutParam)

        val totalCustomerView = PDFTextView(applicationContext, PDFTextView.PDF_TEXT_SIZE.H2)
        totalCustomerView.setText("تعداد کل مشتریان: ۱۲۰ نفر")
        totalCustomerView.setPadding(0, 20, 0, 0)
        totalCustomerView.setLayout(LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT))
        totalCustomerView.view.gravity = Gravity.START
        totalCustomerView.view.setTypeface(fontLightEn, Typeface.NORMAL)


        val tableHeaderView=TableHeaderView(applicationContext)
        val tableHeaderViewLayoutParam = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                50)
        tableHeaderViewLayoutParam.setMargins( 0, 10, 0, 0)
        tableHeaderView.setLayout(tableHeaderViewLayoutParam)




        pdfBody.addView(totalView)
        pdfBody.addView(totalCustomerView)
        pdfBody.addView(tableHeaderView)

        for (i in 0..25){

            val tableRowView=TableRowView(applicationContext)
            tableRowView.name="میثم"
            tableRowView.createAt="۱۳۹۹/۵/۲۰"
            tableRowView.paid="۲۷،۰۰۰،۰۰۰"
            tableRowView.received="۱۴،۰۰۰،۰۰۰"
            tableRowView.details="+۹۸۹۱۷۱۳۹۲۷۵۶"
            val tableRowViewLayoutParam = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    50)
            tableRowViewLayoutParam.setMargins( 0, 0, 0, 0)
            tableRowView.setLayout(tableRowViewLayoutParam)

            pdfBody.addView(tableRowView)

        }


        return pdfBody
    }

    override fun onNextClicked(savedPDFFile: File) {
        val pdfUri = Uri.fromFile(savedPDFFile)
        val intentPdfViewer = Intent(this@PdfCreatorTestActivity, PdfViewerActivity::class.java)
        intentPdfViewer.putExtra(PdfViewerActivity.PDF_FILE_URI, pdfUri)
        startActivity(intentPdfViewer)
    }
}