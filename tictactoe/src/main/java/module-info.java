module myprojects.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;

    opens myprojects.tictactoe.interfaces to javafx.fxml;
    exports myprojects.tictactoe.interfaces;
}
