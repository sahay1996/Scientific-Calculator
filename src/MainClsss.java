import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Calculator application 
 * @author Anonymous
 */
public class Calculator extends Application {

    /**
     * declare of objects and variables that we will use it in our project
     */
    TextArea textarea = new TextArea();
    String showExpression = "";
    String hiddenExpression = "";
    boolean isSquare = false;
    boolean isOpen = false;
    boolean isequal = false;
    int countOpen = 0;
    static String answer;
    int countClose = 0;
    long startTime;
    long currentTime;
    VBox vbox2; //design pane

    @Override
    public void start(Stage arg0) throws Exception {
        /**
         * call function of project design that contain all design of the
         * project and return v box that contain all design of the project
         */
        vbox2 = desingCalculator();
        Scene scene = new Scene(vbox2, 350, 400);
        arg0.setTitle("Calcluator");
        arg0.setScene(scene);
        arg0.show();

        arg0.setOnCloseRequest(e -> {
            arg0.close();
        });
    }

    /**
     * function called desingCalculator that contains  design of the project and include
     * v box contain text area and 3 h boxes (h box1,h box2, and h box3 ) h
     * box 1 contains buttons 1 , 2 ,3 , clear , and reset h box 2 contains
     * buttons 4 , 5 ,6 , multiplication and division h box 3 contains
     * buttons 7 , 8 ,9 and brackets h box 4 contains buttons 0 , . ,%,+ and
     * - h box 5 contains buttons x^2 ,root and =
     * and set the width and height of buttons and variables and objects to be
     * interactive with the width and height of the window if user minimize
     * or maximize window
     * and action of buttons and components
     * @return 
     */
    public VBox desingCalculator() {
        VBox vbox = new VBox();
        Button one = new Button("1"); //buttons 
        Button two = new Button("2");
        Button three = new Button("3");
        Button four = new Button("4");
        Button five = new Button("5");
        Button six = new Button("6");
        Button seven = new Button("7");
        Button eight = new Button("8");
        Button nine = new Button("9");
        Button plus = new Button("+");
        Button minus = new Button("-");
        Button mul = new Button("*");
        Button div = new Button("/");
        Button sqrt = new Button("âˆڑ");
        Button mod = new Button("%");
        Button dot = new Button(".");
        Button square = new Button("x^2");
        Button equal = new Button("=");
        Button open = new Button("(");
        Button close = new Button(")");
        Button clear = new Button("â†گ");
        Button zero = new Button("0");
        Button reset = new Button("Reset");
        
        Button sin = new Button("sin");
        Button cos = new Button("cos");
        Button tan = new Button("tan");

        Button ans = new Button("ans");
        Button pi = new Button("pi");
//set css design to components of design
              one.setStyle("-fx-font-size:20; -fx-color:#004646");
                two.setStyle("-fx-font-size:20; -fx-color:#004646");
                three.setStyle("-fx-font-size:20; -fx-color:#004646");
                four.setStyle("-fx-font-size:20; -fx-color:#004646");
                five.setStyle("-fx-font-size:20; -fx-color:#004646");
                six.setStyle("-fx-font-size:20; -fx-color:#004646");
                seven.setStyle("-fx-font-size:20; -fx-color:#004646");
                eight.setStyle("-fx-font-size:20; -fx-color:#004646");
                nine.setStyle("-fx-font-size:20; -fx-color:#004646");
                zero.setStyle("-fx-font-size:20; -fx-color:#004646");
                reset.setStyle("-fx-color:#088A85 ");
                clear.setStyle("-fx-color:#088A85 ");
                 plus.setStyle("-fx-font-size:20; -fx-color:#088A85");
                  minus.setStyle("-fx-font-size:20; -fx-color:#088A85");
                   div.setStyle("-fx-font-size:20; -fx-color:#088A85");
                   mul.setStyle("-fx-font-size:20; -fx-color:#088A85");
                   mod.setStyle("-fx-font-size:20; -fx-color:#088A85");
                   dot.setStyle("-fx-font-size:20; -fx-color:#088A85");
                   sqrt.setStyle("-fx-font-size:20; -fx-color:#088A85");
                      square.setStyle("-fx-font-size:20; -fx-color:#088A85");
                   open.setStyle("-fx-font-size:20; -fx-color:#088A85");
                   close.setStyle("-fx-font-size:20; -fx-color:#088A85");
                   equal.setStyle("-fx-font-size:20; -fx-color:#04B431");
                  //set css design to components of design
                  ans.setStyle("-fx-font-size:20; -fx-color: #04B431");
                  pi.setStyle("-fx-font-size:20; -fx-color: #04B431");
                  sin.setStyle("-fx-font-size:20; -fx-color: red");
        cos.setStyle("-fx-font-size:20; -fx-color: red");
        tan.setStyle("-fx-font-size:20; -fx-color: red");


        HBox hbox1 = new HBox();
       // hbox1.setSpacing(0);
        hbox1.getChildren().addAll(one, two, three, clear, reset);
        HBox hbox2 = new HBox();
        //hbox2.setSpacing(2);
        hbox2.getChildren().addAll(four, five, six, mul, div);
        HBox hbox3 = new HBox();
       // hbox3.setSpacing(2);
        hbox3.getChildren().addAll(seven, eight, nine, open, close);
        HBox hbox4 = new HBox();
       // hbox4.setSpacing(2);
        HBox hbox5 = new HBox();
        HBox hbox6=new HBox();
        hbox6.getChildren().addAll(pi,ans,equal);
       // hbox5.setSpacing(2);
        hbox4.getChildren().addAll(zero, dot, mod,plus, minus);

        hbox5.getChildren().addAll(square, sqrt,sin,cos,tan);
        
       // HBox hbox6 = new HBox();
       // hbox6.getChildren().addAll(ans, sin, cos, tan, pi);
        
        sin.prefWidthProperty().bind(hbox5.widthProperty().divide(5));
        sin.prefHeightProperty().bind(hbox5.heightProperty());
        
        cos.prefWidthProperty().bind(hbox5.widthProperty().divide(5));
        cos.prefHeightProperty().bind(hbox5.heightProperty());
        
        tan.prefWidthProperty().bind(hbox5.widthProperty().divide(5));
        tan.prefHeightProperty().bind(hbox5.heightProperty());
        
        
        ans.prefWidthProperty().bind(hbox6.widthProperty().divide(5));
        ans.prefHeightProperty().bind(hbox6.heightProperty());

     
        pi.prefWidthProperty().bind(hbox5.widthProperty().divide(5));
        pi.prefHeightProperty().bind(hbox5.heightProperty());

        one.prefWidthProperty().bind(hbox1.widthProperty().divide(5));
        one.prefHeightProperty().bind(hbox1.heightProperty());
        two.prefWidthProperty().bind(hbox1.widthProperty().divide(5));
        two.prefHeightProperty().bind(hbox1.heightProperty());
        three.prefWidthProperty().bind(hbox1.widthProperty().divide(5));
        three.prefHeightProperty().bind(hbox1.heightProperty());
        four.prefWidthProperty().bind(hbox2.widthProperty().divide(5));
        four.prefHeightProperty().bind(hbox1.heightProperty());
        five.prefWidthProperty().bind(hbox2.widthProperty().divide(5));
        five.prefHeightProperty().bind(hbox1.heightProperty());
        six.prefWidthProperty().bind(hbox1.widthProperty().divide(5));
        six.prefHeightProperty().bind(hbox1.heightProperty());
        seven.prefWidthProperty().bind(hbox1.widthProperty().divide(5));
        seven.prefHeightProperty().bind(hbox1.heightProperty());
        eight.prefWidthProperty().bind(hbox1.widthProperty().divide(5));
        eight.prefHeightProperty().bind(hbox1.heightProperty());
        nine.prefWidthProperty().bind(hbox1.widthProperty().divide(5));
        nine.prefHeightProperty().bind(hbox1.heightProperty());
        zero.prefWidthProperty().bind(hbox1.widthProperty().divide(5));
        zero.prefHeightProperty().bind(hbox1.heightProperty());
        plus.prefWidthProperty().bind(hbox1.widthProperty().divide(5));
        plus.prefHeightProperty().bind(hbox1.heightProperty());
        minus.prefWidthProperty().bind(hbox1.widthProperty().divide(5));
        minus.prefHeightProperty().bind(hbox1.heightProperty());
        mul.prefWidthProperty().bind(hbox1.widthProperty().divide(5));
        mul.prefHeightProperty().bind(hbox1.heightProperty());
        div.prefWidthProperty().bind(hbox1.widthProperty().divide(5));
        div.prefHeightProperty().bind(hbox1.heightProperty());
        dot.prefWidthProperty().bind(hbox1.widthProperty().divide(5));
        dot.prefHeightProperty().bind(hbox1.heightProperty());
        mod.prefWidthProperty().bind(hbox1.widthProperty().divide(5));
        mod.prefHeightProperty().bind(hbox1.heightProperty());
        open.prefWidthProperty().bind(hbox1.widthProperty().divide(5));
        open.prefHeightProperty().bind(hbox1.heightProperty());
        close.prefWidthProperty().bind(hbox1.widthProperty().divide(5));
        close.prefHeightProperty().bind(hbox1.heightProperty());
        clear.prefWidthProperty().bind(hbox1.widthProperty().divide(5));
        clear.prefHeightProperty().bind(hbox1.heightProperty());
        reset.prefWidthProperty().bind(hbox1.widthProperty().divide(5));
        reset.prefHeightProperty().bind(hbox1.heightProperty());
        square.prefWidthProperty().bind(hbox5.widthProperty().divide(5));
        square.prefHeightProperty().bind(hbox5.heightProperty());
        sqrt.prefWidthProperty().bind(hbox5.widthProperty().divide(5));
        sqrt.prefHeightProperty().bind(hbox5.heightProperty());
        equal.prefHeightProperty().bind(hbox5.heightProperty());

        equal.prefWidthProperty().bind(hbox6.widthProperty().divide(5).multiply(3));
        vbox.getChildren().addAll(textarea, hbox1, hbox2, hbox3, hbox4, hbox5,hbox6);
        hbox1.prefWidthProperty().bind(vbox.widthProperty());
        hbox2.prefWidthProperty().bind(vbox.widthProperty());
        hbox3.prefWidthProperty().bind(vbox.widthProperty());
        hbox4.prefWidthProperty().bind(vbox.widthProperty());
        hbox5.prefWidthProperty().bind(vbox.widthProperty());
        //hbox6.prefWidthProperty().bind(vbox.widthProperty());

        hbox1.prefHeightProperty().bind(vbox.heightProperty().divide(7));
        hbox2.prefHeightProperty().bind(vbox.heightProperty().divide(7));
        hbox3.prefHeightProperty().bind(vbox.heightProperty().divide(7));
        hbox4.prefHeightProperty().bind(vbox.heightProperty().divide(7));
        hbox5.prefHeightProperty().bind(vbox.heightProperty().divide(7));
        hbox6.prefHeightProperty().bind(vbox.heightProperty().divide(7));

        textarea.prefWidthProperty().bind(vbox.widthProperty());
        textarea.prefHeightProperty().bind(vbox.heightProperty().divide(7));
        
        
        
        sin.setOnAction(e -> {
       char ch = ' ';
            if (!showExpression.equals("")) {
                ch = showExpression.charAt(showExpression.length() - 1);
            }
                      if(ch=='.'){
                          showExpression+="0";
            hiddenExpression+="0";
            ch='0';
        }
            if(showExpression.equals(""))
            {
            showExpression+="sin(";
            hiddenExpression+="@(";
            textarea.setText(showExpression);
            countOpen++;
            isOpen=true;
              isequal=false;
            }
            
             else if(Character.isDigit(ch)|| ch==')'|| isSquare|| ch=='i')
            {
            showExpression+="*sin(";
            hiddenExpression+="*@(";
            textarea.setText(showExpression);
            countOpen++;
             isOpen=true;
               isequal=false;
            }
            else if(ch=='('|| ch=='*' || ch=='/' || ch=='+' || ch=='-' || ch=='%'||ch=='âˆڑ')
            {
              
               showExpression+="sin(";
               hiddenExpression+="@(";
               textarea.setText(showExpression);
              countOpen++;
                 isOpen=true;
                   isequal=false;
            
            }
         });
        
        
        //// cos button///////////
        cos.setOnAction(e -> {
       char ch = ' ';
            if (!showExpression.equals("")) {
                ch = showExpression.charAt(showExpression.length() - 1);
            }
              if(ch=='.'){
                          showExpression+="0";
            hiddenExpression+="0";
            ch='0';
        }
            if(showExpression.equals(""))
            {
            showExpression+="cos(";
            hiddenExpression+="1*&(";
            textarea.setText(showExpression);
            countOpen++;
             isOpen=true;
             isequal=false;
            
            }
            else if(Character.isDigit(ch)|| ch==')'|| isSquare|| ch=='i')
            {
            showExpression+="*cos(";
            hiddenExpression+="*&(";
            textarea.setText(showExpression);
            countOpen++;
             isOpen=true;
               isequal=false;
            }
            else if(ch=='('|| ch=='*' || ch=='/' || ch=='+' || ch=='-' || ch=='%' ||ch=='âˆڑ')
            {
              
               showExpression+="cos(";
               hiddenExpression+="&(";
               textarea.setText(showExpression);
              countOpen++;
                 isOpen=true;
                   isequal=false;
            
            }
         });
        /// tan button //////////////////////////
        
        tan.setOnAction(e -> {
       char ch = ' ';
            if (!showExpression.equals("")) {
                ch = showExpression.charAt(showExpression.length() - 1);
            }
              if(ch=='.'){
                          showExpression+="0";
            hiddenExpression+="0";
            ch='0';
        }
              
//              if(ch=='i'){
//                          showExpression+="*tan(";
//            hiddenExpression+="*#(";
//            ch='0';
//        }
            if(showExpression.equals(""))
            {
            showExpression+="tan(";
            hiddenExpression+="1*#(";
            textarea.setText(showExpression);
            isOpen=true;
            countOpen++;
              isequal=false;
            }
             else if(Character.isDigit(ch)|| ch==')'|| isSquare|| ch=='i')
            {
            showExpression+="*tan(";
            hiddenExpression+="*#(";
            textarea.setText(showExpression);
            countOpen++;
             isOpen=true;
               isequal=false;
            }
            else if(ch=='('|| ch=='*' || ch=='/' || ch=='+' || ch=='-' || ch=='%' ||ch=='âˆڑ')
            {
              
               showExpression+="tan(";
               hiddenExpression+="#(";
               textarea.setText(showExpression);
              countOpen++;
               isOpen=true;
                  isequal=false;
            
            }
         });
        
        ///// pi button////////////////
        pi.setOnAction(e -> {
           
       char ch = ' ';
            if (!showExpression.equals("")) {
                ch = showExpression.charAt(showExpression.length() - 1);
            }
            if(isequal){
                         showExpression="pi";
                          hiddenExpression="1*3.1428";
            textarea.setText(showExpression);
             isequal=false;
            }
            if(showExpression.equals(""))
            {
            showExpression+="pi";
            hiddenExpression+="1*3.1428";
            textarea.setText(showExpression);
            }
            else if(Character.isDigit(ch)){
            
            }
            else
            {
            showExpression+="pi";
            hiddenExpression+="1*3.1428";
            textarea.setText(showExpression);
            }
            
                    });
        ///////////////////////////////////////////////////////////////// one button is clicked
        /**
         * when click on button 1 we check if last character is not ')' and is
         * square is false set 1 to show expression and set 1 to hidden
         * expression that we calculate later
         */
        one.setOnAction(e -> {

            //fsqrt=0; fsquare=0;fmul=0;fmin=0;fplus=0;fdiv=0;fmod=0;
            char ch = ' ';
            if (!showExpression.equals("")) {
                ch = showExpression.charAt(showExpression.length() - 1);
            }
            if ((ch != ')' && isSquare == false)) {
                showExpression += "1";
                hiddenExpression += "1";
                textarea.setText(showExpression);
            }
            if (isequal) {
                showExpression = "1";
                hiddenExpression = "1";
                textarea.setText(showExpression);
                isequal = false;
            }

        });
        ///////////////////////////////////////////////////////////////// two button is clicked
        /**
         * when click on button 2 we check if last character is not ')' and is
         * square is false set 2 to show expression and set 2 to hidden
         * expression that we calculate later
         */
        two.setOnAction(e -> {

            char ch = ' ';
            if (!showExpression.equals("")) {
                ch = showExpression.charAt(showExpression.length() - 1);
            }
            if ((ch != ')' && isSquare == false)) {
                showExpression += "2";
                hiddenExpression += "2";
                textarea.setText(showExpression);
            }
            if (isequal) {
                
                showExpression = "2";
                hiddenExpression = "2";
                textarea.setText(showExpression);
                isequal = false;
            }
        });
        ///////////////////////////////////////////////////////////////// three button is clicked
        /**
         * when click on button 3 we check if last character is not ')' and is
         * square is false set 3 to show expression and set 3 to hidden
         * expression that we calculate later
         */
        three.setOnAction(e -> {

            char ch = ' ';
            if (!showExpression.equals("")) {
                ch = showExpression.charAt(showExpression.length() - 1);
            }
            if ((ch != ')' && isSquare == false)) {
                showExpression += "3";
                hiddenExpression += "3";
                textarea.setText(showExpression);

            }
            if (isequal) {
                showExpression = "3";
                hiddenExpression = "3";
                textarea.setText(showExpression);
                isequal = false;
            }
        });
        ///////////////////////////////////////////////////////////////// four button is clicked
        /**
         * when click on button 4 we check if last character is not ')' and is
         * square is false set 4 to show expression and set 4 to hidden
         * expression that we calculate later
         */
        four.setOnAction(e -> {

            char ch = ' ';
            if (!showExpression.equals("")) {
                ch = showExpression.charAt(showExpression.length() - 1);
            }
            if ((ch != ')' && isSquare == false)) {
                showExpression += "4";
                hiddenExpression += "4";
                textarea.setText(showExpression);
            }
            if (isequal) {
                showExpression = "4";
                hiddenExpression = "4";
                textarea.setText(showExpression);
                isequal = false;
            }
          
        });

        /**
         * when click on button 5 we check if last character is not ')' and is
         * square is false set 5 to show expression and set 5 to hidden
         * expression that we calculate later
         */
        five.setOnAction(e -> {

            char ch = ' ';
            if (!showExpression.equals("")) {
                ch = showExpression.charAt(showExpression.length() - 1);
            }
            if ((ch != ')' && isSquare == false)) {
                showExpression += "5";
                hiddenExpression += "5";
                textarea.setText(showExpression);
            }
            if (isequal) {
                showExpression = "5";
                hiddenExpression = "5";
                textarea.setText(showExpression);
                isequal = false;
            }
        });
        ///////////////////////////////////////////////////////////////// six button is clicked
        /**
         * when click on button 6 we check if last character is not ')' and is
         * square is false set 6 to show expression and set 6 to hidden
         * expression that we calculate later
         */
        six.setOnAction(e -> {

            char ch = ' ';
            if (!showExpression.equals("")) {
                ch = showExpression.charAt(showExpression.length() - 1);
            }
            if ((ch != ')' && isSquare == false)) {
                showExpression += "6";
                hiddenExpression += "6";
                textarea.setText(showExpression);
            }
            if (isequal) {
                showExpression = "6";
                hiddenExpression = "6";
                textarea.setText(showExpression);
                isequal = false;
            }
        });
        seven.setOnAction(e -> {

            char ch = ' ';
            if (!showExpression.equals("")) {
                ch = showExpression.charAt(showExpression.length() - 1);
            }
            if ((ch != ')' && isSquare == false)) {
                showExpression += "7";
                hiddenExpression += "7";
                textarea.setText(showExpression);
            }
            if (isequal) {
                showExpression = "7";
                hiddenExpression = "7";
                textarea.setText(showExpression);
                isequal = false;
            }
        });
        ///////////////////////////////////////////////////////////////// eight button is clicked
        /**
         * when click on button 8 we check if last character is not ')' and is
         * square is false set 8 to show expression and set 8 to hidden
         * expression that we calculate later
         */
        eight.setOnAction(e -> {

            char ch = ' ';
            if (!showExpression.equals("")) {
                ch = showExpression.charAt(showExpression.length() - 1);
            }
            if ((ch != ')' && isSquare == false)) {
                showExpression += "8";
                hiddenExpression += "8";
                textarea.setText(showExpression);
            }
            if (isequal) {
                showExpression = "8";
                hiddenExpression = "8";
                textarea.setText(showExpression);
                isequal = false;
            }

        });
        ///////////////////////////////////////////////////////////////// nine button is clicked
        /**
         * when click on button 9 we check if last character is not ')' and is
         * square is false set 9 to show expression and set 9 to hidden
         * expression that we calculate later
         */
        nine.setOnAction(e -> {

            char ch = ' ';
            if (!showExpression.equals("")) {
                ch = showExpression.charAt(showExpression.length() - 1);
            }
            if ((ch != ')' && isSquare == false)) {
                showExpression += "9";
                hiddenExpression += "9";
                textarea.setText(showExpression);
            }
            if (isequal) {
                showExpression = "9";
                hiddenExpression = "9";
                textarea.setText(showExpression);
                isequal = false;
            }
        });
        ///////////////////////////////////////////////////////////////// Zero button is clicked
        /**
         * when click on button 0 we check if last character is not ')' and is
         * not / and is not % because we can't divide by zero and is square is
         * false set 0 to show expression and set 0 to hidden expression that we
         * calculate later
         */

        zero.setOnAction(e -> {

            char ch = ' ';
            if (!showExpression.equals("")) {
                ch = showExpression.charAt(showExpression.length() - 1);
            }
            if ((ch != ')' && isSquare == false)) {
                showExpression += "0";
                hiddenExpression += "0";
                textarea.setText(showExpression);

            }
            if (isequal) {
                showExpression = "0";
                hiddenExpression = "0";
                textarea.setText(showExpression);
                isequal = false;
            }
        });
        ///////////////////////////////////////////////////////////////// dot button is clicked
        /**
         * when click on button . we check if last character is not ')' and is
         * square is false set 0 to show expression and set 0 to hidden
         * expression that we calculate later
         */
        dot.setOnAction(e -> {

            	 char ch = ' ';
             if (!showExpression.equals("")) {
                 ch = showExpression.charAt(showExpression.length() - 1);
             }
             if ((ch != ')' && isSquare == false && Character.isDigit(ch))) {

                 showExpression += ".";
                 hiddenExpression += ".";
                 textarea.setText(showExpression);
             }
            else if(isequal||showExpression.equals("")){
            	 showExpression = "0.";
                 hiddenExpression = "0.";
                 textarea.setText(showExpression);
                 isequal=false;
             }
            
             else
            {
                showExpression += "0.";
                 hiddenExpression += "0.";
                 textarea.setText(showExpression);
                 isequal=false;
            }
            
	
		 });
        ///////////////////////////////////////////////////////////////// plus button is clicked
        /**
         * when click on button + we check set + to show expression and set + to
         * hidden expression that we calculate later
         */
        plus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                char ch = ' ';
               
                  ch = showExpression.charAt(showExpression.length() - 1);
        if(ch=='.'){
            hiddenExpression+='0';
            ch='0';
        }
         if(isequal){
             if(showExpression.equals("error expression")){
                 showExpression = "";
         hiddenExpression = "";
         isSquare=false;
             }
             else{
    	 showExpression += "+";
         hiddenExpression += "+";
         textarea.setText(showExpression);
         isequal=false;
           isSquare=false;
         
             }
               }
         else if(ch==')'||ch=='.'){
           isSquare=false;
      showExpression += "+";
     hiddenExpression += "+";
         textarea.setText(showExpression);
     }
         else if(ch=='('){}
         else if (!Character.isDigit(ch)){}
         else{
	 showExpression += "+";
     hiddenExpression += "+";
     textarea.setText(showExpression);
     isSquare = false;	 
     }
          if(ch=='i')
                    {
                    
                    showExpression += "+";
                        hiddenExpression += "+";
                        textarea.setText(showExpression);
                        isSquare = false;
                    
                    }
       // if (!Character.isDigit(ch)){}

            }
                 catch(Exception e)
                {
                }
            }
        });
        ///////////////////////////////////////////////////////////////// minus button is clicked
        /**
         * when click on button - we check set - to show expression and set - to
         * hidden expression that we calculate later
         */
        minus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                
                    char ch = ' ';
                    char ch1 = ' ';
               if(!showExpression.equals("")){
                  ch = showExpression.charAt(showExpression.length() - 1);
                    if(ch=='.'){
            hiddenExpression+='0';
            ch='0';
        }
             if(ch=='-'){
             ch1 = showExpression.charAt(showExpression.length() - 2);
             if(ch1=='-'){
                        showExpression = "error expression";
                        hiddenExpression = "error expression";
                        textarea.setText(showExpression);
                        isequal=true;
                       
                        
             }
             }  
               }
                   
                    if (isequal) {
                        if (showExpression.equals("error expression")) {
                            showExpression = "";
                            hiddenExpression = "";
                        } else {
                            showExpression += "-";
                            hiddenExpression += "-";
                            textarea.setText(showExpression);
                            isequal = false;
                        }
                    } else if (showExpression == "") {
                        
                            showExpression += "-";
                            hiddenExpression += "-";
                            textarea.setText(showExpression);
                    } 
                   
                    else {
                        showExpression += "-";
                        hiddenExpression += "-";
                        textarea.setText(showExpression);
                        isSquare = false;
                    
                    }
                    
                    
                } catch (Exception e) {
                }
            }
        });
        ///////////////////////////////////////////////////////////////// div button is clicked
        /**
         * action of button / when we clicked on this is what be happen
         */
        div.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                       isequal = false;
                    char ch = showExpression.charAt(showExpression.length() - 1);
                    if(ch=='.'){
            hiddenExpression+='0';
            ch='0';
        }
                    if (isequal) {
                        if (showExpression.equals("error expression")) {
                            showExpression = "";
                            hiddenExpression = "";
                        } else {
                            showExpression += "/";
                            hiddenExpression += "/";
                            textarea.setText(showExpression);
                            isequal = false;
                        }
                    } else if (Character.isDigit(ch) || ch == ')') {
                        showExpression += "/";
                        hiddenExpression += "/";
                        textarea.setText(showExpression);
                        isSquare = false;
                    } else if (showExpression == "") {
//    	 showExpression = "0/";
//         hiddenExpression = "0/";
//         textarea.setText(showExpression); 
                    }
                     if(ch=='.'){
                         showExpression += "/";
                        hiddenExpression += "/";
                        textarea.setText(showExpression);
                        isSquare = false;
                    }
                      if(ch=='i')
                    {
                    
                    showExpression += "/";
                        hiddenExpression += "/";
                        textarea.setText(showExpression);
                        isSquare = false;
                    
                    }
                } catch (Exception e) {
                }

            }
        });
        ///////////////////////////////////////////////////////////////// mul button is clicked
        /**
         * action of button * when we clicked on this is what be happen
         */
        mul.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
   isequal = false;
                    char ch = showExpression.charAt(showExpression.length() - 1);
                 if(ch=='.'){
            hiddenExpression+='0';
            ch='0';
        }
                    if (isequal) {
                        if (showExpression.equals("error expression")) {
                            showExpression = "";
                            hiddenExpression = "";
                        } else {
                            showExpression += "*";
                            hiddenExpression += "*";
                            textarea.setText(showExpression);
                            isequal = false;
                        }
                    } else if (Character.isDigit(ch) || ch == ')') {
                        showExpression += "*";
                        hiddenExpression += "*";
                        textarea.setText(showExpression);
                        isSquare = false;
                    } else if (showExpression == "") {
//    	 showExpression = "0*";
//         hiddenExpression = "0*";
//         textarea.setText(showExpression); 
                    }
                     if(ch=='.'){
                         showExpression += "*";
                        hiddenExpression += "*";
                        textarea.setText(showExpression);
                        isSquare = false;
                    }
                      if(ch=='i')
                    {
                    
                    showExpression += "*";
                        hiddenExpression += "*";
                        textarea.setText(showExpression);
                        isSquare = false;
                    
                    }
                } catch (Exception e) {
                }

            }

        });
        ///////////////////////////////////////////////////////////////// mod button is clicked
        /**
         * action of button % when we clicked on this is what be happen
         */
        mod.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                       isequal = false;
                    char ch = showExpression.charAt(showExpression.length() - 1);
                    if(ch=='.'){
            hiddenExpression+='0';
            ch='0';
        }
                    if (isequal) {
                        if (showExpression.equals("error expression")) {
                            showExpression = "";
                            hiddenExpression = "";
                        } else {
                            showExpression += "%";
                            hiddenExpression += "%";
                            textarea.setText(showExpression);
                            isequal = false;
                        }
                    } else if (Character.isDigit(ch) || ch == ')') {

                        showExpression += "%";
                        hiddenExpression += "%";
                        textarea.setText(showExpression);
                        isSquare = false;
                    }
                    if (showExpression == "") {
//    	 showExpression = "0%";
//         hiddenExpression = "0%";
//         textarea.setText(showExpression); 
                    }
                     if(ch=='.'){
                         showExpression += "%";
                        hiddenExpression += "%";
                        textarea.setText(showExpression);
                        isSquare = false;
                    }
                      if(ch=='i')
                    {
                    
                    showExpression += "%";
                        hiddenExpression += "%";
                        textarea.setText(showExpression);
                        isSquare = false;
                    
                    }
                } catch (Exception e) {
                }
            }
        });
