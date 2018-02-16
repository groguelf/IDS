import java.net.*;
import java.io.*;

public class CalculatorServer {
  public static class Operation implements Calculator_itf {
    public int plus(int a, int b){
      return a + b;
    }

    public int minus(int a, int b){
      return a - b;
    }

    public int divide(int a, int b){
      return a / b;
    }

    public int multiply(int a, int b){
      return a * b;
    }
  }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java CalculatorServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        Operation op = new Operation();

        try (
            ServerSocket serverSocket =
                new ServerSocket(Integer.parseInt(args[0]));
            Socket clientSocket = serverSocket.accept();
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;
            int a = 0, b = 0, result = 0;
            while ((inputLine = in.readLine()) != null) {
                char operation = inputLine.charAt(0);
                int i = 2;
                while (i < inputLine.length() && inputLine.charAt(i) != ' '){
                  a = 10 * a + (inputLine.charAt(i) - '0');
                  i += 1;
                }
                i += 1;
                while (i < inputLine.length() && inputLine.charAt(i) != ' '){
                  b = 10 * b + (inputLine.charAt(i) - '0');
                  i += 1;
                }
                switch(operation){
                  case '+':
                    result = op.plus(a, b);
                    break;
                  case '-':
                    result = op.minus(a, b);
                    break;
                  case '/':
                    if (b == 0){
                      result = 0;
                    } else {
                      result = op.divide(a, b);
                    }
                    break;
                  case '*':
                    result = op.multiply(a, b);
                    break;
                  default:
                    break;
                }
                out.println(result);
                a = 0;
                b = 0;
                result = 0;
            }
            System.out.println("I'm ending...");
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
