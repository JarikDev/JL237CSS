package com;


import com.aquafx_project.AquaFx;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.event.HyperlinkListener;
import javax.swing.plaf.MenuBarUI;
import javax.swing.plaf.MenuItemUI;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.FileInputStream;

import static javafx.application.Application.launch;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);
//        Application.setUserAgentStylesheet(STYLESHEET_MODENA);
  //      Application.setUserAgentStylesheet(getClass().getResource("sampl.css").toExternalForm());
         AquaFx.style();

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(new Label("Label"));
        flowPane.getChildren().addAll(new Button("Button"));

        //radio button
        ToggleGroup group = new ToggleGroup();
        RadioButton rb1 = new RadioButton("one");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("two");
        rb2.setToggleGroup(group);
        RadioButton rb3 = new RadioButton("three");
        rb3.setToggleGroup(group);
        flowPane.getChildren().addAll(rb1, rb2, rb3);

        flowPane.getChildren().add(new ToggleButton("toggle"));
        flowPane.getChildren().add(new CheckBox("check box"));
        flowPane.getChildren().add(new ChoiceBox<String>(FXCollections.observableArrayList("First", "Second", "Third")));
        flowPane.getChildren().add(new TextField("Text field"));
    //    flowPane.getChildren().add(new PasswordField());

        ScrollBar sc = new ScrollBar();
        sc.setMin(0);
        sc.setMax(100);
        sc.setValue(50);
        flowPane.getChildren().add(sc);

        /*Image roses=new Image(new FileInputStream("path"));
        ScrollPane sp=new ScrollPane();
        sp.setContent(new ImageView(roses));
        flowPane.getChildren().add(sp);*/

        ListView<String> list = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList("Single", "Double", "Suite", "Family App");
        list.setItems(items);
        list.setMaxHeight(100);
        flowPane.getChildren().add(list);

        TreeItem<String> rootItem = new TreeItem<String>("Inbox");
        rootItem.setExpanded(true);
        for (int i = 0; i < 6; i++) {
            TreeItem<String> item = new TreeItem<String>("Message" + i);
            rootItem.getChildren().add(item);
        }
        TreeView<String> tree = new TreeView<>(rootItem);
        tree.setMaxHeight(100);
        flowPane.getChildren().add(tree);

        ObservableList<String> options = FXCollections.observableArrayList("Option 1", "Option 2", "Option 3");
        ComboBox comboBox = new ComboBox(options);
        flowPane.getChildren().add(comboBox);

        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        flowPane.getChildren().add(separator);

        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(40);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(500);
        slider.setMinorTickCount(5);
        slider.setBlockIncrement(10);
        flowPane.getChildren().add(slider);

        ProgressBar pb = new ProgressBar(0.6);
        ProgressIndicator pi = new ProgressIndicator(0.6);
        flowPane.getChildren().add(pb);
        flowPane.getChildren().add(pi);

        Hyperlink link = new Hyperlink();
        link.setText("http://google.com");
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("This link is clicked");
            }
        });
        flowPane.getChildren().add(link);
        Tooltip tooltip = new Tooltip();
        tooltip.setText("This is link to google");
        link.setTooltip(tooltip);

        HTMLEditor htmlEditor = new HTMLEditor();
        htmlEditor.setPrefHeight(245);
        flowPane.getChildren().add(htmlEditor);

        TitledPane tp = new TitledPane("My titled pane", new Button("Button"));
        flowPane.getChildren().add(tp);

        Accordion accordion = new Accordion();
        accordion.getPanes().addAll(tp, new TitledPane("Second", new TextField("Text field")));
        accordion.setExpandedPane(tp);
        flowPane.getChildren().addAll(accordion);

        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        MenuItem menuItem = new MenuItem("Open");
        MenuItem menuItem2 = new MenuItem("Save");
        menuFile.getItems().addAll(menuItem, menuItem2);
        MenuItem menuItem3 = new MenuItem("Cut");
        MenuItem menuItem4 = new MenuItem("Copy");
        menuEdit.getItems().addAll(menuItem3, menuItem4);
        menuBar.getMenus().addAll(menuFile, menuEdit);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(menuBar, flowPane);

        ColorPicker colorPicker1 = new ColorPicker();
        flowPane.getChildren().add(colorPicker1);

        Pagination pagination1 = new Pagination();
        flowPane.getChildren().add(pagination1);

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource Files");

        Button button = new Button("Open dialog");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fileChooser.showOpenDialog(primaryStage);
            }
        });
        flowPane.getChildren().add(button);

        Group root = new Group();
        root.getChildren().add(vBox);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