///////////////////////////////////////////////////////////////// sqrt button is clicked
        /**
         * action of button أ¢ث†ع‘ when we clicked on this is what be happen
         */
        sqrt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                       isequal = false;
                    char ch = ' ';
                    if (!showExpression.equals("")) {
                        ch = showExpression.charAt(showExpression.length() - 1);
                        
                    }
                    if(ch=='.'){
            hiddenExpression+='0';
            ch='0';
                   }
                    if (showExpression.equals("")) {
                        showExpression += "âˆڑ";
                        hiddenExpression += "|";
                        textarea.setText(showExpression);
                        isequal=false;
                    } else if (!Character.isDigit(ch) && isSquare == false && ch != ')'&& ch != '?') {

                        showExpression += "âˆڑ";
                        hiddenExpression += "|";
                        textarea.setText(showExpression);
                        isequal=false;

                    }
                   if (Character.isDigit(ch))
                   {
                    showExpression += "âˆڑ";
                        hiddenExpression += "*|";
                   textarea.setText(showExpression);
                   }
                    if(ch=='i')
                    {
                    
                    showExpression += "âˆڑ";
                        hiddenExpression += "âˆڑ";
                        textarea.setText(showExpression);
                        isSquare = false;
                    
                    }
                } catch (Exception e) {
                }
            }

        });
        textarea.setEditable(false);

