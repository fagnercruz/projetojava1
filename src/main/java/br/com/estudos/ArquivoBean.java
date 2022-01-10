package br.com.estudos;

import java.io.File;
import java.io.FileOutputStream;

import javax.faces.bean.ManagedBean;

import org.apache.catalina.core.ApplicationPart;

@ManagedBean
public class ArquivoBean {

	private ApplicationPart imagem;
	private Pessoa pessoa;

	
	
	public void salvarImagem() {
		String caminhoImagem = "D:\\imagens\\" + imagem.getSubmittedFileName();
		if(imagem != null && imagem.getSubmittedFileName() != null) {
			try {
				byte[] imagemEmBytes = new byte[(int) imagem.getSize()];
				File arquivo = new File(caminhoImagem);
				FileOutputStream fileOutputStream = new FileOutputStream(arquivo);
				fileOutputStream.write(imagemEmBytes);
				fileOutputStream.close();
				pessoa.setImagemCaminho(caminhoImagem);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
}
