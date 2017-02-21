package Sistema;
 
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FuncionarioDAO funcionarioDAO;
 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("127.0.0.1:3306");
        String jdbcUsername = getServletContext().getInitParameter("root");
        String jdbcPassword = getServletContext().getInitParameter("");
 
        funcionarioDAO = new FuncionarioDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertFuncionario(request, response);
                break;
            case "/delete":
                deleteFuncionario(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateFuncionario(request, response);
                break;
            default:
                listFuncionario(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listFuncionario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Funcionario> listFuncionario = funcionarioDAO.listAllFuncionarios();
        request.setAttribute("listFuncionario", listFuncionario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("FuncionarioList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("FuncionarioForm.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Funcionario existingFuncionario = funcionarioDAO.getFuncionario(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("FuncionarioForm.jsp");
        request.setAttribute("funcionario", existingFuncionario);
        dispatcher.forward(request, response);
 
    }
 
    private void insertFuncionario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nome = request.getParameter("nome");
 
        Funcionario newFuncionario = new Funcionario(nome);
        funcionarioDAO.insertFuncionario(newFuncionario);
        response.sendRedirect("list");
    }
 
    private void updateFuncionario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
 
        Funcionario funcionario = new Funcionario(id, nome);
        funcionarioDAO.updateFuncionario(funcionario);
        response.sendRedirect("list");
    }
 
    private void deleteFuncionario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Funcionario funcionario = new Funcionario(id);
        funcionarioDAO.deleteFuncionario(funcionario);
        response.sendRedirect("list");
 
    }
}