///////////////////////////////////////////////////////////////// square button is clicked
        /**
         * action of button ^2 when we clicked on this is what be happen
         */
        square.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
               try {
                      isequal = false;
	char lastChar=' ';
        int index=0;
if(!showExpression.equals(""))
 lastChar = showExpression.charAt(showExpression.length() - 1);
if(lastChar=='.'){
            hiddenExpression+='0';
        }
if (Character.isDigit(lastChar)) {
String number = "";
String swapNumber = "";
String str = hiddenExpression;
//String str = hiddenExpression;

for (int i = str.length()-1; i >= 0; i--) {
char ch = str.charAt(i);
if (Character.isDigit(ch)) {
number += ch;
}
else if( ch=='.'){
    number+=".";
}
else {
    index=i+1;
break;
}
}
for (int i = number.length()-1; i >= 0; i--) {
    
char ch = number.charAt(i);
swapNumber += ch;
}
double temp=Double.parseDouble(swapNumber)*Double.parseDouble(swapNumber);
//hiddenExpression += "*" + Double.parseDouble(number);
hiddenExpression=hiddenExpression.substring(0, index);
hiddenExpression+=temp;
showExpression += "^2";
textarea.setText(showExpression);
isSquare = true;} 
}  catch (Exception e) {
    showExpression="";
    hiddenExpression="";
    textarea.setText("error");
                }
            }

        });
        ///////////////////////////////////////////////////////////////// del button is clicked
        /**
         * action of button delete when we clicked on this is what be happen
         * that delete last character in showExpression and hiddenExpression to
         * begin again
         */
     clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (showExpression.equals("error expression")) {
                        textarea.clear();
                    }
                    char ch = ' ';
                    if (!showExpression.equals("")) {
                        ch = showExpression.charAt(showExpression.length() - 1);
                    }
                    if (ch == ')') {
                        countClose--;
                    } else if (ch == '(') {
                        countOpen--;
                        if (countOpen == 0);
                        isOpen = false;
                    }
                    isequal=false;
                    String str = textarea.getText();
                    String newStr = str.substring(0, showExpression.length() - 1);
                    showExpression = newStr;
                    hiddenExpression = hiddenExpression.substring(0, hiddenExpression.length() - 1);
                    textarea.setText(showExpression);

                } catch (Exception e) {
                      showExpression="";
    hiddenExpression="";
    textarea.setText("error");
                }
            }

        });
         ans.setOnAction(e -> {
        if(!isequal)
        {
        showExpression+=answer;
        hiddenExpression+=answer;
         textarea.setText(showExpression);
        isequal=false;
        }
        
        });
        ///////////////////////////////////////////////////////////////// reset button is clicked
        /**
         * action of button reset when we clicked on this is what be happen that
         * clear showExpression and hiddenExpression to begin again
         */
        reset.setOnAction(e -> {

            textarea.setText("");
            showExpression = "";
            hiddenExpression = "";
            isOpen = false;
            isSquare = false;
            countClose = 0;
            countOpen = 0;

        });
        open.setOnAction(e -> {
            char ch1 = ' ';
                isequal=false;
            if (showExpression.equals("error expression")) {
                showExpression = "";
                hiddenExpression = "";
            
            }
            if (!showExpression.equals("")) {
                ch1 = showExpression.charAt(showExpression.length() - 1);
                 if(ch1=='.'){
            hiddenExpression+='0';
            showExpression+='0';
            ch1='0';
        }
            }
            if (((!Character.isDigit(ch1) && isSquare == false) && ch1 != ')') || ch1 == ' ') {
                showExpression += "(";
                hiddenExpression += "(";
                textarea.setText(showExpression);
                isOpen = true;
                countOpen++;
            }
            if(Character.isDigit(ch1)){
            showExpression += "*(";
                hiddenExpression += "*(";
                textarea.setText(showExpression);
                isOpen = true;
                countOpen++;
            
            }
        });
        ///////////////////////////////////////////////////////////////// close brackets button is clicked
        /**
         * action of close brackets button and not close if another bracket not
         * open
         */
        close.setOnAction(e -> {
            char ch1 = ' ';
            if (!showExpression.equals("")) {
                 ch1 = showExpression.charAt(showExpression.length() - 1);
                 if(ch1=='.')
                 {
                 hiddenExpression+="0";
         
                 ch1='0';
                 
                 }
             }
                     if (ch1=='(') {
                  textarea.setText("error expression");
                  showExpression = "";
         hiddenExpression = "";
         isOpen=false;
                 
             }
		if (isOpen) {
                             if(ch1=='.')
                             {
                             showExpression += ")";
                 hiddenExpression += ")";
                 textarea.setText(showExpression);
                 countClose++;
                             }
              else if(!Character.isDigit(ch1)&&ch1!=')'){}
                      
                              else{
                 showExpression += ")";
                 hiddenExpression += ")";
                 textarea.setText(showExpression);
                 countClose++;
             }
                         }
                
		 });
        ///////////////////////////////////////////////////////////////// equal button is clicked
        /**
         * action of equal button when clicked on evaluate arithmetic expression
         * that user enter in text area
         */
        equal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                char ch=' ';
              isequal=true;
                try {
         
                    if (countClose != countOpen) {
                        textarea.setText("error expression");
                        showExpression = "";
                        hiddenExpression = "";
                    } else {
                        ch = showExpression.charAt(showExpression.length() - 1);
                    if(ch=='.'){
            hiddenExpression+='0';
        }             //
                        EvaluteExpression ev = new EvaluteExpression();
                        hiddenExpression = ev.brackets(hiddenExpression);
                        answer=hiddenExpression;
                        textarea.setText(hiddenExpression);
                        showExpression = hiddenExpression;
//                 if(fdiv==1 || fmin==1|| fmod==1||fmul==1||fplus==1||fsqrt==1||fsquare==1){
//                 //showExpression = hiddenExpression;
//                 
//                 }else{.
//                 showExpression ="";
//                 hiddenExpression="";
//                 }

                        
                    }
                } catch (Exception e) {
                      showExpression="";
    hiddenExpression="";
    textarea.setText("error");
                }
            }
        });
        return vbox;

    }

    /**
     * main method that run application
     * @param args
     */
    public static void main(String[] args) {
        


        Application.launch(args);
    }
}

