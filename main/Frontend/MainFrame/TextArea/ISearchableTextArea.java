package main.Frontend.MainFrame.TextArea;

import main.Backend.StringMatcher.MatchElement.IMatchElement;

public interface ISearchableTextArea {
    IMatchElement Search(String toSearch);
}
