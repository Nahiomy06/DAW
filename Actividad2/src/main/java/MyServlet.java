

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String opcion = request.getParameter("opcion");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Resultado</title>");
        out.println("<link rel='stylesheet' href='styles.css'>");
        out.println("</head>");
        out.println("<body>");

        // par o impar
        if (opcion.equals("par")) {
            int numero = Integer.parseInt(request.getParameter("numero"));
            out.println("<h1>Resultado</h1>");
            if (numero % 2 == 0) {
                out.println("<p>El número " + numero + " es PAR.</p>");
            } else {
                out.println("<p>El número " + numero + " es IMPAR.</p>");
            }
        }
        
        // Generar número aleatorio
        if (opcion.equals("aleatorio")) {

            int minimo = Integer.parseInt(request.getParameter("minimo"));
            int maximo = Integer.parseInt(request.getParameter("maximo"));

            out.println("<h1>Resultado</h1>");

            if (minimo > maximo) {

                out.println("<p>El mínimo no puede ser mayor que el máximo.</p>");

            } else {

                int numero = (int) (Math.random() *
                        (maximo - minimo + 1)) + minimo;

                out.println("<p>El número aleatorio generado es: "
                        + numero + "</p>");
            }
        }
        out.println("<br>");
        out.println("<a href='index.jsp'>Volver</a>");

        out.println("</body>");
        out.println("</html>");
    }
}
