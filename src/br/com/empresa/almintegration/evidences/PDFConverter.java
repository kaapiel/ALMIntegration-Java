package br.com.empresa.almintegration.evidences;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.odftoolkit.odfdom.converter.core.ODFConverterException;
import org.odftoolkit.odfdom.converter.pdf.PdfConverter;
import org.odftoolkit.odfdom.converter.pdf.PdfOptions;
import org.odftoolkit.odfdom.doc.OdfDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.empresa.almintegration.execution.PlayServices;

public class PDFConverter implements Runnable {
	String odtFilename;
	String pdfFilename;
	private static Logger LOGGER = LoggerFactory.getLogger(PlayServices.class.getSimpleName());
	public PDFConverter(String odtFileName, String pdfFileName) {
		this.odtFilename = odtFileName;
		this.pdfFilename = pdfFileName;
		
		File file = new File(this.odtFilename);
		if(file.exists()){
			LOGGER.info("Arquivo ODT existe em " + this.odtFilename);
		}else{
			LOGGER.info("Arquivo ODT não existe em " + this.odtFilename);
		}
	}
	
	@Override
	public void run() {
		
		FileOutputStream out;
		try {
			out = new FileOutputStream(this.pdfFilename);
			PdfOptions options = PdfOptions.create();
			OdfDocument odfDocument = OdfDocument.loadDocument(this.odtFilename);
			PdfConverter.getInstance().convert(odfDocument, out, options);
			File file = new File(this.pdfFilename);
			if(file.exists()){
				LOGGER.info("Arquivo PDF existe em " + this.pdfFilename);
			}else{
				LOGGER.info("Arquivo PDF não existe em " + this.pdfFilename);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.info("Erro, arquivo odt não encontrado!");
			e.printStackTrace();
		} catch (ODFConverterException e) {
			// TODO Auto-generated catch block
			LOGGER.info("Erro, arquivo não convertido!");
			e.printStackTrace();
		} catch (IOException e) {
			LOGGER.info("Erro, arquivo ODT ocupado em outro processo!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.info("Erro geral!");
			e.printStackTrace();
		}			
	}
}

