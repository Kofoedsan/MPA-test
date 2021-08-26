package kofoednet.SupportTicketSimpleWebapp;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WaitingList extends HttpServlet {

    private DataMapper dataMapper;
    Queue<String> waitinglistQueue = new LinkedList<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("waitingnameSQL", DataMapper.waitinglistQueue());
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/waitingList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("requestname") != null) {
            waitinglistQueue.add(request.getParameter("requestname"));

        }
        if (request.getParameter("remove") != null) {
            try {
                waitinglistQueue.remove();
            } catch (Exception e) {
                request.setAttribute("FEJL", "Fejl i sletning");
            }


        }
        request.setAttribute("waitingname", waitinglistQueue);
        try {
            request.setAttribute("waitingnameSQL", DataMapper.waitinglistQueue());
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/waitingList.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}