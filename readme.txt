How to setup JavaFX on Eclipse
https://www.youtube.com/watch?v=bk28ytggz7E


TIP:
===
In Eclipse
Window > Preferences > Java > Installed JREs
Select the JDK
Click Edit

Add the module path and modules (the next line assumes your JavaFX folder is called javafx-sdk-19.0.2.1 and is in the C:\Java directory).
--module-path="C:\Java\javafx-sdk-19.0.2.1\lib" --add-modules=javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web

Doing this means that every runnable JavaFX class will work without having to configure each run configuration.