package main.Frontend.PopUps.TextArea;

import main.Backend.StringMatcher.MatchElement.IMatchElement;

public interface ISearchableTextArea {
    IMatchElement Search(String toSearch);
}
