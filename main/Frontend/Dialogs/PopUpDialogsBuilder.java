package main.Frontend.Dialogs;

import main.Frontend.Main.MainFrameBuilder;

public class PopUpDialogsBuilder {

    public static void build() {
        var mainFrame = MainFrameBuilder.mainFrame;
        var optionalRelativeComponent = MainFrameBuilder.finder.find("Scroll Panel");

        if (mainFrame == null) {
            var exceptionMessage = "The MainFrame has not been set."
                    + " This is not an expected behavior";
            throw new RuntimeException(exceptionMessage);
        }

        if (optionalRelativeComponent.isEmpty()) {
            var exceptionMessage = "The relative component has not been found"
                    + " This is not an expected behavior";
            throw new RuntimeException(exceptionMessage);
        }

        var isGUIResizable = mainFrame.isResizable();
        if (isGUIResizable) {
            var exceptionMessage = "The main frame being resizable is not part of the specifications"
                    + " This could lead to unexpected behavior";
            throw new RuntimeException(exceptionMessage);
        }

        var relativeComponent = optionalRelativeComponent.get();

        FindDialogBuilder.build(mainFrame, relativeComponent);
        ReplaceDialogBuilder.build(mainFrame, relativeComponent);
    }
}
