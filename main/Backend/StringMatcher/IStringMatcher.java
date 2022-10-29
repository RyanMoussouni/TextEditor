package main.Backend.StringMatcher;

import main.Backend.StringMatcher.MatchElement.IMatchElement;

import java.util.List;

public interface IStringMatcher {
    List<IMatchElement> match(String toMatch, String key);
}
