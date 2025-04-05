public class Player {
    String name;
    char sign;

    Player(String _name, char _sign) {
        name = _name;
        sign = _sign;
    }

    String getDisplayName() {
        return name + " (" + sign + ")";
    }
}