/**
 * inner class evaluate expression that contain methods for evaluate expressions
 *
 * @author Anonymous
 */
class EvaluteExpression {

    ArrayList<String> contents;
    String item;
    EvaluteExpression check;

    /**
     * this method for evaluate first brackets because brackets is more priority
     *
     * @param <E>
     * @param e
     * @return
     */
    public <E> E brackets(E e) {
        check = new EvaluteExpression();
        String s = e.toString();
        while (s.contains(Character.toString('(')) || s.contains(Character.toString(')'))) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    for (int j = i; j >= 0; j--) {
                        if (s.charAt(j) == '(') {
                            String in = s.substring(j + 1, i);
                            in = check.recognize(in);
                            s = s.substring(0, j) + in + s.substring(i + 1);
                            j = i = 0;
                        }
                    }
                }
            }

        }
        s = check.recognize(s);
        return (E) s;
    }

    /**
     * method for dismount expression and rearrange expression to be prepared
     * for evaluating
     *
     * @param <E>
     * @param e
     * @return
     */
    public <E> E recognize(E e) {
        PutIt putIt = new PutIt();
        contents = new ArrayList<String>();
        String s = e.toString();
        item = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isDigit(s.charAt(i))) {
                item = s.charAt(i) + item;
                if (i == 0) {
                    putIt.put();
                }
            } else {
                if (s.charAt(i) == '.') {
                    item = s.charAt(i) + item;
                } else if (s.charAt(i) == '-' && (i == 0 || (!Character.isDigit(s.charAt(i - 1))))) {
                    item = s.charAt(i) + item;
                    putIt.put();
                } else {
                    putIt.put();
                    item += s.charAt(i);
                    putIt.put();
                    if (s.charAt(i) == '|') {
                        item += " ";
                        putIt.put();
                    }
                }
            }
        }
        contents = putIt.result(contents, "@", "&");
        contents = putIt.result(contents, "#", "!");
        contents = putIt.result(contents, "^", "%");
        contents = putIt.result(contents, "|", "$");
        contents = putIt.result(contents, "*", "/");
        contents = putIt.result(contents, "+", "-");
        return (E) contents.get(0);
    }

    /**
     * inner class contains methods that filter expression and using math java
     * classes for evaluate expression
     */
    public class PutIt {

        /**
         * method that prepare final arithmetic statment
         */
        public void put() {
            if (!item.equals("")) {
                contents.add(0, item);
                item = "";
            }
        }

        /**
         * method that we send to it array list contains arithmetic statment and
         * 2 operators and evaluate expressions of this operators and return
         * array list of after evaluate
         * @param arrayList
         * @param op1
         * @param op2
         * @return
         */
        public ArrayList<String> result(ArrayList<String> arrayList, String op1, String op2) {
            int scale = 5;
            String e = "";
            BigDecimal result = new BigDecimal(0);
            for (int c = 0; c < arrayList.size(); c++) {
                if (arrayList.get(c).equals(op1) || arrayList.get(c).equals(op2)) {
                     if (arrayList.get(c).equals("@")) {
                        result = new BigDecimal(Math.sin((Double.parseDouble(arrayList.get(c + 1)))*(Math.PI/180)));
                    }
                    else if (arrayList.get(c).equals("&")) {
                        result = new BigDecimal(Math.cos((Double.parseDouble(arrayList.get(c + 1)))*(Math.PI/180)));
                    }
                    else if (arrayList.get(c).equals("#")) {
                        result = new BigDecimal(Math.tan((Double.parseDouble(arrayList.get(c + 1)))*(Math.PI/180)));
                    }
                   else if (arrayList.get(c).equals("|")) {
                        result = new BigDecimal(Math.sqrt(Double.parseDouble(arrayList.get(c + 1))));
                    } 
                else if (arrayList.get(c).equals("*")) {
                        result = new BigDecimal(arrayList.get(c - 1)).multiply(new BigDecimal(arrayList.get(c + 1)));
                    } else if (arrayList.get(c).equals("/")) {
                        if (arrayList.get(c + 1).equals("0")) {//divide by zero
                            e = "error expression";
                            arrayList.clear();
                            arrayList.add(e);
                            return arrayList;
                        } else if (arrayList.get(c + 1).equals(".")) {
                            e = "error expression";
                            arrayList.clear();
                            arrayList.add(e);
                            return arrayList;
                        }
                        result = new BigDecimal(arrayList.get(c - 1)).divide(new BigDecimal(arrayList.get(c + 1)), scale, BigDecimal.ROUND_DOWN);
                    } else if (arrayList.get(c).equals("+")) {
                        result = new BigDecimal(arrayList.get(c - 1)).add(new BigDecimal(arrayList.get(c + 1)));
                    } else if (arrayList.get(c).equals("-")) {
                        result = new BigDecimal(arrayList.get(c - 1)).subtract(new BigDecimal(arrayList.get(c + 1)));
                    } else if (arrayList.get(c).equals("%")) {
                         if (arrayList.get(c + 1).equals("0")) {//divide by zero
                            e = "error expression";
                            arrayList.clear();
                            arrayList.add(e);
                            return arrayList;
                        } 
                         else
                        result = new BigDecimal(arrayList.get(c - 1)).remainder(new BigDecimal(arrayList.get(c + 1)));
                    }
              
                    try {
                        if(arrayList.get(c).equals("@") || arrayList.get(c).equals("#")||arrayList.get(c).equals("&"))
                        {
                          arrayList.set(c, (result.setScale(scale, RoundingMode.HALF_DOWN).
                                stripTrailingZeros().toPlainString()));
                               arrayList.remove(c + 1);
                               
                        
                        }
                        else{
                        arrayList.set(c, (result.setScale(scale, RoundingMode.HALF_DOWN).
                                stripTrailingZeros().toPlainString()));
                        arrayList.remove(c + 1);
                        arrayList.remove(c - 1);
                        }
                    } catch (Exception ignored) {
                        Calculator cal=new Calculator();
                          cal.showExpression="";
                         cal.hiddenExpression="";
                       cal.textarea.setText("error");
                    }
                } else {
                    continue;
                }
                c = 0;
            }
            return arrayList;
        }
    }
}

