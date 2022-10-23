package main.Matches;

public class MatchElement implements IMatchElement{
    private String _key;
    private int _position;

    public MatchElement(String key, int position){
        _key = key;
        _position = position;
    }
    @Override
    public int getPosition() {
        return _position;
    }

    @Override
    public String getKey(){
        return _key;
    }
}
