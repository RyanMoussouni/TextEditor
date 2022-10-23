package main.StringMatcher;

import main.Matches.IMatchElement;

import java.util.List;

public interface IStringMatcher {
    List<IMatchElement> match(String toMatch, String key);
}
