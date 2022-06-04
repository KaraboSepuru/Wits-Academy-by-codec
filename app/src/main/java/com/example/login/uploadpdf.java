package com.example.login;

public class uploadpdf {
    public String pdfname,pdfurl;

    public uploadpdf(){

    }
    public uploadpdf(String pdfname,String pdfurl){
        setPdfname(pdfname);
        setPdfurl(pdfurl);
    }

    public String getPdfname(){
        return pdfname;
    }
    public String getPdfurl(){
        return pdfurl;
    }
    private void setPdfname(String pdfname){
        this.pdfname=pdfname;
    }
    private void setPdfurl(String pdfurl){
        this.pdfurl=pdfurl;
    }
}
