package br.com.estudos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImagemServlet
 */
@WebServlet("/ImagemServlet")
public class ImagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImagemServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("id");
		
		//pega o objeto pelo id
		
		Pessoa pessoa = new Pessoa();
		
		File imagem = new File(pessoa.getImagemCaminho()); // link para o arquivo no disco
		FileInputStream fis = new FileInputStream(imagem); // cria uma entrada (input) de dados vindo do arquivo
		byte[] arrayBytes = new byte[(int) imagem.length()]; //cria arraybytes do tamanho da imagem
		fis.read(arrayBytes); // pega a entrada e joga no arraybytes
		fis.close(); 
		
		response.getOutputStream().write(arrayBytes); // joga na saida
		
	}

}
