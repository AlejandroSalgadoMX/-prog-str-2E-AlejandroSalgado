module com.login.login_dashboard {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.login.login_dashboard to javafx.fxml;
    exports com.login.login_dashboard;

    opens com.login.login_dashboard.controllers to javafx.fxml;
    exports com.login.login_dashboard.controllers;
}