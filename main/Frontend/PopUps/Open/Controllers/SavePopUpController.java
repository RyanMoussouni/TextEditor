package main.Frontend.PopUps.Open.Controllers;

import main.Frontend.MainFrame.MyFrame;
import main.Frontend.PopUps.Open.Model.IFileExplorer;
import main.Frontend.PopUps.Open.Vues.Frames.AbstractPopUpFrame;

public class SavePopUpController extends AbstractPopUpController{

    public SavePopUpController(MyFrame mainFrame, AbstractPopUpFrame abstractPopUpFrame, IFileExplorer fileExplorer) {
        super(mainFrame, abstractPopUpFrame, fileExplorer);
    }

    @Override
    protected void doubleClickOnFile() {
        //TODO: for now, does nothing but in the future should display ....
    }
}
