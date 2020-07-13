package model;

public enum ClassEnum {
    FIRST_A("1A"), FIRST_B("1B"), FIRST_V("1V"), FIRST_G("1G"), FIRST_D("1D"),
    FIRST_E("1E"),
    SECOND_A("2A"), SECOND_B("2B"), SECOND_V("2V"), SECOND_G("2G"),
    SECOND_D("2D"), SECOND_E("2E"),
    THIRD_A("3A"), THIRD_B("3B"), THIRD_V("3V"), THIRD_G("3G"), THIRD_D("3D"),
    THIRD_E("3E"),
    FOURTH_A("4A"), FOURTH_B("4B"), FOURTH_V("4V"), FOURTH_G("4G"),
    FOURTH_D("4D"), FOURTH_E("4E"),
    FIFTH_A("5A"), FIFTH_B("5B"), FIFTH_V("5V"), FIFTH_G("5G"), FIFTH_D("5D"),
    FIFTH_E("5E"),
    SIXTH_A("6A"), SIXTH_B("6B"), SIXTH_V("6V"), SIXTH_G("6G"), SIXTH_D("6D"),
    SIXTH_E("6E"),
    SEVENTH_A("7A"), SEVENTH_B("7B"), SEVENTH_V("7V"), SEVENTH_G("7G"),
    SEVENTH_D("7D"), SEVENTH_E("7E"),
    EIGHTH_A("8A"), EIGHTH_B("8B"), EIGHTH_V("8V"), EIGHTH_G("8G"),
    EIGHTH_D("8D"), EIGHTH_E("8E"),
    NINTH_A("9A"), NINTH_B("9B"), NINTH_V("9V"), NINTH_G("9G"), NINTH_D("9D"),
    NINTH_E("9E"),
    TENTH_A("10A"), TENTH_B("10B"), TENTH_V("10V"), TENTH_G("10G"),
    TENTH_D("10D"), TENTH_E("10E"),
    ELEVENTH_A("11A"), ELEVENTH_B("11B"), ELEVENTH_V("11V"), ELEVENTH_G("11G"),
    ELEVENTH_D("11D"), ELEVENTH_E("11E");

    private String number;

    ClassEnum(String number) {
        this.number = number;
    }
    public String getNumber(){
        return number;
    }
}
