package com.crystalprinter.grv.Services;

import com.crystaldecisions.report.web.viewer.CrystalReportViewer;
import com.crystaldecisions.sdk.occa.report.application.OpenReportOptions;
import com.crystaldecisions.sdk.occa.report.application.ReportClientDocument;
import com.crystaldecisions.sdk.occa.report.exportoptions.ReportExportFormat;
import java.io.ByteArrayInputStream;

public class exporter {
    String reportPath;
    Object reportSource;
    ReportClientDocument reportClientDocument;
    ByteArrayInputStream byteArrayInputStream;
    byte[] byteArray;
    int bytesRead;
    reportPath = request.getParameter("report_path");

    public void foo(){
        /*
        * Instantiate ReportClientDocument and specify the Java Print Engine as the report processor.
        * Open a rpt file and export to PDF.  Stream PDF back to web browser.
        */

        reportClientDocument = new ReportClientDocument();

        reportClientDocument.setReportAppServer(ReportClientDocument.inprocConnectionString);

        reportClientDocument.open(reportPath, OpenReportOptions._openAsReadOnly);

        reportSource = reportClientDocument.getReportSource();
        session.setAttribute("ReportSource", reportSource);

        byteArrayInputStream = (ByteArrayInputStream) reportClientDocument
                .getPrintOutputController().export(ReportExportFormat.PDF);

        response.reset();

        response.setHeader("Content-disposition", "inline;filename=crreport.pdf");
        response.setContentType("application/pdf");

        byteArray = new byte[1024];
        while((bytesRead = byteArrayInputStream.read(byteArray)) != -1) {
            response.getOutputStream().write(byteArray, 0, bytesRead);	
        }

        response.getOutputStream().flush();
        response.getOutputStream().close();

        reportClientDocument.close();
    }
}