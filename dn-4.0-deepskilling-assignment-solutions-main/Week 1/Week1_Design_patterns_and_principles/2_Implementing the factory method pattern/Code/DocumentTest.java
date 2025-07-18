public class DocumentTest {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc =wordFactory.createDocument();
        wordDoc.open();

        DocumentFactory pdffactory  = new PdfDocumentFactory();
        Document pdfDoc = pdffactory.createDocument();
        pdfDoc.open();

        DocumentFactory excelfactory=new ExcelDocumentFactory();
        Document excelDoc = excelfactory.createDocument();
        excelDoc.open();
    }
}
